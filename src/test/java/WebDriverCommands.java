import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WebDriverCommands {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testGetCommands(){
        d.get("https://edition.cnn.com/");
        System.out.println("Current Title is :"+d.getTitle());
        System.out.println("Current url is:"+d.getCurrentUrl());
       // System.out.println("page source is:"+d.getPageSource());
        System.out.println("Get window handle is: "+d.getWindowHandle());
    }
    @Test
    public void testCloseAndQuit(){
        d.get("file:///C:/Users/anuoc/Desktop/My%20Docs/CloseAndQuit.html");
        d.findElement(By.linkText("Visit cnn.com")).click();
        d.quit();
    }
    @Test
    public void testWindowHandles(){
        d.get("file:///C:/Users/anuoc/Desktop/My%20Docs/CloseAndQuit.html");
        d.findElement(By.linkText("Visit cnn.com")).click();
        Set<String> windowHandles=d.getWindowHandles();
        String parentWindowHandle=d.getWindowHandle();
        Iterator<String> iterator=windowHandles.iterator();
        while(iterator.hasNext()){
            String reference_childWindow= iterator.next();
            d.switchTo().window(reference_childWindow);
            System.out.println(d.getTitle());
        }
        d.switchTo().window(parentWindowHandle);
        System.out.println("URL of parent window: "+d.getCurrentUrl());
    }
    @Test
    public void testCQuit2(){
        d.get("https://demoqa.com/browser-windows");
        String parentWindow=d.getWindowHandle();
        d.findElement(By.xpath("//button[@id='tabButton']")).click();
        d.findElement(By.xpath("//button[@id='windowButton']")).click();
        d.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
        System.out.println("Size: "+d.getWindowHandles().size());
        d.switchTo().window(parentWindow);
        //d.quit();
    }

    //new child window within the main window
    @Test
    public void getChildWindow(){
        d.get("https://demoqa.com/browser-windows");
        d.findElement(By.xpath("//button[@id='windowButton']")).click();
        String mainWindowHandle=d.getWindowHandle();
        Set<String> allWindowHandles=d.getWindowHandles();
        Iterator iterator=allWindowHandles.iterator();
    }
    @Test
    public void testNavigateCommands(){
        d.get("https://www.facebook.com/");
        System.out.println("Url via get is : "+d.getCurrentUrl());
        d.navigate().to("https://www.bbc.co.uk/");
        System.out.println("Url via navigate to: "+d.getCurrentUrl());
        d.navigate().back();
        System.out.println("Url via navigate back: "+d.getCurrentUrl());
        d.navigate().forward();
        System.out.println("Url via navigate forward: "+d.getCurrentUrl());
        d.navigate().refresh();
    }
}
