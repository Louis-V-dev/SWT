exports.config = {
  tests: './*_test.js',
  output: './output',
  helpers: {
    Appium: {
      appiumV2: true,
      platform: 'Android',
      device: 'emulator-5554',
      app: 'D:/SWT301/SWTANDROIDTEST/app/build/outputs/apk/debug/app-debug.apk',
      desiredCapabilities: {
        platformName: 'Android',
        deviceName: 'emulator-5554',
        appPackage: 'com.example.swtandroidtest',
        appActivity: '.MainActivity',
        automationName: 'UiAutomator2'
      }
    },
    WebDriver: {
      // ...
    }
  },
  plugins: {
    wdio: {
      enabled: true,
      services: ['appium']
    }
  },
  include: {
    // Ensure all included files are necessary
  }
};