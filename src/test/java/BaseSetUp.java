import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

@Setter
public class BaseSetUp {
    private static Logger log= Logger.getLogger(BaseSetUp.class);
    private WebDriver webDriver=null;
    private static Properties objRepo=null;
    private static DriverManagerType browser=null;
    private static int count=0;
    @Before
    @SneakyThrows
    public void init() {
        if (webDriver == null) {
            Class<?> chromeClass = Class.forName(browser.browserClass());
            webDriver = (WebDriver) chromeClass.newInstance();
        }
            log.info("before of parent class called");
            objRepo = loadObjectRepository();

    }
    @BeforeClass
    public static void setUpForAllTest(){
        PropertyConfigurator.configure("log4j.properties");
        log.info("before class");
        objRepo=loadObjectRepository();
        browser=DriverManagerType.valueOf(objRepo.get("browser").toString());
        WebDriverManager.getInstance(browser).setup();
    }
        @SneakyThrows
        private static Properties loadObjectRepository(){
           objRepo=new Properties();
           objRepo.load(new FileInputStream("OR.properties"));
           return objRepo;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
    public Properties getObjRepo() {
        return objRepo;
    }
}
