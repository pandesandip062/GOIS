export class Packingscreen{

    constructor(page) {
        this.page= page;
        this.salesLink = page.locator("//p[text()='Sale']");
        this.selectSalesOrder = orderId =>
        this.page.locator(`//a[text()="d'${orderId}'f"]`);
        this.page.locator('#iframeReport');
        
    }

    async gotoPackingScreen(SalesOrder) {
      
        await this.salesLink.click()

        await this.selectSalesOrder(SalesOrder).click();
    }
}
