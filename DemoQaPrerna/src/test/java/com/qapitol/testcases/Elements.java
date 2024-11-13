package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.ElementsClass;
import com.qapitol.pages.HomePageClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;


public class Elements extends BaseClass {
    HomePageClass home;
    ElementsClass elementsClass;

    @BeforeMethod
    public void setUp() throws IOException {
        initializer();
        home = new HomePageClass();
        elementsClass = new ElementsClass();
        home.clickOnElements();
    }

    public void textBox() throws InterruptedException, IOException {
        elementsClass.textBoxCheck();
    }

    public void checkBox() {
        elementsClass.checkBoxCheck();
    }


    public void radioButton() throws InterruptedException {
        elementsClass.radioButtonCheck();
    }


    public void buttons() {
        elementsClass.buttonClick();
    }

    public void links() throws InterruptedException {
        elementsClass.linkClick();

    }

    public void webTables() {
        elementsClass.webTablesClick();
    }

    public void brokenLinks() {
        elementsClass.brokenLinksClick();
    }

    public void uploadDownload() {
        elementsClass.uploadDownloadClick();
    }

    public void dynamicProperties() {
        elementsClass.dynamicPropertiesClick();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }
}
