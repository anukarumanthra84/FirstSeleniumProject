import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementDemo {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testFindByElement(){
        d.get("https://www.guru99.com/");
        WebElement javaTechnologies=d.findElement(By.id("java_technologies"));
        System.out.println(javaTechnologies.findElement(By.xpath(".//a[@title='JUnit']")).getText());
       // System.out.println(javaTechnologies.findElement(By.xpath("//a[@title='Numpy']")).getText());
        //System.out.println(javaTechnologies.findElements(By.xpath(".//a[@title='Numpy']"));
        System.out.println(javaTechnologies.findElements(By.xpath(".//a")).size());
        System.out.println(javaTechnologies.findElements(By.xpath("//a")).size());
    }
}
