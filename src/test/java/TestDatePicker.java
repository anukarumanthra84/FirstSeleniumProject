import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestDatePicker {
   private WebDriver d;
   @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void datePickerTest() throws InterruptedException {
        String expectedDate = "10-May-2022";
        String[] dateArray = expectedDate.split("-");
        String eDate = dateArray[0];
        String eMonthYear = dateArray[1] + " " + dateArray[2];
       d.get("https://www.skyscanner.net/?previousCultureSource=COOKIE&redirectedFrom=www.skyscanner.com");
        d.findElement(By.xpath("//button[@id='acceptCookieButton']")).click();
       d.manage().window().maximize();
       d.findElement(By.xpath("//button[@id='depart-fsc-datepicker-button']")).click();
       d.findElement(By.xpath("//select[@id='depart-calendar__bpk_calendar_nav_select']")).click();
        Select select=new Select(d.findElement(By.xpath("//select[@id=\"depart-calendar__bpk_calendar_nav_select\"]")));
        select.selectByVisibleText(eMonthYear);
        d.findElement(By.xpath("//select[@id='depart-calendar__bpk_calendar_nav_select']")).click();
        List<WebElement> li=d.findElements(By.xpath("//tbody/tr"));
        for(WebElement el:li){
            WebElement el1=el.findElement(By.xpath("//button[contains(@aria-label,eDate)]"));
            System.out.println(el1);
            //[contains(@aria-label, 'Bewertungspunktestand:')]
        }
    }

}
