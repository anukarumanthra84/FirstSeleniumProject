import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToBasket {
    private WebDriver d=null;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @After
    public void cleanUp(){
        d.quit();
    }
    @Test
    public void testSuccessfulLogin(){

        d.get("https://www.saucedemo.com/");
        WebElement uname=d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uname.sendKeys("standard_user");
        WebElement password=d.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret_sauce");
        WebElement loginButton= d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        d.get("https://www.saucedemo.com/inventory.html");
        WebElement addToCart1=d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        addToCart1.click();
        WebElement addToCart2=d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
        addToCart2.click();
        WebElement itemCountInBasket=d.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        Assert.assertEquals("2",itemCountInBasket.getText());
    }
}
