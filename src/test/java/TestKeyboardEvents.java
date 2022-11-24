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

public class TestKeyboardEvents {
    private WebDriver d;
    @Before
    public void init(){

        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void keyboardEvents(){
        d.get("https://demoqa.com/text-box");
        d.manage().window().maximize();
        Actions actions=new Actions(d);
        WebElement fullName=d.findElement(By.id("userName"));
        fullName.sendKeys("Anu K P");
        WebElement eMail=d.findElement(By.id("userEmail"));
        eMail.sendKeys("anu@gmail.com");
        WebElement currentAddress=d.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43,Tender Drive,London");
        WebElement permanantAddress=d.findElement(By.id("permanentAddress"));
        actions.keyDown(currentAddress, Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        Assert.assertEquals(currentAddress.getAttribute("value"),permanantAddress.getAttribute("value"));



    }
}
