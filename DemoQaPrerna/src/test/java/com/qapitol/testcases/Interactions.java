package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.HomePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qapitol.base.BaseClass.*;

public class Interactions {

    HomePageClass home;

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initializer();

        home =new HomePageClass();
        home.clickOnInteractions();

        Thread.sleep(5000);

        WebElement ele1 = driver.findElement(By.xpath("//div[text()='Interactions']"));
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",ele1);
//        ele1.click();
//        Thread.sleep(5000);
    }

    @Test
    public static void sortable() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Sortable']")).click();
        Thread.sleep(2000);
        //Scroll to ele
        WebElement w = driver.findElement(By.id("demo-tab-list"));
        JavascriptExecutor script =(JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",w);

        Thread.sleep(2000);

        WebElement source = driver.findElement(By.xpath("//div[contains(@class,'vertical-list-container')]//div[text()='Four']"));
        WebElement destination = driver.findElement(By.xpath("//div[contains(@class,'vertical-list-container')]//div[text()='Two']"));

        Actions a = new Actions(driver);
        a.clickAndHold(source).dragAndDrop(source,destination).build().perform();
        Thread.sleep(9000);

        //For grid
        WebElement w1 = driver.findElement(By.id("demo-tab-grid"));
        JavascriptExecutor s =(JavascriptExecutor) driver;
        s.executeScript("arguments[0].scrollIntoView(true)",w1);
        w1.click();

        WebElement sourceGrid=driver.findElement(By.xpath("//div[contains(@class,'create-grid')]//div[text()='Eight']"));
        WebElement targetGrid=driver.findElement(By.xpath("//div[contains(@class,'create-grid')]//div[text()='Three']"));

        Actions a1= new Actions(driver);
        a1.clickAndHold(sourceGrid).dragAndDrop(sourceGrid,targetGrid).build().perform();
        Thread.sleep(9000);
    }

//    public static void selectable(){
//
//    }
//
//    public static void resizeable(){
//
//    }
//
//    public static void droppable(){
//
//    }
//
//    public static void draggable(){
//
//    }
    @AfterMethod
    public void setDown(){
        closing();
    }
}
