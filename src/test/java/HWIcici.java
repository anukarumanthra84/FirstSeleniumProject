import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWIcici {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void loginWithNoUsernamePassword(){
          d.get("https://www.icicibank.com/");
         d.findElement(By.xpath("//a[@style='text-decoration: none; font-weight: bold; display: inline-block; color: #fff; " +
                 "text-transform: uppercase; background: #f5821f; text-align: center; line-height: 38px; height: 34px !important; " +
                 "font-size: 13px; width: 80px; margin-left: 28%;margin-top: 12px;']")).click();


          //d.findElement(By.xpath("//a[@id='login-btn']")).click();
//        d.findElement(By.xpath("//input[@id='AuthenticationFG.USER_PRINCIPAL']")).click();
//        d.findElement(By.xpath("//input[@id='VALIDATE_CREDENTIALS1']")).click();
//        Alert alert1=d.switchTo().alert();
//        Assert.assertEquals("Please enter your User ID",alert1.getText());
    }
}
