# Quick Start Guide - Building AnimeMate APK

## Prerequisites

Ensure you have **Java 17 or higher** installed:
```bash
java -version  # Should show version 17 or higher
```

If not installed:
```bash
# Ubuntu/Debian
sudo apt-get update && sudo apt-get install openjdk-17-jdk

# Fedora/RHEL  
sudo dnf install java-17-openjdk-devel
```

## Build Instructions

### Option 1: Using the Automated Build Script (Recommended)

```bash
cd anime_recom_date/AnimeRecApp
chmod +x build_apk.sh
./build_apk.sh
```

This script will:
- Verify Java 17+ is installed
- Install Android SDK if needed
- Configure environment variables
- Build debug and release APKs
- Show APK locations

### Option 2: Manual Build with Gradle

```bash
cd anime_recom_date/AnimeRecApp

# Set environment variables (adjust path if needed)
export ANDROID_SDK_ROOT=~/Android/Sdk
export ANDROID_HOME=$ANDROID_SDK_ROOT

# Build debug APK
./gradlew clean assembleDebug

# Build release APK
./gradlew clean assembleRelease
```

## APK Locations

After successful build:
- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release-unsigned.apk`

## Installing the APK

### On Android Device
1. Transfer APK to device
2. Enable "Install from Unknown Sources" in settings
3. Open APK file to install

### Using ADB
```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Configuration

### Android Version Support
- **Minimum**: Android 12 (API 31)
- **Target**: Android 14 (API 34)
- **Compile**: Android 14 (API 34)

### Build Tools
- **Gradle**: 8.2
- **Android Gradle Plugin**: 8.2.0
- **Kotlin**: 1.9.20
- **JVM Target**: Java 17

### MyAnimeList API Setup

Before using the app, configure your API credentials:

1. Register at https://myanimelist.net/apiconfig
2. Update CLIENT_ID in `app/src/main/java/com/animerec/app/AnimeRecApp.kt`:
   ```kotlin
   const val CLIENT_ID = "your-client-id-here"
   ```

## Detailed Documentation

For more detailed information, see:
- **BUILD_GUIDE.md** - Complete build instructions and troubleshooting
- **ANDROID12_SETUP.md** - Configuration details and architecture

## Troubleshooting

### "SDK Not Found"
```bash
export ANDROID_SDK_ROOT=~/Android/Sdk
export ANDROID_HOME=$ANDROID_SDK_ROOT
```

### "Java Version Error"
Ensure Java 17+ is installed and set as default:
```bash
sudo update-alternatives --config java
```

### Build Fails
Clear Gradle cache and retry:
```bash
./gradlew clean
rm -rf .gradle app/build
./gradlew assembleDebug
```

## Features

The app includes:
- ✨ Tinder-style swipe interface for anime recommendations
- 📱 MyAnimeList integration and OAuth login
- 📚 Watchlist and history management
- 🎨 Material Design UI with theming
- 🔄 Smart recommendation engine
- 💾 Local database with Room

## Support

For issues:
1. Check BUILD_GUIDE.md for detailed instructions
2. Review build logs for errors
3. Ensure all prerequisites are met
4. Open an issue on GitHub

---

**Ready to build!** Run `./build_apk.sh` in the AnimeRecApp directory to get started.
