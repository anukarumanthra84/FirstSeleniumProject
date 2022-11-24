import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestMouseEvents {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testKeyEventWithShift(){
        d.get("https://demoqa.com/auto-complete");
        d.manage().window().maximize();
        WebElement element=d.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));

        Actions actions=new Actions(d);
        actions.keyDown(element, Keys.SHIFT);

        actions.sendKeys("We succeed when our efforts are more than our excuses");

        actions.keyUp(Keys.SHIFT);
        actions.build().perform();
    }
    @Test
    public void testMouseClick(){
        d.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        d.manage().window().maximize();
        Actions actions=new Actions(d);
        WebElement btnElement=d.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        actions.contextClick(btnElement).perform();
        System.out.println("Right click context menu is displayed");
        WebElement elementOpen=d.findElement(By.xpath("//body/ul[1]/li[3]"));
        elementOpen.click();
        d.switchTo().alert().accept();
    }
    @Test
    public void testDoubleClick(){
        d.get("https://demoqa.com/buttons");
        d.manage().window().maximize();
        Actions actions=new Actions(d);
        WebElement btnElement=d.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(btnElement).perform();
        Assert.assertEquals("You have done a double click",d.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText());
    }
    @Test
    public void dragAndDrop(){
        d.get("https://demoqa.com/droppable/");
        d.manage().window().maximize();
        Actions actions=new Actions(d);
        WebElement from=d.findElement(By.id("draggable"));
        WebElement to=d.findElement(By.id("droppable"));
        //actions.dragAndDrop(from,to).perform();

        actions.clickAndHold(from).moveToElement(to).release().build().perform();
        String text=to.getText();
        Assert.assertEquals("Dropped!",text);
    }
    @Test
    public void dragAndDropBy(){
        d.get("https://jqueryui.com/slider/");
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Actions builder=new Actions(d);
        d.switchTo().frame(0);
        WebElement from=d.findElement(By.id("slider"));
        builder.dragAndDropBy(from,100,100).perform();
        System.out.println("Dropped");
    }
    @Test
    public void testMouseHoverAction(){
        d.get("https://opensource-demo.orangehrmlive.com/");
        d.manage().window().maximize();
        d.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        d.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        d.findElement(By.xpath("//input[@id='btnLogin']")).click();

        WebElement adminElement=d.findElement(By.xpath("//b[normalize-space()='Admin']"));
        Actions actions=new Actions(d);
        actions.moveToElement(adminElement).perform();
        WebElement userManagement=d.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
        actions.moveToElement(userManagement).perform();
        WebElement viewUsers=d.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"));
        actions.moveToElement(viewUsers).click().perform();
    }
    @Test
    public void toolTipDemo(){
        d.get("http://seleniumpractise.blogspot.com/2019/09/bootstrap-tooltip-in-selenium.html");
        d.manage().window().maximize();
        WebElement toolTipButton=d.findElement(By.linkText("Hover over me"));
        Actions actions=new Actions(d);
        actions.moveToElement(toolTipButton).perform();
        String text= d.findElement(By.xpath("//div[text()='Hooray!']")).getText();
        Assert.assertEquals("Hooray!",text);
    }
    @Test
    public void toolTipDemo2(){
        d.get("http://seleniumpractise.blogspot.com/2019/08/tooltip-in-selenium-or-help-text-example.html");
        d.manage().window().maximize();
        
    }
}
