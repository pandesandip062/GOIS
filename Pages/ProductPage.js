import { expect } from '@playwright/test';
import { BasePage } from './BasePage.js';

export class ProductPage extends BasePage {

    constructor(page) {
        super(page);

        this.productName = page.locator('#txtProductName');
        this.productCode = page.locator('#txtProductNumber');
        this.productDescription = page.locator('#txtDescription');
        this.unitCost = page.locator('#txtUnitPurchasePrice');
        this.LDC = page.locator('#txtLastDirectCostPrice');
        this.unitPrice = page.locator('#txtUnitSalePrice');
        this.baseUON = page.locator('#ddlUnit');
        this.setting = page.locator("//span[text()='Settings']");
        this.productType = page.locator('#productType');
        this.itemTracking = page.locator('#ItemTracking');
        this.save_backBtn = page.locator('#btnSaveAndBack');

        

    }

    async addNewProduct(ProductData){
        await this.enterText(this.productName,ProductData.productName);
        await this.enterText(this.productCode,ProductData.productCode);
        await this.enterText(this.productDescription,ProductData.productDescription);
        await this.enterText(this.unitCost,ProductData.unitCost);
        await this.enterText(this.LDC,ProductData.ldc);
        await this.enterText(this.unitPrice,ProductData.unitPrice);
        await this.click(this.baseUON);
        await this.selectDropdown(this.baseUON, 'lb');
        await this.click(this.setting);
        await this.selectDropdown(this.productType,ProductData.productType);
        await this.selectDropdown(this.itemTracking, ProductData.itemTracking);
        await this.click(this.save_backBtn);
    }




}