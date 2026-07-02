import { expect } from '@playwright/test';

export default class Billing {
    constructor(page) {
        this.page = page;

        this.cancelCTA = page.locator("//div[text()='X']");
        this.billing = page.locator("//span[text()='Billing']");
        this.billingCycle = page.locator("//span[text()='Billing Cycle']");

        this.globalFilter = page.getByRole('link', { name: 'Global Filter' });
        this.selectBu = page.getByRole('img', { name: 'Select this Organization' }).nth(1);

        const frame = page.frameLocator('#iframeReport');

        this.businessUnitDropdown = frame.getByRole('combobox', { name: 'Business Unit' });
        this.code = frame.getByRole('textbox', { name: 'Code' });

        this.startDate = frame.locator('mat-form-field:has-text("Start Date")').getByLabel('Open calendar');
        this.endDate = frame.locator('mat-form-field:has-text("End Date")').getByLabel('Open calendar');
        this.billDate = frame.locator('mat-form-field:has-text("Bill Date")').getByLabel('Open calendar');

        this.description = frame.getByRole('textbox', { name: 'Description' });
        this.saveButton = frame.getByRole('button', { name: 'Save' });
        this.okButton = frame.getByRole('button', { name: 'Ok' });
        this.recordAddedButton = frame.getByRole('heading', { name: 'Record added successfully.' });
        this.okSuccBtn = frame.getByRole('button', { name: 'Ok' });

        // ❗ Missing locator (this would break your test)
        this.addBillingCycleButton = frame.getByRole('button', { name: 'Add Billing Cycle' });
    }

    async gotoBillingCycle() {

        await this.cancelCTA.waitFor({ state: 'visible' });
        await this.cancelCTA.click();

        await this.globalFilter.waitFor({ state: 'visible' });
        await this.globalFilter.click();

        await this.selectBu.waitFor({ state: 'visible' });
        await this.selectBu.click();

        // ✅ Wait for UI to settle after BU selection
        await this.page.waitForLoadState('networkidle');

        // ✅ FIX: Ensure billing is visible before clicking
        await this.billing.waitFor({ state: 'visible' });
        await this.billing.click();

        // ✅ Wait + click billing cycle
        await this.billingCycle.waitFor({ state: 'visible' });
        await this.billingCycle.click();
    }

    async verifyAddingBillingCycle() {

        await this.addBillingCycleButton.waitFor({ state: 'visible' });
        await this.addBillingCycleButton.click();

        await this.code.fill('TestCode');

        await this.startDate.click();
        await this.page.locator('button[aria-label="Choose Tuesday, June 25, 2026"]').click();

        await this.endDate.click();
        await this.page.locator('button[aria-label="Choose Tuesday, June 30, 2026"]').click();

        await this.billDate.click();
        await this.page.locator('button[aria-label="Choose Tuesday, June 30, 2026"]').click();

        await this.description.fill('Test Description');

        await this.saveButton.click();

        await this.okButton.waitFor({ state: 'visible' });
        await this.okButton.click();

        await expect(this.recordAddedButton).toBeVisible();

        await this.okSuccBtn.click();
    }
}