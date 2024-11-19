package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertFrameWindowClass extends BaseClass {

    public void newTabBrowserWindows() throws InterruptedException {
        //click on browser windows
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        //Scroll to browser windows heading
        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Browser Windows']")));

        //Click on new tab button
        driver.findElement(By.id("tabButton")).click();

        String parentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();

        for(String tab: tabs){
            if(!tab.equals(parentTab))
                driver.switchTo().window(tab);
        }
        assertTrue(driver.findElement(By.xpath("//h1[text()='This is a sample page']")).isDisplayed());
    }
    public void newWindowBrowserWindows(){
        //click on browser windows
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        //Scroll to browser windows heading
        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Browser Windows']")));

        //Click on new window button
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        scrollTillTheElement(newWindow);
        newWindow.click();
        String parentTab1 = driver.getWindowHandle();
        Set<String> tabs1 = driver.getWindowHandles();

        for(String tab: tabs1){
            if(!tab.equals(parentTab1)){
                driver.switchTo().window(tab);
            }
        }
        assertTrue(driver.findElement(By.xpath("//h1[text()='This is a sample page']")).isDisplayed());
    }

    public void newWindowMessageBrowserWindows(){
        //click on browser windows
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

        //Scroll to browser windows heading
        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Browser Windows']")));

        //Click On new window message
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        scrollTillTheElement(newWindowMessage);
        newWindowMessage.click();

        String parentTab2 = driver.getWindowHandle();
        Set<String> tabs2 = driver.getWindowHandles();

        for(String tab: tabs2){
            if(!tab.equals(parentTab2)){
                driver.switchTo().window(tab);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        String s=driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']")).getText();
        WebElement element = driver.findElement(By.tagName("body"));
        System.out.println(element.getText());
    }
    public void alertsButton1() {
        //click on alerts
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();

        //Scroll till alert heading
        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Alerts']")));

        //Click on button 1
        driver.findElement(By.id("alertButton")).click();
        Alert a = driver.switchTo().alert();
        a.accept();
    }
    public void alertsButton2() throws InterruptedException {
        //click on alerts
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();

        //Scroll till alert heading
        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Alerts']")));

        //Click on button 2
        WebElement button2 = driver.findElement(By.id("timerAlertButton"));
        scrollTillTheElement(button2);
        button2.click();
        sleep(6000);
        Alert a1= driver.switchTo().alert();
        a1.accept();
    }
    public void alertsButton3(){
        //click on alerts
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();

        //Scroll till alert heading
        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Alerts']")));

        //click on button 3
        driver.findElement(By.id("confirmButton")).click();
        Alert a2 = driver.switchTo().alert();
        a2.dismiss();

        //Verifying dismiss selected
        String s=driver.findElement(By.id("confirmResult")).getText();
        assertEquals(s, "You selected Cancel");
    }

    public void alertsButton4() throws InterruptedException {
        //click on alerts
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();

        //Scroll till alert heading
        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Alerts']")));

        //click on button 4
        driver.findElement(By.id("promtButton")).click();

        Alert a3= driver.switchTo().alert();
        a3.sendKeys("Prerna Jain");
        Thread.sleep(3000);
        a3.accept();

        //Verifying
        String s1= driver.findElement(By.id("promptResult")).getText();
        assertEquals(s1,"You entered Prerna Jain");
    }

    public void frame(){
        //click on frames
        driver.findElement(By.xpath("//span[text()='Frames']")).click();

        //Switch to frame by id, index or webelement
        //By id
        driver.switchTo().frame("frame1");
        String verify = driver.findElement(By.id("sampleHeading")).getText();
        assertEquals(verify, "This is a sample page");
    }

    public void nestedFrame(){
        //click on nested frames
        driver.findElement(By.xpath("//span[text()='Nested Frames']")).click();

        //By webElement switching to frame
        WebElement ele = driver.findElement(By.xpath("//iframe[@src='/sampleiframe']"));
        driver.switchTo().frame(ele);

        String parentFrame= driver.findElement(By.xpath("//body[text()='Parent frame']")).getText();
        assertEquals(parentFrame, "Parent frame");

        //By index swiching to child frame
        driver.switchTo().frame(0);
        String childFrame = driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText();
        assertEquals(childFrame, "Child Iframe");

        //Switching to parent iframe
        driver.switchTo().parentFrame();
        String parentFrameAgain= driver.findElement(By.xpath("//body[text()='Parent frame']")).getText();
        assertEquals(parentFrameAgain, "Parent frame");

        driver.switchTo().defaultContent();
    }

    public void modalDialog() throws InterruptedException {
        //click on modal dialogs
        sleep(3000);
        WebElement modal = driver.findElement(By.xpath("//span[text()='Modal Dialogs']"));
        scrollTillTheElement(modal);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sleep(8000);
        modal.click();

        //click on small modal
        driver.findElement(By.id("showSmallModal")).click();
        System.out.println(driver.findElement(By.className("modal-body")).getText());
        driver.findElement(By.id("closeSmallModal")).click();

        Thread.sleep(2000);

        //click on Large modal
        driver.findElement(By.id("showLargeModal")).click();
        System.out.println(driver.findElement(By.className("modal-body")).getText());
        driver.findElement(By.id("closeLargeModal")).click();
    }
}
