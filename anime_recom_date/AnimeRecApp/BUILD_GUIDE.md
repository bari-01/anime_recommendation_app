# Building AnimeMate APK - Linux Build Guide

This guide explains how to build the AnimeMate Android application on Linux systems.

## Prerequisites

### 1. Java Development Kit (JDK) 17 or Higher

The project requires Java 17 or higher. Check your Java version:

```bash
java -version
```

If you need to install Java 17:

**Ubuntu/Debian:**
```bash
sudo apt-get update
sudo apt-get install openjdk-17-jdk
```

**Fedora/RHEL:**
```bash
sudo dnf install java-17-openjdk-devel
```

**Arch Linux:**
```bash
sudo pacman -S jdk17-openjdk
```

Set JAVA_HOME if needed:
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

### 2. Android SDK (Optional - Auto-installed by build script)

The build script (`build_apk.sh`) will automatically download and install Android SDK command-line tools if not found. However, if you prefer to install it manually:

1. Download Android command-line tools from https://developer.android.com/studio#command-tools
2. Extract to `~/Android/Sdk/cmdline-tools/latest`
3. Set environment variables:

```bash
export ANDROID_SDK_ROOT=~/Android/Sdk
export ANDROID_HOME=$ANDROID_SDK_ROOT
export PATH=$ANDROID_SDK_ROOT/cmdline-tools/latest/bin:$PATH
export PATH=$ANDROID_SDK_ROOT/platform-tools:$PATH
```

4. Accept licenses and install required components:

```bash
yes | sdkmanager --licenses
sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"
```

## Build Methods

### Method 1: Using the Build Script (Recommended)

The easiest way to build is using the provided `build_apk.sh` script:

```bash
cd anime_recom_date/AnimeRecApp
chmod +x build_apk.sh
./build_apk.sh
```

The script will:
- Check Java version
- Install Android SDK if needed
- Set up environment variables
- Clean previous builds
- Build debug and release APKs
- Display APK locations

### Method 2: Using Gradle Directly

If you have Android SDK already set up:

```bash
cd anime_recom_date/AnimeRecApp

# Set environment variables
export ANDROID_SDK_ROOT=~/Android/Sdk  # Adjust path as needed
export ANDROID_HOME=$ANDROID_SDK_ROOT

# Make gradlew executable
chmod +x gradlew

# Build debug APK
./gradlew clean assembleDebug

# Build release APK (unsigned)
./gradlew clean assembleRelease
```

## Build Outputs

After a successful build, APK files will be located at:

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release-unsigned.apk`

## Installing the APK

### On a Physical Device

1. Transfer the APK to your Android device
2. Enable "Install from Unknown Sources" in device settings
3. Open the APK file to install

### Using ADB

If you have ADB (Android Debug Bridge) set up:

```bash
# Install debug APK
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Install release APK
adb install -r app/build/outputs/apk/release/app-release-unsigned.apk
```

## Project Configuration

### Android Version Support

- **Minimum SDK**: API 31 (Android 12)
- **Target SDK**: API 34 (Android 14)
- **Compile SDK**: API 34

### Build Configuration

- **Gradle Version**: 8.2
- **Android Gradle Plugin**: 8.2.0
- **Kotlin Version**: 1.9.20
- **JVM Target**: 17

### Key Dependencies

- AndroidX Core KTX: 1.15.0
- Material Components: 1.12.0
- Navigation Component: 2.7.5
- Room Database: 2.6.0
- Retrofit: 2.9.0
- Glide: 4.16.0
- CardStackView: 2.3.4 (for swipe interface)

## Troubleshooting

### Build Fails with "SDK Not Found"

Ensure ANDROID_SDK_ROOT and ANDROID_HOME are set:
```bash
export ANDROID_SDK_ROOT=~/Android/Sdk
export ANDROID_HOME=$ANDROID_SDK_ROOT
```

### Java Version Error

The project requires Java 17. Check your version and install if needed:
```bash
java -version
# Should show version 17 or higher
```

### Gradle Build Errors

Try cleaning the build:
```bash
./gradlew clean
rm -rf .gradle
rm -rf app/build
./gradlew assembleDebug
```

### Out of Memory Errors

Increase Gradle memory in `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4096m -Dfile.encoding=UTF-8
```

### Permission Denied on gradlew

Make the Gradle wrapper executable:
```bash
chmod +x gradlew
```

## Signing the Release APK

For production releases, you need to sign the APK:

1. Generate a keystore:
```bash
keytool -genkey -v -keystore my-release-key.jks \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias my-key-alias
```

2. Configure signing in `app/build.gradle`:
```gradle
android {
    signingConfigs {
        release {
            storeFile file("path/to/my-release-key.jks")
            storePassword "your-store-password"
            keyAlias "my-key-alias"
            keyPassword "your-key-password"
        }
    }
    buildTypes {
        release {
            signingConfig signingConfigs.release
            // ... other settings
        }
    }
}
```

3. Build signed release:
```bash
./gradlew assembleRelease
```

## MyAnimeList API Configuration

Before using the app, you need to configure MyAnimeList API credentials:

1. Register your application at https://myanimelist.net/apiconfig
2. Update the CLIENT_ID in `app/src/main/java/com/animerec/app/AnimeRecApp.kt`:

```kotlin
companion object {
    const val CLIENT_ID = "your-client-id-here"
    // ...
}
```

## Testing the App

### Running on Emulator

If you have Android Studio installed:

1. Create an AVD (Android Virtual Device) with Android 12+
2. Start the emulator
3. Install using ADB:
```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### UI Testing

The app features:
- Login screen with MyAnimeList OAuth
- Swipe interface for anime recommendations
- Watchlist management
- User profile with statistics
- Bottom navigation between sections

## Development Build vs Release Build

### Debug Build
- Includes debug symbols
- Larger file size
- Can be debugged
- Not optimized
- Application ID suffix: `.debug`

### Release Build
- Minified and optimized
- Smaller file size
- Cannot be debugged
- ProGuard/R8 enabled
- Must be signed for distribution

## Additional Resources

- [Android Developer Documentation](https://developer.android.com/docs)
- [Gradle Build Tool](https://gradle.org/)
- [MyAnimeList API Documentation](https://myanimelist.net/apiconfig/references/api/v2)

## Support

For issues or questions:
1. Check the troubleshooting section above
2. Review build logs for specific errors
3. Ensure all prerequisites are met
4. Open an issue on the GitHub repository

## License

This project is licensed under the MIT License - see the LICENSE file for details.
