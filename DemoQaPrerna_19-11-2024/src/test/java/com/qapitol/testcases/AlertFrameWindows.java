package com.qapitol.testcases;

import com.qapitol.pages.AlertFrameWindowClass;
import com.qapitol.pages.HomePageClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qapitol.base.BaseClass.closing;
import static com.qapitol.base.BaseClass.initializer;

public class AlertFrameWindows {

    HomePageClass home;
    AlertFrameWindowClass alertFrameWindowClass;

    @BeforeMethod
    public void setUp() throws IOException {
        initializer();
        home = new HomePageClass();
        alertFrameWindowClass = new AlertFrameWindowClass();
        home.clickOnAlertFrameWindows();
//        driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']")).click();
    }

    @Test
    public void BrowserWindowsTab() throws InterruptedException {
        alertFrameWindowClass.newTabBrowserWindows();
    }

    @Test
    public void BrowserWindows() throws InterruptedException {
        alertFrameWindowClass.newWindowBrowserWindows();
    }

//    @Test
    public void BrowserWindowsMessage() throws InterruptedException {
        alertFrameWindowClass.newWindowMessageBrowserWindows();
    }

    @Test
    public void alerts1() throws InterruptedException {
        alertFrameWindowClass.alertsButton1();
    }

    @Test
    public void alerts2() throws InterruptedException {
        alertFrameWindowClass.alertsButton2();
    }

    @Test
    public void alerts3() throws InterruptedException {
        alertFrameWindowClass.alertsButton3();
    }

    @Test
    public void alerts4() throws InterruptedException {
        alertFrameWindowClass.alertsButton4();
    }

    @Test
    public void framesPractice(){
        alertFrameWindowClass.frame();
    }
    @Test
    public void nestedFrames(){
        alertFrameWindowClass.nestedFrame();
    }

    @Test
    public void modalDialogs() throws InterruptedException {
        alertFrameWindowClass.modalDialog();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }
}
