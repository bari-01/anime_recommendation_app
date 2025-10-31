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
ANDROID_SDK_VERSION="34"
ANDROID_BUILD_TOOLS_VERSION="34.0.0"
CMDLINE_TOOLS_VERSION="11076708"
CMDLINE_TOOLS_URL="https://dl.google.com/android/repository/commandlinetools-linux-${CMDLINE_TOOLS_VERSION}_latest.zip"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Java version check
echo "Checking Java version..."
if ! command -v java &> /dev/null; then
    echo -e "${RED}Error: Java is not installed${NC}"
    echo "Please install Java 17 or higher:"
    echo "  Ubuntu/Debian: sudo apt-get install openjdk-17-jdk"
    echo "  Fedora/RHEL: sudo dnf install java-17-openjdk-devel"
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | head -n 1 | awk -F '"' '{print $2}' | awk -F '.' '{print $1}')
if [ "$JAVA_VERSION" -lt 17 ]; then
    echo -e "${RED}Error: Java 17 or higher is required. Current version: $JAVA_VERSION${NC}"
    echo "Please install Java 17:"
    echo "  Ubuntu/Debian: sudo apt-get install openjdk-17-jdk"
    echo "  Fedora/RHEL: sudo dnf install java-17-openjdk-devel"
    exit 1
fi
echo -e "${GREEN}✓ Java version: OK (Java $JAVA_VERSION)${NC}"

# Check if Android SDK is already installed
if [ ! -d "$ANDROID_SDK_ROOT" ]; then
    echo ""
    echo -e "${YELLOW}Android SDK not found at: $ANDROID_SDK_ROOT${NC}"
    echo "Installing Android SDK command-line tools..."
    
    # Check for required tools
    if ! command -v wget &> /dev/null && ! command -v curl &> /dev/null; then
        echo -e "${RED}Error: Neither wget nor curl found. Please install one of them.${NC}"
        exit 1
    fi
    
    if ! command -v unzip &> /dev/null; then
        echo -e "${RED}Error: unzip not found. Please install it:${NC}"
        echo "  Ubuntu/Debian: sudo apt-get install unzip"
        exit 1
    fi
    
    # Create SDK directory
    mkdir -p "$ANDROID_SDK_ROOT/cmdline-tools"
    cd "$ANDROID_SDK_ROOT/cmdline-tools"
    
    # Download command-line tools
    echo "Downloading Android command-line tools..."
    if command -v wget &> /dev/null; then
        wget -q --show-progress "$CMDLINE_TOOLS_URL" -O commandlinetools.zip
    else
        curl -# -L "$CMDLINE_TOOLS_URL" -o commandlinetools.zip
    fi
    
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
    
    echo -e "${GREEN}✓ Android SDK installed successfully!${NC}"
else
    echo -e "${GREEN}✓ Android SDK found at: $ANDROID_SDK_ROOT${NC}"
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
if ./gradlew assembleDebug --no-daemon --stacktrace; then
    echo -e "${GREEN}✓ Debug APK built successfully!${NC}"
else
    echo -e "${RED}✗ Debug build failed${NC}"
    exit 1
fi

# Build release APK (unsigned)
echo ""
echo "Building release APK..."
if ./gradlew assembleRelease --no-daemon --stacktrace; then
    echo -e "${GREEN}✓ Release APK built successfully!${NC}"
else
    echo -e "${YELLOW}⚠ Release build failed (this is expected without signing keys)${NC}"
fi

echo ""
echo "======================================"
echo "Build Complete!"
echo "======================================"

# Find and display APK locations
echo ""
echo "APK files generated:"
find "$PROJECT_DIR/app/build/outputs/apk" -name "*.apk" -type f 2>/dev/null | while read apk; do
    size=$(du -h "$apk" | cut -f1)
    echo -e "${GREEN}  ✓ $apk${NC}"
    echo "    Size: $size"
done

echo ""
echo "To install the debug APK on a device:"
echo -e "  ${YELLOW}adb install -r app/build/outputs/apk/debug/app-debug.apk${NC}"
echo ""
echo "Or transfer the APK to your Android device and install manually."
echo ""
echo -e "${GREEN}Build script completed successfully!${NC}"

