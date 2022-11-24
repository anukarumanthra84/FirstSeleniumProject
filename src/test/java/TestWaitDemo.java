import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestWaitDemo {
   WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testImplicitWait(){
      d.get("https://www.google.com/");
      d.manage().window().maximize();
      d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      d.findElement(By.xpath("//button[@id='L2AGLb']")).click();
      d.findElement(By.name("q")).sendKeys("Automation");
        d.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }
}
