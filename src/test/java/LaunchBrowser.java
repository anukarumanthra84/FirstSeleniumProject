import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LaunchBrowser {
    public static void main(String[] args) throws IOException {
        //testChromeDriverLaunch();
        //testFirefoxDriverLaunch();
        testDriverManager();
    }

    private static void testChromeDriverLaunch() {
        String driverPath="C:\\Automation\\Drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        System.out.println(System.getProperties());
        WebDriver d=new ChromeDriver();
        d.get("https://www.bbc.co.uk/");
        if(d.getTitle().startsWith("BBC")){
            System.out.println("Chrome Launch TestCase Passed");
        }
        else{
            System.out.println("Chrome Launch Test case Failed");
        }
    }
    private static void testFirefoxDriverLaunch()throws IOException {
        Properties p=new Properties();
        p.load(new FileInputStream(new File("selenium.properties")));
        String driverPath=p.get("firefox.driver.path").toString();
        System.setProperty("webdriver.gecko.driver",driverPath);
        WebDriver d=new FirefoxDriver();
        d.get("https://edition.cnn.com/");
        if(d.getTitle().contains("CNN")){
            System.out.println("Firefox Launch Testcase passed");
        }else{
            System.out.println("Firefox Launch testcase failed");
        }
    }
    private static void testDriverManager(){
        WebDriverManager.chromedriver().setup();
        WebDriver d=new ChromeDriver();
        d.get("https://www.amazon.co.uk/");
        System.out.println("Using Chrome Driver "+d.getTitle());
        d.quit();
    }
}
