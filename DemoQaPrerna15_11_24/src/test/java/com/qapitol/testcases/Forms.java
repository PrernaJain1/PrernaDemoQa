package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.HomePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Forms extends BaseClass {
    HomePageClass forms;
    @BeforeMethod
    public void formSetUp() throws IOException {
        initializer();
        HomePageClass forms = new HomePageClass();
        forms.clickOnForm();
    }
    @AfterMethod
    public void formSetDown(){
        closing();
    }
    @DataProvider(name ="values")
    public Object[][] getData(){
        return new Object[][] {{},{}};
    }

    @Test
    public static void PracticeForm() {
        //Click on form
        driver.findElement(By.xpath("//div[text()='Forms']")).click();

        //Click on practice form
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();

        //scroll to element
        WebElement scroll = driver.findElement(By.xpath("//h5[text()='Student Registration Form']"));
        JavascriptExecutor script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",scroll);

        //enter the first name
        driver.findElement(By.id("firstName")).sendKeys("Prerna");

    }
}
