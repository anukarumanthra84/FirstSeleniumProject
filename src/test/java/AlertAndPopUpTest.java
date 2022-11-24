import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndPopUpTest {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testSimpleAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        d.findElement(By.id("alertButton")).click();
        Alert alert=d.switchTo().alert();
        alert.accept();
    }
    @SneakyThrows
    @Test
    public void testPromptAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        WebElement element=d.findElement(By.id("promtButton"));
        //element.click();

        ((JavascriptExecutor)d).executeScript("arguments[0].click()",element);
        Alert promptAlert=d.switchTo().alert();
        String alertText=promptAlert.getText();
        System.out.println("Alert text is: "+alertText);
        promptAlert.sendKeys("testuserkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Thread.sleep(5000);
        promptAlert.accept();
    }
    @Test
    public void testConfirmationAlert() {
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        WebElement element=d.findElement(By.id("confirmButton"));
        ((JavascriptExecutor)d).executeScript("arguments[0].click()",element);
        Alert confirmationAlert=d.switchTo().alert();
        System.out.println(confirmationAlert.getText());
        confirmationAlert.accept();
    }
    @Test
    public void testAlertWithNoUsernameAndPassword(){
        d.get("https://mail.rediff.com");
        d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        d.findElement(By.xpath("//input[@title='Sign in']")).click();
        Alert alert=d.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Please enter a valid user name",alert.getText());
        alert.dismiss();
    }
    @Test
    public void testAlertWithUsernameAndNoPassword(){
        d.get("https://mail.rediff.com");
        d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        d.findElement(By.xpath("//input[@id='login1']")).sendKeys("abcd");
        d.findElement(By.xpath("//input[@title='Sign in']")).click();
        Alert alert=d.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Please enter your password",alert.getText());
        alert.dismiss();
    }
@Test
    public void testUploadFile(){
        d.get("https://html.com/input-type-file/");
        d.findElement(By.id("fileupload")).sendKeys("C:\\Users\\anuoc\\Desktop\\screen-1.jpg");
}
@Test
     public void basicAuthenticationWithCredentials(){
        //d.get("https://the-internet.herokuapp.com/basic_auth");
        d.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    Assert.assertEquals("Congratulations! You must have the proper credentials.",d.findElement(By.tagName("p")).getText());
}
@Test
    public void testFacebookAccountCreation(){
        d.get("https://www.facebook.com/");
        d.findElement(By.xpath("//button[@data-cookiebanner=\"accept_button\"]")).click();
        //d.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
    JavascriptExecutor js=(JavascriptExecutor)d;
    js.executeScript("document.getElementById('email').value=\"adnan@gmail.com\"");
}
    
}
