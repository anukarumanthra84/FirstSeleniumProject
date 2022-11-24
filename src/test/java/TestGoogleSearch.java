import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class TestGoogleSearch {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testGoogle(){
        d.get("https://www.google.com/");
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.findElement(By.id("L2AGLb")).click();
        d.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Automation");
        d.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(Keys.RETURN);
        getWebElementByExplicitWait(d,60,By.xpath("//h3[contains(text(),'Automation - Wikipedia')]")).click(); ;

    }
    public static WebElement getWebElementByExplicitWait(WebDriver driver,int timeOut,By locator){
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;

    }
    public void testFluentWait(){
        
    }
}
