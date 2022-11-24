import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScenarioTest {
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
        WebElement element=d.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        //System.out.println(element.isDisplayed());
        Assert.assertTrue(element.isDisplayed());

    }
    @Test
    public void testSuccessfulLoginCheckUrl(){

        d.get("https://www.saucedemo.com/");
        WebElement uname=d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uname.sendKeys("standard_user");
        WebElement password=d.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret_sauce");
        WebElement loginButton= d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        Assert.assertTrue(d.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));

    }
    @Test
    public void testIncorrectCredentials(){
        d.get("https://www.saucedemo.com/");
        WebElement uname=d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uname.sendKeys("standard_user");
        WebElement password=d.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("ssss");
        WebElement loginButton= d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        WebElement element=d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        //System.out.println(element.isDisplayed());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",element.getText());
        d.quit();
    }
    @Test
    public void testWithNoUsername(){
        d.get("https://www.saucedemo.com/");
        //WebElement uname=d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        //uname.sendKeys("standard_user");
        WebElement password=d.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("ssss");
        WebElement loginButton= d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        WebElement element=d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        //System.out.println(element.isDisplayed());
        Assert.assertEquals("Epic sadface: Username is required",element.getText());
    }
    @Test
    public void testWithNoPassword(){
        d.get("https://www.saucedemo.com/");
        WebElement uname=d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uname.sendKeys("standard_user");
        //WebElement password=d.findElement(By.xpath("//*[@id=\"password\"]"));
        //password.sendKeys("ssss");
        WebElement loginButton= d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        WebElement element=d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        //System.out.println(element.isDisplayed());
        Assert.assertEquals("Epic sadface: Password is required",element.getText());
    }
}
