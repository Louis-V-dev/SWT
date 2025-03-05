I'll list out the step-by-step commands to run the tests and explain the purpose of each step:

1. First, stop any running Appium instances:
```powershell
Get-Process -Name node -ErrorAction SilentlyContinue | Where-Object {$_.CommandLine -match "appium"} | Stop-Process -Force
```
**Purpose**: This ensures no previous Appium servers are running that might conflict with our new session. It cleanly terminates any existing Appium processes.

2. Start the Appium server with specific configuration:
```powershell
npx appium --log-level debug --use-drivers uiautomator2 --base-path /wd/hub
```
**Purpose**: 
- `--log-level debug`: Enables detailed logging for troubleshooting
- `--use-drivers uiautomator2`: Explicitly uses the UiAutomator2 driver for Android
- `--base-path /wd/hub`: Sets the correct base path for WebDriver protocol

3. Force stop and restart the app:
```powershell
adb shell am force-stop com.example.swtandroidtest; adb shell am start -n com.example.swtandroidtest/.MainActivity
```
**Purpose**: 
- `force-stop`: Ensures the app is completely closed
- `start`: Launches the app fresh, ensuring a clean state for testing

4. Run the tests:
```powershell
npx codeceptjs run --verbose
```
**Purpose**:
- `run`: Executes all test scenarios in the test files
- `--verbose`: Shows detailed output of test execution, including each step and any errors

The tests will then execute the following types of commands for each scenario:

1. **Element Location Commands**:
```javascript
I.waitForElement(resourceId('button1'), 10);
```
Purpose: Waits for UI elements to be visible before interacting with them

2. **Interaction Commands**:
```javascript
I.tap(resourceId('button1'));
```
Purpose: Simulates user interactions with the UI elements

3. **Wait Commands**:
```javascript
I.wait(2);
```
Purpose: Adds necessary delays between actions to ensure UI state is stable

4. **Verification Commands**:
```javascript
I.see('3', resultTextView());
```
Purpose: Validates the expected results of operations

The configuration in `codecept.conf.js` supports these operations with important settings:
```javascript
{
    appiumV2: true,              // Uses Appium 2.0 protocol
    waitForTimeout: 20000,       // Global timeout for element finding
    'appium:noReset': false,     // Don't preserve app state between tests
    'appium:forceAppLaunch': true, // Always launch app fresh
}
```

To run tests for specific scenarios only, you can use:
```powershell
npx codeceptjs run --grep "Perform addition"
```
Purpose: Runs only the test scenarios matching the grep pattern

For debugging purposes, you can also run with additional flags:
```powershell
npx codeceptjs run --steps --verbose --debug
```
Purpose:
- `--steps`: Shows each step as it executes
- `--debug`: Provides additional debugging information
- `--verbose`: Shows detailed output

These commands together create a complete testing workflow that:
1. Ensures a clean environment
2. Starts the necessary services
3. Launches the app in a known state
4. Executes the tests with proper logging
5. Provides detailed feedback about test results




I'll create a comprehensive installation guide for the README that your friends can follow to set up Appium for Android testing:

# Appium Setup Guide for Android Testing

## Prerequisites

1. **Node.js and npm**
   - Download and install Node.js from [nodejs.org](https://nodejs.org/)
   - Recommended version: 16.x or later
   - Verify installation:
     ```bash
     node --version
     npm --version
     ```

2. **Java Development Kit (JDK)**
   - Download and install JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK
   - Recommended version: JDK 11 or later
   - Set JAVA_HOME environment variable
   - Verify installation:
     ```bash
     java --version
     ```

3. **Android Studio**
   - Download and install Android Studio from [developer.android.com](https://developer.android.com/studio)
   - Install Android SDK through Android Studio
   - Set ANDROID_HOME environment variable
   - Required SDK components:
     - Android SDK Platform-tools
     - Android SDK Build-tools
     - Android Emulator
     - At least one Android SDK Platform (e.g., Android 11.0/API 30)

4. **Environment Variables**
   Set the following environment variables:
   ```
   JAVA_HOME=<path_to_java_installation>
   ANDROID_HOME=<path_to_android_sdk>
   Path+=
     %ANDROID_HOME%\platform-tools
     %ANDROID_HOME%\tools
     %ANDROID_HOME%\tools\bin
     %JAVA_HOME%\bin
   ```

## Appium Installation

1. **Install Appium**
   ```bash
   npm install -g appium@2.0.0
   ```

2. **Install Appium Driver**
   ```bash
   appium driver install uiautomator2
   ```

3. **Install Appium Doctor** (for verifying setup)
   ```bash
   npm install -g appium-doctor
   ```

4. **Verify Installation**
   ```bash
   appium-doctor --android
   ```

## Project Setup

1. **Install Project Dependencies**
   ```bash
   npm install --save-dev codeceptjs webdriverio appium
   ```

2. **Initialize CodeceptJS**
   ```bash
   npx codeceptjs init
   ```

## Running Tests

1. **Start Appium Server**
   ```bash
   appium --use-drivers uiautomator2
   ```

2. **Start Android Emulator**
   ```bash
   emulator -avd <your_avd_name>
   ```

3. **Run Tests**
   ```bash
   npx codeceptjs run --verbose
   ```

## Troubleshooting

Common issues and solutions:
- Ensure all environment variables are set correctly
- Verify Android Emulator is running before starting tests
- Check Appium server is running on default port (4723)
- Use `appium-doctor` to verify all dependencies are correctly installed
- For connection issues, ensure the app is properly installed on the emulator
- Check device/emulator is visible in `adb devices` list



