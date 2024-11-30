package com.qapitol.pages;

import com.beust.ah.A;
import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WidgetsClass extends BaseClass {

    public void accordianClick(){
        //click on accordian
        driver.findElement(By.xpath("//span[text()='Accordian']")).click();
        WebElement a =driver.findElement(By.xpath("//div[text()='Where does it come from?']"));
        scrollTillTheElement(a);
        a.click();
        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Contrary to popular belief, Lorem Ipsum is not sim')]")).getText());
    }

    public void autoCompleteClick() throws InterruptedException {
        WebElement autoComp = driver.findElement(By.xpath("//span[text()='Auto Complete']"));
        scrollTillTheElement(autoComp);
        autoComp.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Auto Complete']")));

        WebElement text1= driver.findElement(By.xpath("(//div[contains(@class,'auto-complete__control')])[1]"));

        Actions a = new Actions(driver);
        a.moveToElement(text1).click().sendKeys("A").build().perform();
        Thread.sleep(1000);
        a.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(5000);

        a.sendKeys("Red").build().perform();
        Thread.sleep(1000);
        a.sendKeys(Keys.ENTER).build().perform();
    }

    public void datePickerClick(){
        WebElement datePicker = driver.findElement(By.xpath("//span[text()='Date Picker']"));
        scrollTillTheElement(datePicker);
        datePicker.click();

        scrollTillTheElement(driver.findElement(By.xpath("//div[text()='Select Date']")));

        driver.findElement(By.id("datePickerMonthYearInput")).click();

        WebElement month =driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select s = new Select(month);
        s.selectByVisibleText("September");

        WebElement year =driver.findElement(By.xpath(" //select[@class='react-datepicker__year-select']"));
        Select s1 = new Select(year);
        s1.selectByVisibleText("2015");

        List<WebElement> allDatesOfMonth = driver.findElements(By.xpath("//div[@role='option']"));
        List<WebElement> currentMonthDate = new ArrayList<WebElement>();

        for(WebElement currMonthDate: allDatesOfMonth){
            if(!currMonthDate.getAttribute("class").contains("//div[contains(@class,'react-datepicker__day--outside-month')]")){
                currentMonthDate.add(currMonthDate);
            }
        }

        for(WebElement currentDate : currentMonthDate){
            if(currentDate.getText().equals("29")){
                currentDate.click();
                break;
            }
        }


    }

    public void sliderClick(){
        WebElement slider = driver.findElement(By.xpath("//span[text()='Slider']"));
        scrollTillTheElement(slider);
        slider.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Slider']")));

        WebElement s = driver.findElement(By.xpath("//input[@type='range']"));
        Actions a = new Actions(driver);
        a.moveToElement(s).clickAndHold().moveByOffset(89,0).release().build().perform();

    }

    public void progressBarClick(){
        WebElement progressBar = driver.findElement(By.xpath("//span[text()='Progress Bar']"));
        scrollTillTheElement(progressBar);
        progressBar.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Progress Bar']")));

        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(1));

        while (true){
            if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("progressBar"))).getText().equals("30%")){
            startStopButton.click();
            break;
            }
        }

    }

    public void tabsClick(){
        WebElement tabs = driver.findElement(By.xpath(" //span[text()='Tabs']"));
        scrollTillTheElement(tabs);
        tabs.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Tabs']")));

        driver.findElement(By.xpath("//a[text() ='Origin']")).click();
        System.out.println(driver.findElement(By.xpath("(//p[@class ='mt-3'])[2]")).getText());
    }

    public void toolTipsClick() throws InterruptedException {
        WebElement toolTip = driver.findElement(By.xpath("//span[text()='Tool Tips']"));
        scrollTillTheElement(toolTip);
        toolTip.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Tool Tips']")));

        WebElement toHover = driver.findElement(By.cssSelector("button#toolTipButton"));

        Actions a = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        a.moveToElement(toHover).build().perform();

        WebElement hoverEle = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
        System.out.println(hoverEle.getText());

    }

    public void menuClick(){
        WebElement toolTip = driver.findElement(By.xpath("//span[text()='Menu']"));
        scrollTillTheElement(toolTip);
        toolTip.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Menu']")));

        WebElement mainItem2= driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions a = new Actions(driver);
        a.moveToElement(mainItem2).build().perform();

        WebElement subSubList2 = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        a.moveToElement(subSubList2).build().perform();

        driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']")).click();
    }

    public void selectMenuClick(){
        WebElement selectMenu = driver.findElement(By.xpath("//span[text()='Select Menu']"));
        scrollTillTheElement(selectMenu);
        selectMenu.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Select Menu']")));

        WebElement selecting = driver.findElement(By.id("oldSelectMenu"));
        Select s = new Select(selecting);
        s.selectByVisibleText("Yellow");
    }

}
