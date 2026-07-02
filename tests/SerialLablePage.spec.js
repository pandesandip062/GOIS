import {test, expect} from '@playwright/test';
import { DashBoard } from '../Pages/DashBoard.js';
import { LoginPage } from '../Pages/LoginPage.js';
import { SerialLabelPage } from '../Pages/SerialLabelPage.js';

test('user able to go to serial label printing page',async({page})=>{
    const login = new LoginPage(page);
    await login.login();     
    
    const dashBoard = new DashBoard(page);

    await dashBoard.gotoAddProductPage();
    
    const serialLabel = new SerialLabelPage(page);
    await serialLabel.getAllSerialNumbers();


});