package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.qapitol.base.BaseClass.driver;

public class HomePageClass extends BaseClass {

    public void clickOnElements(){
        WebElement element = driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",element);
        element.click();

    }
}
