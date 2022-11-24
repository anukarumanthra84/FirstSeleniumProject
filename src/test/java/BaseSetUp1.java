import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseSetUp1 {
    private static Logger log=Logger.getLogger(BaseSetUp1.class);
    private WebDriver d=null;
    private static Properties objRepo=null;
    private static DriverManagerType browser=null;
    public static int count=0;
    @SneakyThrows
    public void init(){
        if(d==null){
            System.out.println("Fully Classified name: "+browser.browserClass());
            Class<?>chromeClass=Class.forName(browser.browserClass());
            d=(WebDriver)chromeClass.newInstance();
        }
        log.info("Before Child Class called");
    }
    @BeforeClass
    public static void setUpForAllTest(){
        PropertyConfigurator.configure("log4j.properties");
        log.info("before class");
        objRepo=loadObjectRepository();
        browser=DriverManagerType.valueOf(objRepo.get("browser").toString().toUpperCase());
        WebDriverManager.getInstance(browser).setup();
    }
    @SneakyThrows
    private static Properties loadObjectRepository(){
        objRepo=new Properties();
        objRepo.load(new FileInputStream(new File("OR.properties")));
        return objRepo;
    }
    public Properties getObjRepo(){
        return objRepo;
    }
 public WebDriver getWebDriver(){
       return d;
   }
    @AfterClass
    public static void cleanUpForBaseClass(){
        objRepo=null;
    }
}

