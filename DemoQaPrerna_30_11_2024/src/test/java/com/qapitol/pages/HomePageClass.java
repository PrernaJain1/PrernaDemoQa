package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageClass extends BaseClass {

    public void clickOnElements(){
        WebElement element = driver.findElement(By.xpath("//h5[text()='Elements']"));
        scrollTillTheElement(element);
        element.click();
    }
    public void clickOnForm(){
        WebElement formClick =driver.findElement(By.xpath("//h5[text()='Forms']"));
        scrollTillTheElement(formClick);
        formClick.click();
    }

    public void clickOnAlertFrameWindows(){
        WebElement ele = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        scrollTillTheElement(ele);
        ele.click();
    }

    public void clickOnInteractions(){
        WebElement ele = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        scrollTillTheElement(ele);
        ele.click();
    }

    public void clickOnWidgets(){
        WebElement ele = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        scrollTillTheElement(ele);
        ele.click();
    }
}
