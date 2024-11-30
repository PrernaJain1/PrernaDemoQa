package com.qapitol.testcases;

import com.qapitol.pages.HomePageClass;
import com.qapitol.pages.WidgetsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qapitol.base.BaseClass.*;

public class Widgets {

    HomePageClass home;
    WidgetsClass widget;

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initializer();

        home =new HomePageClass();
        widget = new WidgetsClass();
        home.clickOnWidgets();

        Thread.sleep(5000);

        WebElement ele1 = driver.findElement(By.xpath("//div[text()='Widgets']"));
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",ele1);
    }

//    @Test
    public void accordian(){
        widget.accordianClick();
    }

//    @Test
    public void autoComplete() throws InterruptedException {
        widget.autoCompleteClick();
    }

    @Test
    public void datePicker(){
        widget.datePickerClick();
    }

//    @Test
    public void slider(){
        widget.sliderClick();
    }

//    @Test
    public void progressBar(){
        widget.progressBarClick();
    }

//    @Test
    public void tabs(){
        widget.tabsClick();
    }

//    @Test
    public void toolTips() throws InterruptedException {
        widget.toolTipsClick();
    }

//    @Test
    public void menu(){
        widget.menuClick();
    }

//    @Test
    public void selectMenu(){
        widget.selectMenuClick();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }

}
