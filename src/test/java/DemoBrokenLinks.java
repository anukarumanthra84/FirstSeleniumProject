import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;


public class DemoBrokenLinks extends BaseSetUp {
    WebDriver d;
    Properties p;
    @Before
    public void init(){
        if(d==null)
            super.init();
        d=getWebDriver();
        p=getObjRepo();
    }
    @Test
    public void test(){
        d.get("https://demoqa.com/broken");
        List<WebElement> links=d.findElements(By.tagName("a"));
        System.out.println("Number of Links are: "+links.size());
        for(WebElement el:links){
            String href=el.getAttribute("href");
            verifyLinks(href);
        }
    }

    private void verifyLinks(String href) {
        try{
            URL url=new URL(href);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()>=400){
                System.out.println(href +" - "+httpURLConnection.getResponseMessage()+"is broken");
            }
            else{
                System.out.println(href+" - "+httpURLConnection.getResponseMessage());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
