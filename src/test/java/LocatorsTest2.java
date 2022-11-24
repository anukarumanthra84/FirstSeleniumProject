import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LocatorsTest2 extends BaseSetUp{
    private Logger log=Logger.getLogger(LocatorsTest2.class);
    private WebDriver d;
    private Properties p;
    @Before
    public void setUp() {
        d = getWebDriver();
        p=getObjRepo();
        log.info("Childclass Before called");
    }
    @Test
    public void testLocatorUsingId(){
        d.get("http://automationpractice.com/index.php");
        d.manage().window().maximize();
        WebElement searchElement=d.findElement(By.id("search_query_top"));
        searchElement.sendKeys("T-shirt");
    }
    @Test
    public void testLocatorUsingClass(){
        d.get("http://automationpractice.com/index.php");
        d.manage().window().maximize();
        WebElement searchElement=d.findElement(By.id("search_query_top"));
        searchElement.sendKeys("T-shirt");
        WebElement searchButton=d.findElement(By.name("submit_search"));
        searchButton.click();
    }
    @Test
    public void testLocatorUsingLinkTest(){
       // d.get("http://automationpractice.com/index.php");
        d.get("https://www.bbc.co.uk/");
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.manage().window().maximize();
        d.findElement(By.linkText("Sport")).click();
        d.findElement(By.partialLinkText("Watch Winter Olympics day 16")).click();

       // WebElement searchElement=d.findElement(By.id("search_query_top"));
        //searchElement.sendKeys("T-shirt");
       // WebElement searchButton=d.findElement(By.name("submit_search"));
        //searchButton.click();
    }
    @Test
    public void testLocatorsUsingClassName(){
        d.get("http://automationpractice.com/index.php");
        d.manage().window().maximize();
        System.out.println(d.findElements(By.className("homeslider-container")).size());
    }
    @Test
    public void testLocatorsUsingTagName(){
        d.get("http://automationpractice.com/index.php");
        d.manage().window().maximize();
        System.out.println(d.findElements(By.tagName("a")).size());
        System.out.println(d.findElements(By.tagName("img")).size());
    }
    @Test
    public void testLocatorsUsingCssSelector(){
        d.get("https://www.facebook.com/");
        d.manage().window().maximize();
        //by tag and id
       // WebElement userName=d.findElement(By.cssSelector("input#email"));
        //userName.sendKeys("anu.peethambaran101@gmail.com");
        //by tag and attribute
        //WebElement userName=d.findElement(By.cssSelector("input[name=email]"));
       // userName.sendKeys("anu.peethambaran101@gmail.com");
        //by tag class and attribute
        WebElement userName=d.findElement(By.cssSelector("input.inputtext[name=email]"));
        userName.sendKeys("anu.peethambaran101@gmail.com");
    }
    @Test
    public void testLocatorsUsingXpath(){
        d.get("https://opensource-demo.orangehrmlive.com/");
        d.manage().window().maximize();
        WebElement userName=d.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password=d.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement login=d.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();
    }
    @Test
    public void testLocatorsWithAndOr(){
        d.get("http://automationpractice.com/index.php");
        d.manage().window().maximize();
        d.findElement(By.xpath("//input[@name='search_query' or @id=\'search_query_top\']")).sendKeys("T-shirt");
        d.findElement(By.xpath("//button[@name='submit_search' and @type='submit']")).click();
    }
    @Test
    public void testLocatorsWithContains(){
        d.get("https://opensource-demo.orangehrmlive.com/");
        d.manage().window().maximize();
        d.findElement(By.xpath("//input[contains(@id,'txtU')]")).sendKeys("Admin");
        d.findElement(By.xpath("//input[contains(@name,'txtPass')]")).sendKeys("admin123");
        d.findElement(By.xpath("//input[contains(@class,'button')]")).click();
    }
    @Test
    public void testLocatorsWithTextFn() {
        d.get("https://opensource-demo.orangehrmlive.com/");
        d.manage().window().maximize();
        d.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        ////form[@id='searchbox']//input[4]
        ////form[@id='searchbox']//button
    }
    @Test
    public void testLocatorsWithChainedXpath(){
        d.get("http://automationpractice.com/index.php");
        d.manage().window().maximize();
        d.findElement(By.xpath("//form[@id='searchbox']//input[4]")).sendKeys("T-shirt");
        d.findElement(By.xpath("//form[@id='searchbox']//button")).click();
    }
}

