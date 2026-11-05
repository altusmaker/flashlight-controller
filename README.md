# Flashlight Controller

A lightweight and efficient Android application designed for quick and reliable flashlight management. This repository contains the source code for a native Android app built using Gradle and standard Android SDKs.

## 🛠 Features
* **Instant Control:** Quick toggle to turn the device's camera flash on and off.
* **Lightweight & Optimized:** Minimal resource footprint with direct hardware access.
* **Standard Architecture:** Clean project layout managed via Android Gradle Build System.

## 📋 Prerequisites
To build and run this project locally, ensure you have:
* **Android Studio** (Electric Eel or newer recommended)
* **JDK** 11 or higher
* **Android SDK** (configured via Gradle dependencies)

## 🚀 Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/altusmaker/flashlight-controller.git
   ```
2. Open the project folder in **Android Studio**.
3. Allow Gradle to sync and download all necessary dependencies.
4. Connect a physical Android device or start an emulator.
5. Click **Run** to build and deploy the app.

## 🏗 Project Structure
* `/app`: Core application source code, resources (layouts, drawables), and `AndroidManifest.xml`.
* `/gradle`: Gradle wrapper and build configuration files.
* `build.gradle`: Project-level build configurations and dependencies.

## 💡 Development Notes
* **Permissions:** This application requires the `android.permission.CAMERA` permission to access the flashlight hardware.
* **Security Warning:** The repository currently includes a `Key.jks` keystore file. For security best practices, it is strongly recommended to remove tracking of `Key.jks` and use environment variables or local properties for release signing keys.

## 📄 License
This project is open-source and available under the [MIT License](LICENSE).
