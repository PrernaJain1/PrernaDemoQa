package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.ElementsClass;
import com.qapitol.pages.HomePageClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void textBox() throws InterruptedException, IOException {
        elementsClass.textBoxCheck();
    }

    @Test
    public void checkBox() {
        elementsClass.checkBoxCheck();
    }

    @Test
    public void radioButton() throws InterruptedException {
        elementsClass.radioButtonCheck();
    }

    @Test
    public void buttons() {
        elementsClass.buttonClick();
    }

    @Test
    public void links() throws InterruptedException {
        elementsClass.linkClick();

    }

    @Test
    public void webTables() {
        elementsClass.webTablesClick();
    }

    @Test
    public void brokenLinks() {
        elementsClass.brokenLinksClick();
    }

    @Test
    public void uploadDownload() {
        elementsClass.uploadDownloadClick();
    }

    @Test
    public void dynamicProperties() {
        elementsClass.dynamicPropertiesClick();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }
}
