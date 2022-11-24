import Utils.JSExecuterUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class JsExecuterTest {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    @SneakyThrows
    public void testFlashUsingJSExecuter(){
        d.get("https://www.orangehrm.com/");
        WebElement element=d.findElement(By.xpath("//a[contains(text(),'Book a Free Demo')]"));
       // JSExecuterUtil.flash(element,d);
        JSExecuterUtil.drawBorder(element,d);
        Thread.sleep(100);
        File screenshotAs=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
        File target=new File("C:\\Users\\anuoc\\Desktop\\My Docs\\HRM.jpg");
        FileUtils.copyFile(screenshotAs,target);
    }
    @Test
    public void testGetTitleUsingJSExecuter(){
        d.get("https://www.orangehrm.com/");
       // System.out.println(d.getTitle());
        System.out.println(JSExecuterUtil.getTitle(d));
    }
    @Test
    public void testClickElementByJsExecuter(){
        d.get("https://www.orangehrm.com/");
        WebElement el1=d.findElement(By.xpath("//a[contains(text(),'Contact Sales')]"));
        WebElement el2=d.findElement(By.xpath("//a[contains(text(),'Book a Free Demo')]"));
        JavascriptExecutor js=(JavascriptExecutor)d;
        js.executeScript("arguments[0].click()",el1,el2);
        JSExecuterUtil.generateAlert(d,"You clicked on Contact Sales");
    }
    @Test
    public void testScrollTillElementAppears(){
        d.get("https://www.orangehrm.com/");
        WebElement element=d.findElement(By.xpath("//body/div[5]/div[3]/div[2]/div[1]/div[2]/img[1]"));
        JSExecuterUtil.scrollTillElementIsInView(element,d);
    }
    @Test
    public void testScrollTillEnd(){
        d.get("https://www.orangehrm.com/");
        JSExecuterUtil.scrollTillEndOfThePage(d);
    }
}
