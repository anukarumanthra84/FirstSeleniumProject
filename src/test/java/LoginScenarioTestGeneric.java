import org.apache.log4j.Logger;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class LoginScenarioTestGeneric extends BaseSetUp{
    private Logger log=Logger.getLogger(Log.class.getName());
    private WebDriver d;
    private Properties p;
    @Before
    public void setUp(){
        d=getWebDriver();
        p=getObjRepo();
        log.info("child class before called");
    }
    @Test
    public void testSuccessfulLogin(){
        log.info("......Starting testSuccessfulLogin.....");
        d.get(p.get("url").toString());
        WebElement uName=d.findElement(By.xpath(p.get("username").toString()));
        uName.sendKeys(p.get("uname_val").toString());
        WebElement uPassword=d.findElement(By.xpath(p.get("password").toString()));
        uPassword.sendKeys(p.get("upass_val").toString());
        WebElement loginButton=d.findElement(By.xpath(p.get("login_button").toString()));
        loginButton.click();
        WebElement element=d.findElement(By.xpath(p.get("product_label").toString()));
        Assert.assertTrue(element.isDisplayed());
        log.info("Ending testSuccessfulLogin executed");
    }
}
