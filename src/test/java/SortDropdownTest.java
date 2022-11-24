import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDropdownTest {
    private WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testSortingDropDown(){
        d.get("file:///C:/Users/anuoc/Desktop/My%20Docs/dropdown.html");
        WebElement we=d.findElement(By.id("cars"));
        Select s=new Select(we);
        List<WebElement> options=s.getOptions();
        List<String> toBeSortedCarList=new ArrayList<>();
        List<String> originalCarList=new ArrayList<>();
        for(WebElement e:options){
            toBeSortedCarList.add(e.getText());
            originalCarList.add(e.getText());
        }
        System.out.println("Unsorted CarList: "+originalCarList);
//        Collections.sort(toBeSortedCarList, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.compareToIgnoreCase(s2);
//            }
//        });
        Collections.sort(toBeSortedCarList);
        System.out.println("Sorted CarList: "+toBeSortedCarList);
        System.out.println(toBeSortedCarList.equals(originalCarList));
        Assert.assertEquals(toBeSortedCarList,originalCarList);
        Assert.assertTrue(toBeSortedCarList.equals(originalCarList));
    }
}
