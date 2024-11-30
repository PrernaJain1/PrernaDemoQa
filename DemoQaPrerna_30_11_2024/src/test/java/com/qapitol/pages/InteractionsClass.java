package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class InteractionsClass extends BaseClass {

    public void sortableList() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Sortable']")).click();
        scrollTillTheElement(driver.findElement(By.id("demo-tab-list")));

        WebElement source = driver.findElement(By.xpath("//div[contains(@class,'vertical-list-container')]//div[text()='Four']"));
        WebElement destination = driver.findElement(By.xpath("//div[contains(@class,'vertical-list-container')]//div[text()='Two']"));

        Actions a = new Actions(driver);
        a.clickAndHold(source).dragAndDrop(source,destination).build().perform();
        Thread.sleep(5000);
    }

    public void sortableGrid() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Sortable']")).click();

        //For grid
        WebElement w1=driver.findElement(By.id("demo-tab-grid"));
        scrollTillTheElement(w1);
        w1.click();

        WebElement sourceGrid=driver.findElement(By.xpath("//div[contains(@class,'create-grid')]//div[text()='Five']"));
        WebElement targetGrid=driver.findElement(By.xpath("//div[contains(@class,'create-grid')]//div[text()='Three']"));

        Actions a1= new Actions(driver);
        a1.clickAndHold(sourceGrid).dragAndDrop(sourceGrid,targetGrid).build().perform();
        Thread.sleep(5000);
    }

    public void selectableList() throws InterruptedException {
        //Click on selectable
        driver.findElement(By.xpath("//span[text()='Selectable']")).click();
        //scroll
        scrollTillTheElement(driver.findElement(By.id("demo-tab-list")));
        //elements
        List<WebElement> elements= driver.findElements(By.xpath("//div[@id='demo-tabpane-list']/ul/li"));
        for(WebElement web : elements){
            web.click();
        }
    }

    public void selectableGrid() throws InterruptedException {
        //Click on selectable
        driver.findElement(By.xpath("//span[text()='Selectable']")).click();
        WebElement w= driver.findElement(By.id("demo-tab-grid"));
        scrollTillTheElement(w);
        w.click();

        List<WebElement> elements1= driver.findElements(By.xpath("//div[@class='list-group list-group-horizontal-sm']//li"));
        for(WebElement we: elements1){
            we.click();
        }
    }

    public void resizable1(){
        driver.findElement(By.xpath("//span[text()='Resizable']")).click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Resizable']")));

        WebElement resize = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']//span[@class='react-resizable-handle react-resizable-handle-se']"));
        Actions a =new Actions(driver);
        a.clickAndHold(resize).dragAndDropBy(resize,170,69).build().perform();
    }

    public void resizable2(){
        driver.findElement(By.xpath("//span[text()='Resizable']")).click();

        scrollTillTheElement(driver.findElement(By.xpath("//div[text()='Resizable']")));

        WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']//span[@class='react-resizable-handle react-resizable-handle-se']"));
        Actions a =new Actions(driver);
        a.clickAndHold(resize).dragAndDropBy(resize,227,28).build().perform();
    }

    public void droppableSimple(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Droppable']"));
        scrollTillTheElement(w);
        w.click();

        scrollTillTheElement(driver.findElement(By.id("droppableExample-tab-simple")));

        WebElement dragmMe= driver.findElement(By.id("draggable"));
        WebElement dropHere = driver.findElement(By.id("droppable"));

        Actions a= new Actions(driver);
        a.clickAndHold(dragmMe).moveToElement(dropHere).release().perform();
//        a.clickAndHold(dragmMe).dragAndDrop(dragmMe,dropHere).build().perform();

    }

    public void droppableAccept(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Droppable']"));
        scrollTillTheElement(w);
        w.click();

        WebElement accept= driver.findElement(By.id("droppableExample-tab-accept"));
        scrollTillTheElement(accept);
        accept.click();

        WebElement acceptable = driver.findElement(By.id("acceptable"));
        WebElement notAcceptable= driver.findElement(By.xpath("//div[text()='Not  Acceptable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//p[text()='Drop here'])[2]"));

        Actions a= new Actions(driver);

        //Drop non-acceptable verify text
        a.clickAndHold(notAcceptable).dragAndDrop(notAcceptable,dropHere).build().perform();
        String s = dropHere.getText();
        assertEquals(s,"Drop here");

        //Drop acceptable verify text
        a.clickAndHold(acceptable).dragAndDrop(acceptable,dropHere).build().perform();
        String s1 = dropHere.getText();
        assertEquals(s1,"Dropped!");
    }

    public void droppablePreventPropagation(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Droppable']"));
        scrollTillTheElement(w);
        w.click();

        WebElement preventPropagation= driver.findElement(By.id("droppableExample-tab-preventPropogation"));
        scrollTillTheElement(preventPropagation);
        preventPropagation.click();

        WebElement dragMe= driver.findElement(By.xpath("//div[text()='Drag Me']"));
        WebElement notGreedyOuterDroppable = driver.findElement(By.xpath("(//div[@id='notGreedyDropBox']//p)[1]"));
        WebElement notGreedyInnerDroppable= driver.findElement(By.id("notGreedyDropBox"));
        WebElement greedyOuterDroppable = driver.findElement(By.xpath("(//div[@id='greedyDropBox']//p)[1]"));
        WebElement greedyInnerDroppable= driver.findElement(By.id("greedyDropBoxInner"));

        Actions a= new Actions(driver);
        a.clickAndHold(dragMe).moveToElement(notGreedyInnerDroppable).release().build().perform();
        String s = notGreedyOuterDroppable.getText();
        assertEquals(s, "Dropped!");

        a.clickAndHold(dragMe).moveToElement(greedyInnerDroppable).release().build().perform();
        String s1 = greedyOuterDroppable.getText();
        assertEquals(s1,"Outer droppable");

    }

    public void droppableRevertDraggable(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Droppable']"));
        scrollTillTheElement(w);
        w.click();

        //Revert
        WebElement revertDraggable= driver.findElement(By.id("droppableExample-tab-revertable"));
        scrollTillTheElement(revertDraggable);
        revertDraggable.click();

        WebElement revert= driver.findElement(By.id("revertable"));
        WebElement notRevert= driver.findElement(By.id("notRevertable"));
        WebElement dropHere= driver.findElement(By.xpath("(//p[text()='Drop here'])[3]"));

        Actions a =new Actions(driver);
        a.clickAndHold(revert).moveToElement(dropHere).release().build().perform();
        a.clickAndHold(notRevert).moveToElement(dropHere).release().build().perform();

        String s = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        assertEquals(s, "Dropped!");
    }

    public void draggableSimple(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Dragabble']"));
        scrollTillTheElement(w);
        w.click();

        scrollTillTheElement(driver.findElement(By.id("draggableExample-tab-simple")));

        WebElement dragMe = driver.findElement(By.xpath("//div[text()='Drag me']"));
        Actions a = new Actions(driver);
        a.clickAndHold(dragMe).moveByOffset(50,50).release().build().perform();

    }

    public void draggableAxisRestricted(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Dragabble']"));
        scrollTillTheElement(w);
        w.click();

        WebElement axis = driver.findElement(By.id("draggableExample-tab-axisRestriction"));
        scrollTillTheElement(axis);
        axis.click();

        WebElement x= driver.findElement(By.id("restrictedX"));
        WebElement y= driver.findElement(By.id("restrictedY"));

        Actions a = new Actions(driver);
        a.clickAndHold(x).moveByOffset(50,0).release().build().perform();
        a.clickAndHold(y).moveByOffset(0,50).release().build().perform();

    }

    public void draggableContainerRestricted(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Dragabble']"));
        scrollTillTheElement(w);
        w.click();

        WebElement container=driver.findElement(By.id("draggableExample-tab-containerRestriction"));
        scrollTillTheElement(container);
        container.click();

        WebElement restrictedContainer = driver.findElement(By.xpath("//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']"));
        Actions a = new Actions(driver);
        a.clickAndHold(restrictedContainer).moveByOffset(50,50).release().build().perform();

        WebElement text = driver.findElement(By.xpath("//span[text()=\"I'm contained within my parent\"]"));
        a.clickAndHold(text).dragAndDropBy(text, 0,25).build().perform();
    }

    public void draggableCursorStyle(){
        WebElement w= driver.findElement(By.xpath("//span[text()='Dragabble']"));
        scrollTillTheElement(w);
        w.click();

        WebElement cursorStyle = driver.findElement(By.id("draggableExample-tab-cursorStyle"));
        cursorStyle.click();



    }
}
