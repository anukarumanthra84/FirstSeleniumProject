import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class DatePickerDemo {
    private WebDriver d;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
    }

    @Test
    public void datePickerTest() throws AWTException {
        String expectedDate = "10-May-2022";
        String[] dateArray = expectedDate.split("-");
        String eDate = dateArray[0];
        String eMonthYear = dateArray[1] + " " + dateArray[2];
        d.get("https://www.spicejet.com/");
        d.manage().window().maximize();
       /* Robot robot = new Robot();
        robot.delay(5000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);*/
        d.findElement(By.xpath("//div[contains(text(),'Departure Date')]")).click();
        String monthYear = d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).getText();
        String monthYear2 = d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")).getText();
        String monthYear3 = d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]")).getText();
        String monthYear4 = d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]")).getText();
        System.out.println(monthYear);
        System.out.println(monthYear2);
        System.out.println(monthYear3);
        System.out.println(monthYear4);
        System.out.println(eMonthYear);
        WebElement element;
        if(eMonthYear.equals(monthYear)){
            element=d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]\""));
            element.click();
        }
        else if(eMonthYear.equals(monthYear2)){
            element=d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
            element.click();
        }
        else if(eMonthYear.equals(monthYear3)){
            element=d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]"));
            element.click();
        }
      WebElement we=d.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/div[3]"));

    }
}
