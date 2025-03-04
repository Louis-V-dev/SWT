Feature('Calculator');

// Helper function to create proper Android locator
const resourceId = (id) => `android=new UiSelector().resourceId("com.example.swtandroidtest:id/${id}")`;

// Helper function for result text view
const resultTextView = () => `android=new UiSelector().resourceId("com.example.swtandroidtest:id/resultTextView").className("android.widget.TextView")`;

// Alternative locator strategies if needed:
// const resourceId = (id) => `id=com.example.swtandroidtest:id/${id}`;
// const resourceId = (id) => `android=new UiSelector().resourceId("com.example.swtandroidtest:id/${id}")`;

Scenario('Perform addition', async ({ I }) => {
    console.log('Starting addition test...');
    I.waitForElement(resourceId('button1'), 10);
    console.log('Found button1');
    I.tap(resourceId('button1'));
    I.wait(2);
    I.tap(resourceId('buttonAdd'));
    I.wait(2);
    I.tap(resourceId('button2'));
    I.wait(2);
    I.tap(resourceId('buttonEquals'));
    I.waitForElement(resultTextView(), 10);
    I.see('3', resultTextView());
});

Scenario('Perform subtraction', async ({ I }) => {
    I.waitForElement(resourceId('button5'), 5);
    I.tap(resourceId('button5'));
    I.wait(1);
    I.tap(resourceId('buttonSubtract'));
    I.wait(1);
    I.tap(resourceId('button2'));
    I.wait(1);
    I.tap(resourceId('buttonEquals'));
    I.waitForElement(resultTextView(), 5);
    I.see('3', resultTextView());
});

Scenario('Perform multiplication', async ({ I }) => {
    I.waitForElement(resourceId('button3'), 5);
    I.tap(resourceId('button3'));
    I.wait(1);
    I.tap(resourceId('buttonMultiply'));
    I.wait(1);
    I.tap(resourceId('button4'));
    I.wait(1);
    I.tap(resourceId('buttonEquals'));
    I.waitForElement(resultTextView(), 5);
    I.see('12', resultTextView());
});

Scenario('Perform division', async ({ I }) => {
    I.waitForElement(resourceId('button8'), 5);
    I.tap(resourceId('button8'));
    I.wait(1);
    I.tap(resourceId('buttonDivide'));
    I.wait(1);
    I.tap(resourceId('button2'));
    I.wait(1);
    I.tap(resourceId('buttonEquals'));
    I.waitForElement(resultTextView(), 5);
    I.see('4', resultTextView());
});

Scenario('Clear functionality', async ({ I }) => {
    I.waitForElement(resourceId('button9'), 5);
    I.tap(resourceId('button9'));
    I.wait(1);
    I.tap(resourceId('buttonClear'));
    I.wait(1);
    I.waitForElement(resultTextView(), 5);
    I.see('0', resultTextView());
});

Scenario('Chain operations', async ({ I }) => {
    I.waitForElement(resourceId('button2'), 5);
    I.tap(resourceId('button2'));
    I.wait(1);
    I.tap(resourceId('buttonAdd'));
    I.wait(1);
    I.tap(resourceId('button3'));
    I.wait(1);
    I.tap(resourceId('buttonEquals'));
    I.wait(1);
    // Result is now 5
    I.tap(resourceId('buttonMultiply'));
    I.wait(1);
    I.tap(resourceId('button2'));
    I.wait(1);
    I.tap(resourceId('buttonEquals'));
    I.waitForElement(resultTextView(), 5);
    I.see('10', resultTextView());
});