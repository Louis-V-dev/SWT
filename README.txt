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
