
const {test, except} = require('@playwright/test');

test('Input Form Submit Validation', async ({ page }) => {
    await page.goto('https://www.testmuai.com/selenium-playground' );
    await page.click('text=Input Form Submit');
});