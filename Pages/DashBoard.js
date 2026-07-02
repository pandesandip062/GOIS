import { BasePage } from "./BasePage.js";

export class DashBoard extends BasePage {

    constructor(page) {
        super(page);
        this.page = page;

        this.Sales = page.locator("//span[text()='Sales']");
        this.quickSalesOrder = page.locator("//a[normalize-space()='Quick Sales Order']");
        this.punchSalesOrder = page.locator("//a[normalize-space()='Punch Sales Quote']");
        this.product = page.locator("//span[text()='Products']");
        this.addNewProduct = page.locator('#AddProduct');
        this.reprot = page.locator("//span[text()='Reports']");
        this.labelPrinting = page.locator("//a[text()='Label Printing']");
        this.serialPrinting = page.locator("//a[text()='Serial Number Label']");
    }

    async gotoAddProductPage() {
        // await this.hover(this.product);
        // await this.click(this.addNewProduct);
        await this.hover(this.reprot);
        await this.hover(this.labelPrinting);
        await this.click(this.serialPrinting);
    }

    async gotoSalesOrderPage() {
        await this.Sales.hover();
        await this.quickSalesOrder.click();

    }

    async gotoSerialPrintReport() {

        await this.hover(this.reprot);
        await this.hover(this.labelPrinting);
        await this.click(this.serialPrinting);

    }



}