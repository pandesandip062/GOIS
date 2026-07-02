import { faker } from "@faker-js/faker";

export const ProductData = {
    productName: faker.commerce.productName(),
    productCode: faker.string.alphanumeric(6),
    productDescription: faker.commerce.productDescription(),

    unitCost: '100',
    ldc: '90',
    unitPrice: '150',
    baseUOM: 'Each',
    productType: 'Item',
    itemTracking: 'No Tracking'
};