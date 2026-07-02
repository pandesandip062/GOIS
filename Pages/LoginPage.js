import { expect } from '@playwright/test';
import { BasePage } from './BasePage.js';

export class LoginPage extends BasePage {
  constructor(page) {
    super(page);
       
    this.txtUsername = page.locator('#cphPage_txtLoginID');
    this.txtPassword = page.locator('#cphPage_txtPassword');
    this.btnLogin = page.locator('#cphPage_btnLogin');

    this.susscriptionWindow = page.locator("//b[text()='Your trial subscription will expire in ']");
  }

  async login() {
    // Navigate to the application
    await this.page.goto(process.env.BASE_URL, {
      waitUntil: 'domcontentloaded',
      timeout: 190000
    });

    // Perform login

    await this.enterText(this.txtUsername, process.env.APP_USERNAME);
    await this.enterText(this.txtPassword, process.env.APP_PASSWORD);
    await this.click(this.btnLogin);
  
    
   await this.page.waitForLoadState('networkidle', { timeout: 60000 });
  
    if(await this.susscriptionWindow.isVisible()){
      console.log('Subscription window is visible');
      await this.page.locator("//div[text()='X']").click();
    }else{
      console.log('Subscription window is not visible');
    }

  }
}
