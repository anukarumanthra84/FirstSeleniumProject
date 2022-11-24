package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecuterUtil {
    public static void flash(WebElement webElement, WebDriver driver){
        String bgcolor=webElement.getCssValue("backgroundColor");
        System.out.println("Color=="+bgcolor);
        for(int i=0;i<100;i++){
            changeColor("#000000",webElement,driver);
            changeColor(bgcolor,webElement,driver);
        }
    }
    public static void changeColor(String color,WebElement webElement,WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundcolor='"+ color+"'",webElement);
        try{
            Thread.sleep(200);
        }catch(InterruptedException ex){

        }

    }

    public static void drawBorder(WebElement element, WebDriver d) {
        JavascriptExecutor js=(JavascriptExecutor)d;
        js.executeScript("arguments[0].style.border='5px solid red'",element);
    }

    public static String getTitle(WebDriver d) {
        JavascriptExecutor js=(JavascriptExecutor)d;
        return js.executeScript("return document.title").toString();
    }

    public static void generateAlert(WebDriver d, String message) {
        JavascriptExecutor js=(JavascriptExecutor)d;
        js.executeScript("alert('"+message+"')");
    }

    public static void scrollTillElementIsInView(WebElement element, WebDriver d) {
        JavascriptExecutor js=(JavascriptExecutor)d;
        js.executeScript("arguments[0].scrollIntoview(true)",element);
    }
    public static void scrollTillEndOfThePage(WebDriver d){
        JavascriptExecutor js=(JavascriptExecutor)d;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
}
