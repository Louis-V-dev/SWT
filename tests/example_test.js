Feature('Example Feature');

Scenario('Test something', ({ I }) => {
    // existing code...
    I.amOnPage('/'); // Ensure this is necessary
    I.see('Welcome'); // Check if this assertion is still valid
    // ...
});

// Remove any unused scenarios or redundant code 