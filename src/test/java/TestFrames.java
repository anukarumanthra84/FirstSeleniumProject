import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrames {
    WebDriver d;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
    }

    @Test
    public void testFrame() {
        d.get("https://demoqa.com/frames");
        // System.out.println(d.findElement(By.id("sampleHeading")));
        System.out.println(d.findElements(By.tagName("iframe")).size());
       // d.switchTo().frame("frame1");
        d.switchTo().frame(0);
        String sampleHeading = d.findElement(By.id("sampleHeading")).getText();
        System.out.println(sampleHeading);
    }

    @Test
    public void testNestedFrame() {
     d.get("https://demoqa.com/nestedframes");
        System.out.println(d.findElements(By.tagName("iframe")).size());
        d.switchTo().frame("frame1");
        System.out.println(d.findElement(By.tagName("body")).getText());
        System.out.println(d.findElements(By.tagName("iframe")).size());
        d.switchTo().frame(0);
        System.out.println(d.findElement(By.tagName("p")).getText());
        d.switchTo().parentFrame();
        System.out.println(d.findElement(By.tagName("body")).getText());
        d.switchTo().defaultContent();
        System.out.println(d.findElement(By.xpath("//div[contains(text(),'Nested Frames')]")).getText());
    }
}
