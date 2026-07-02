export class SerialLabelPage {

    constructor(page) {
        this.page = page;

        // Locate all rows
       this.rows = page.locator(".k-grid-content tbody tr");
    }

    async getAllSerialNumbers() {

    // Wait for grid to be visible
    // await this.page.locator(".k-grid-content").waitFor({
    //     state: "visible",
    //     timeout: 30000
    // });

    const rows = this.page.locator(".k-grid-content tbody tr");

    const rowCount = await rows.count();

    console.log("Rows Found =", rowCount);

    let allSerials = [];

    for (let i = 0; i < rowCount; i++) {

        const row = rows.nth(i);

        const batchId = (await row.locator("td").nth(0).textContent()).trim();
        const startNo = (await row.locator("td").nth(2).textContent()).trim();
        const endNo = (await row.locator("td").nth(3).textContent()).trim();

        console.log(
            `Batch ${batchId} -> ${startNo} to ${endNo}`
        );

        for (let serial = parseInt(startNo);
             serial <= parseInt(endNo);
             serial++) {

            allSerials.push(
                String(serial).padStart(6, '0')
            );
        }
    }

    allSerials = [...new Set(allSerials)];

    console.log("Total Unique Serials =", allSerials.length);

    return allSerials;
}
}