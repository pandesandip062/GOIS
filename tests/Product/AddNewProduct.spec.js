const { test,expect } = require('@playwright/test');
const { DashBoard } = require('../../Pages/DashBoard.js');
const { LoginPage } = require('../../Pages/LoginPage.js');
const { ProductPage } = require('../../Pages/ProductPage.js');
const { ProductData } = require('../../TestData/qaTestData.js');
const { BasePage } = require('../../Pages/BasePage.js');
const { faker } = require('@faker-js/faker');


test('user able to go to add new product page',async({page})=>{
  console.log('started test');
    const login = new LoginPage(page);
    await login.login();
   
    const db = new DashBoard(page);
    await db.gotoAddProductPage();
    
    const product = new ProductPage(page);
    await product.addNewProduct(ProductData);
   //await expect(page).toHaveURL('https://gois.godigit.com/product/add');
});
