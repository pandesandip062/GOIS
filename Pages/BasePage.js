import { expect } from '@playwright/test';

export class BasePage {
 constructor(page){
    this.page=page;

 }


  async click(locator){
    await locator.waitFor({state:'visible',timeout:60000}); 
    await locator.click();      
  }     

   // Force click
  async forceClick(locator) {
    await locator.waitFor({ state: 'visible' });
    await locator.click({ force: true });
  }

  // Fill text
  async enterText(locator, text) {
    await locator.waitFor({ state: 'visible' });
    await locator.fill(text);
  }

  // Clear and type
  async clearAndType(locator, text) {
    await locator.clear();
    await locator.fill(text);
  }

  // Get text
  async getText(locator) {
    await locator.waitFor({ state: 'visible' });
    return await locator.textContent();
  }

  // Scroll to element
  async scrollToElement(locator) {
    await locator.waitFor({ state: 'attached' });
    await locator.scrollIntoViewIfNeeded();
  }

  // Hover on element
  async hover(locator) {
    await locator.waitFor({ state: 'visible' });
    await locator.hover();
  }

  // Right click / Context click
  async rightClick(locator) {
    await locator.waitFor({ state: 'visible' });
    await locator.click({ button: 'right' });
  }

  // Double click
  async doubleClick(locator) {
    await locator.waitFor({ state: 'visible' });
    await locator.dblclick();
  }

  // Select dropdown by visible text
  async selectDropdown(locator, value) {
    await locator.waitFor({ state: 'visible' });
    await locator.selectOption({ label: value });
  }

  // Wait for element visible
  async waitForVisible(locator) {
    await locator.waitFor({ state: 'visible' });
  }

  // Wait for page load
  async waitForPageLoad() {
    await this.page.waitForLoadState('networkidle');
  }

  // Check element visibility
  async isVisible(locator) {
    return await locator.isVisible();
  }

  // Press keyboard key
  async pressKey(locator, key) {
    await locator.press(key);
  }

  // Upload file
  async uploadFile(locator, filePath) {
    await locator.setInputFiles(filePath);
  }

  // Get attribute value
  async getAttribute(locator, attribute) {
    return await locator.getAttribute(attribute);
  }

  // Drag and drop
  async dragAndDrop(sourceLocator, targetLocator) {
    await sourceLocator.dragTo(targetLocator);
  }


}