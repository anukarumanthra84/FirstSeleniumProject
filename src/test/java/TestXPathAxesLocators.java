import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestXPathAxesLocators {
    private WebDriver d;
    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
    }
    @Test
     public void testXPath() {
        d.get("https://money.rediff.com/gainers");
        d.manage().window().maximize();
        //using self
        String text = d.findElement(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a")).getText();
        System.out.println(text);
        //using parent
        String text1 = d.findElement(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/parent::td")).getText();
        System.out.println(text1);
        //using ancestor
        List<WebElement> elements = d.findElements(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/ancestor::tr/child::td"));
        System.out.println("No of Child Elements: " + elements.size());
        Assert.assertEquals(5, elements.size());
        //ancestors of all type
//        WebElement ancestorNode =d.findElement(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/ancestor::*"));
//        System.out.println("Ancestor Node: "+ancestorNode.getText());
        //decendants
        /*List<WebElement> decendantElements = d.findElements(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/ancestor::tr/decendant::*"));
        System.out.println("Ancestor Node: " + decendantElements.size());*/
        //Following
        List <WebElement> followingElements =d.findElements(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/following::*"));
        System.out.println("followingElements: "+followingElements.size());
        //Folloing tr
        List <WebElement> followingElementsTr =d.findElements(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/ancestor::tr/following::tr"));
        System.out.println("followingElements: "+followingElementsTr.size());
        //folloing siblings
        List <WebElement> followingSiblingsTr =d.findElements(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/ancestor::tr/following-sibling::tr"));
        System.out.println("followingSiblings: "+followingSiblingsTr.size());
        //preceding siblings
        List <WebElement> precedingSiblingsTr =d.findElements(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/ancestor::tr/preceding-sibling::tr"));
        System.out.println("preceedingSiblings: "+precedingSiblingsTr.size());
        List <WebElement> precedingElements =d.findElements(By.xpath("//a[contains(text(),\'Maan Aluminium Ltd.\')]/self::a/preceding::*"));
        System.out.println("precedingElements: "+precedingElements.size());
    }

}
