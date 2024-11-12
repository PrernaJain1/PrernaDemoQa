package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePageClass extends BaseClass {

    public void clickOnElements(){
        WebElement element = driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",element);
        element.click();
    }
    public void clickOnForm(){
        WebElement formClick =driver.findElement(By.xpath("//h5[text()='Forms']"));
        JavascriptExecutor script =(JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",formClick);
        formClick.click();
    }

    public void clickOnAlertFrameWindows(){
        WebElement ele = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",ele);
        ele.click();
    }

    public void clickOnInteractions(){
        WebElement ele = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        JavascriptExecutor script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",ele);
        ele.click();
    }
}
