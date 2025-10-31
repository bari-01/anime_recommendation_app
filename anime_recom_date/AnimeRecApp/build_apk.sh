#!/bin/bash

# Android APK Build Script for Linux
# This script sets up Android SDK and builds the AnimeMate APK

set -e  # Exit on error

echo "======================================"
echo "AnimeMate Android Build Script"
echo "======================================"

# Configuration
ANDROID_SDK_ROOT="${ANDROID_SDK_ROOT:-$HOME/Android/Sdk}"
ANDROID_HOME="$ANDROID_SDK_ROOT"
ANDROID_SDK_VERSION="35"
ANDROID_BUILD_TOOLS_VERSION="35.0.0"
CMDLINE_TOOLS_VERSION="11076708"
CMDLINE_TOOLS_URL="https://dl.google.com/android/repository/commandlinetools-linux-${CMDLINE_TOOLS_VERSION}_latest.zip"

# Java version check
echo "Checking Java version..."
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | awk -F '"' '{print $2}' | awk -F '.' '{print $1}')
if [ "$JAVA_VERSION" -lt 17 ]; then
    echo "Error: Java 17 or higher is required. Current version: $JAVA_VERSION"
    echo "Please install Java 17:"
    echo "  sudo apt-get update"
    echo "  sudo apt-get install openjdk-17-jdk"
    exit 1
fi
echo "Java version: OK (Java $JAVA_VERSION)"

# Check if Android SDK is already installed
if [ ! -d "$ANDROID_SDK_ROOT" ]; then
    echo ""
    echo "Android SDK not found at: $ANDROID_SDK_ROOT"
    echo "Installing Android SDK command-line tools..."
    
    # Create SDK directory
    mkdir -p "$ANDROID_SDK_ROOT/cmdline-tools"
    cd "$ANDROID_SDK_ROOT/cmdline-tools"
    
    # Download command-line tools
    echo "Downloading Android command-line tools..."
    wget -q --show-progress "$CMDLINE_TOOLS_URL" -O commandlinetools.zip
    
    # Extract tools
    echo "Extracting command-line tools..."
    unzip -q commandlinetools.zip
    mv cmdline-tools latest
    rm commandlinetools.zip
    
    # Set environment variables
    export PATH="$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$PATH"
    export PATH="$ANDROID_SDK_ROOT/platform-tools:$PATH"
    
    echo "Installing Android SDK components..."
    yes | sdkmanager --licenses || true
    sdkmanager "platform-tools" "platforms;android-${ANDROID_SDK_VERSION}" "build-tools;${ANDROID_BUILD_TOOLS_VERSION}"
    
    echo "Android SDK installed successfully!"
else
    echo "Android SDK found at: $ANDROID_SDK_ROOT"
    export PATH="$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$PATH"
    export PATH="$ANDROID_SDK_ROOT/platform-tools:$PATH"
fi

# Export environment variables
export ANDROID_SDK_ROOT
export ANDROID_HOME

echo ""
echo "Environment setup:"
echo "  ANDROID_SDK_ROOT: $ANDROID_SDK_ROOT"
echo "  ANDROID_HOME: $ANDROID_HOME"
echo "  Java Home: $(dirname $(dirname $(readlink -f $(which java))))"

# Navigate to project directory
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$SCRIPT_DIR"

echo ""
echo "Building project at: $PROJECT_DIR"
cd "$PROJECT_DIR"

# Make gradlew executable
chmod +x gradlew

# Clean build
echo ""
echo "Cleaning previous builds..."
./gradlew clean --no-daemon

# Build debug APK
echo ""
echo "Building debug APK..."
./gradlew assembleDebug --no-daemon --stacktrace

# Build release APK (unsigned)
echo ""
echo "Building release APK..."
./gradlew assembleRelease --no-daemon --stacktrace || echo "Release build failed (this is expected without signing keys)"

echo ""
echo "======================================"
echo "Build Complete!"
echo "======================================"

# Find and display APK locations
echo ""
echo "APK files generated:"
find "$PROJECT_DIR/app/build/outputs/apk" -name "*.apk" -type f | while read apk; do
    echo "  - $apk"
    echo "    Size: $(du -h "$apk" | cut -f1)"
done

echo ""
echo "To install the debug APK on a device:"
echo "  adb install -r app/build/outputs/apk/debug/app-debug.apk"
echo ""
echo "Or transfer the APK to your Android device and install manually."
