package com.qapitol.testcases;

import com.qapitol.pages.AlertFrameWindowClass;
import com.qapitol.pages.HomePageClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static com.qapitol.base.BaseClass.*;
import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertFrameWindows {

    HomePageClass home;
    AlertFrameWindowClass alertFrameWindowClass;

    @BeforeMethod
    public void setUp() throws IOException {
        initializer();
        home = new HomePageClass();
        alertFrameWindowClass = new AlertFrameWindowClass();
        home.clickOnAlertFrameWindows();
        driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']")).click();

    }

    @Test
    public void BrowserWindows() throws InterruptedException {
        alertFrameWindowClass.newTabBrowserWindows();
        alertFrameWindowClass.newWindowBrowserWindows();
        alertFrameWindowClass.newWindowMessageBrowserWindows();
    }

    public void alerts() throws InterruptedException {
        alertFrameWindowClass.alertsButton1();
        alertFrameWindowClass.alertsButton2();
        alertFrameWindowClass.alertsButton3();
        alertFrameWindowClass.alertsButton4();
    }

    public void framesPractice(){
        alertFrameWindowClass.frame();
    }

    public void nestedFrames(){
        alertFrameWindowClass.nestedFrame();
    }


    public void modalDialogs() throws InterruptedException {
        alertFrameWindowClass.modalDialog();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }
}
