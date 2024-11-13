package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.HomePageClass;
import com.qapitol.pages.InteractionsClass;
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

    @Test
    public void accordian(){
        widget.accordianClick();
    }

    public void autoComplete(){
        widget.autoCompleteClick();
    }

    public void datePicker(){
        widget.datePickerClick();
    }

    public void slider(){
        widget.sliderClick();
    }

    public void progressBar(){
        widget.progressBarClick();
    }

    public void tabs(){
        widget.tabsClick();

    }

    public void toolTips(){
        widget.toolTipsClick();
    }

    public void menu(){
        widget.menuClick();
    }

    public void selectMenu(){
        widget.selectMenuClick();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }

}
