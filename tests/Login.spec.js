import { LoginPage } from '../Pages/LoginPage.js';
import { test, expect } from '@playwright/test';

test('Login to Gois application',async({page})=>{


    const loginPage = new LoginPage(page);
    await loginPage.login();
    //await expect(page).toHaveURL(/.*Dashboard/);
});