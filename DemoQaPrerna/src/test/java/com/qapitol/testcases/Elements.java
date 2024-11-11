package com.qapitol.testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.HomePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.qapitol.base.BaseClass.driver;
import static com.qapitol.base.BaseClass.properties;
import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class Elements extends BaseClass {


    public static void textBox() throws InterruptedException {
        HomePageClass home = new HomePageClass();
        home.clickOnElements();

        //Click on text box
        driver.findElement(By.className("text")).click();

        //asserting text box text
        String s = driver.findElement(By.className("text-center")).getText().trim();
        assertEquals(s, "Text Box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Scrolling till full name
        WebElement fullName = driver.findElement(By.id("userName-label"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",fullName);

        //send keys into full name
        driver.findElement(By.cssSelector("input[placeholder='Full Name']")).sendKeys(properties.getProperty("name"));

        //Send email
        driver.findElement(By.id("userEmail")).sendKeys(properties.getProperty("email"));

        //Current address
        driver.findElement(By.cssSelector("textarea.form-control[placeholder='Current Address']")).sendKeys(properties.getProperty("currAddress"));

        //Permanent address
        driver.findElement(By.id("permanentAddress")).sendKeys(properties.getProperty("perAddress"));

        //Scrolling till submit button
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",submitButton);
        //Submit button
        submitButton.click();
    }

    public static void checkBox() {
        HomePageClass home = new HomePageClass();
        home.clickOnElements();

        //Click on checkbox
        driver.findElement(By.xpath("//span[text()='Check Box']")).click();

        //click on first home checkbox
        driver.findElement(By.className("rct-checkbox")).click();

        //click on expand button
        driver.findElement(By.xpath("//button[@title='Toggle']")).click();

        //Checking documents checkbox is selected
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]")).isSelected();

        //Unselect documents checkbox
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]")).click();

        //To check documents text is displayed
        assertTrue(driver.findElement(By.xpath("//span[text()='Documents']")).isDisplayed());

    }


    public static void radioButton() throws InterruptedException {
        HomePageClass home = new HomePageClass();
        home.clickOnElements();

        //Click on radio button
        driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

        sleep(5000);

        WebElement ele = driver.findElement(By.xpath("(//input[@type='radio'])[1]/.."));
        JavascriptExecutor button = (JavascriptExecutor) driver;
        button.executeScript("arguments[0].scrollIntoView(true);",ele);

        //Click on yes button
        ele.click();

        //Is no button enabled
        assertFalse(driver.findElement(By.id("noRadio")).isEnabled());
    }

    @Test
    public static void buttons() {
    HomePageClass home = new HomePageClass();
    home.clickOnElements();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    //Click on buttons tab
    driver.findElement(By.xpath("//span[text()='Buttons']")).click();

    Actions a = new Actions(driver);

    //double click
    WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

    JavascriptExecutor script = (JavascriptExecutor)driver;
    script.executeScript("arguments[0].scrollIntoView(true);",doubleClickBtn);

    a.moveToElement(doubleClickBtn).doubleClick().build().perform();

    //Right click
     WebElement rightClickButton = driver.findElement(By.id("rightClickBtn")) ;
     a.moveToElement(rightClickButton).contextClick().build().perform();

    //Normal click
     WebElement normalClick = driver.findElement(By.xpath("//button[text()='Click Me']"));
     a.moveToElement(normalClick).click().build().perform();
    }

    public static void webTables() {

    }

    public static void links() {

    }

    public static void brokenLinks() {

    }

    public static void uploadDownload() {

    }

    public static void dynamicProperties() {

    }

}
