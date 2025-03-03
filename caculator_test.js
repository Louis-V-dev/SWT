Feature('Calculator');

Scenario('Perform addition', async ({ I }) => {
    I.waitForElement(resourceId('com.example.swtandroidtest:id/button1'), 5);
    I.tap(resourceId('com.example.swtandroidtest:id/button1'));
    I.pause(1000);
    I.tap(resourceId('com.example.swtandroidtest:id/buttonAdd'));
    I.pause(1000);
    I.tap(resourceId('com.example.swtandroidtest:id/button2'));
    I.pause(1000);
    I.tap(resourceId('com.example.swtandroidtest:id/buttonEquals'));
    I.waitForElement(resourceId('com.example.swtandroidtest:id/resultTextView'), 5);
    I.see('3', resourceId('com.example.swtandroidtest:id/resultTextView'));
});