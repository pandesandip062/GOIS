import { expect } from "@playwright/test";
export class QuickSalesOrderScreen{

    constructor(page){
        this.page=page;

        this.moreInfoButton= page.locator("//div[@class='vertical-text Quickheader']");
        this.OrganizationDropdown= page.locator("//select[@id='SelectedOrg']");
        this.businessUnitDropdown= page.locator("//select[@id='selectbu']");
        this.locationDropdown= page.locator("//select[@id='selectlu']");
        this.selectCustomerTextbox= page.locator("//input[@id='CustName']");
        this.selectSalesPersonTextbox= page.locator("//select[@id='selectpe']");
        this.selectItemTextbox= page.locator("//input[@id='txtProduct1']");
        this.save_CloseButton= page.locator("//button[@id='SaveandBack']");
        this.confrimButton= page.locator("//button[@id='btnDepositYes']");

    }

    async createSalesOrder(orgName,buName,locationName,customerName,salesPerson,itemName ){
        await this.moreInfoButton.click();
        await this.OrganizationDropdown.selectOption({label: orgName});
        await this.businessUnitDropdown.selectOption({label: buName});
        await this.locationDropdown.selectOption({label:locationName});
        await this.selectCustomerTextbox.fill(customerName);
        await this.page.waitForTimeout(2000);
        await this.selectCustomerTextbox.click();
        await this.selectSalesPersonTextbox.selectOption({label:salesPerson});
        await this.selectItemTextbox.fill(itemName);
        await this.selectItemTextbox.click();          // focus it
        await this.page.keyboard.press('Backspace');
        await this.page.waitForTimeout(500); // small delay
        await this.page.keyboard.press('Backspace');
        await this.page.waitForTimeout(5000);
        await this.page.locator((`//strong[contains(text(),'${itemName}')]`)).click();
        await this.save_CloseButton.click();
        await this.confrimButton.click();
        const locator1 = this.page.locator(`(//a[contains(text(),'${customerName}')])[1]`);
       await locator1.waitFor({ state: 'visible', timeout: 50000 });
       await expect(locator1).toBeVisible();

    }



}