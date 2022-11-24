import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestWebElementsDemo {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testCheckBox(){
        d.get("https://opensource-demo.orangehrmlive.com/");
        d.manage().window().maximize();
        d.findElement(By.id("txtUsername")).sendKeys("Admin");
        d.findElement(By.id("txtPassword")).sendKeys("admin123");
        d.findElement(By.id("btnLogin")).click();
        d.findElement(By.xpath("//b[contains(text(),'Leave')]")).click();
        WebElement element=d.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']"));
        if(element.isDisplayed()&& element.isEnabled()&& !element.isSelected()){
            element.click();
        }
    }
    @Test
    public void testRadioButton(){
        d.get("file:///C:/Users/anuoc/Desktop/My%20Docs/CheckBoxRadioButton.html");
        WebElement testRadioButton=d.findElement(By.xpath("//input[@type='radio' and @value='Java']"));
        if(!testRadioButton.isEnabled()){
            System.out.println("Testing radio button not enabled");
        }
        WebElement perlCheckbox=d.findElement(By.xpath("//input[@type='checkbox' and @value='Perl']"));
        String status=perlCheckbox.isEnabled()?"Enabled":"Disabled";
        System.out.println("Perl Checkbox is "+status);
        Assert.assertFalse(perlCheckbox.isEnabled());
    }
    @Test
    public void testDropDown(){
        d.get("https://opensource-demo.orangehrmlive.com/");
        d.manage().window().maximize();
        d.findElement(By.id("txtUsername")).sendKeys("Admin");
        d.findElement(By.id("txtPassword")).sendKeys("admin123");
        d.findElement(By.id("btnLogin")).click();
        d.findElement(By.xpath("//b[contains(text(),'Leave')]")).click();
       WebElement subElement= d.findElement(By.id("leaveList_cmbSubunit"));
       Select s=new Select(subElement);
      // s.selectByVisibleText("Finance");
      // s.selectByValue("6");
      // s.selectByIndex(2);
        System.out.println(s.isMultiple());
        List<WebElement> we=s.getOptions();
        for(WebElement e:we){
            if(e.getText().equals("Finance")){
                e.click();
                break;

            }
        }
}
@Test
    public void testDropDownJobServe(){
        d.get("https://www.jobserve.com/gb/en/Job-Search/");
        d.findElement(By.xpath("//input[@id='txtKey']")).sendKeys("Selenium, Automation");
        d.findElement(By.xpath("//input[@id='txtLoc']")).clear();
    d.findElement(By.xpath("//input[@id='txtLoc']")).sendKeys("Remote");
        WebElement distance=d.findElement(By.id("selRad"));
        Select distanceSelection=new Select(distance);
        distanceSelection.selectByVisibleText("Within 15 miles");
        Select adAge=new Select(d.findElement(By.id("selAge")));
        adAge.selectByIndex(5);
        Select jobType=new Select(d.findElement(By.id("selJType")));
        jobType.selectByValue("2");
        d.findElement(By.id("btnSearch")).click();
       String element=d.findElement(By.xpath("//body/form[@id='frm1']/div[@id='pg']/div[1]/div[6]/div[5]/h4[1]")).getText();
       Assert.assertTrue(element.contains("jobs for Selenium"));
}
@Test
    public void testDropDownJobSErve2(){
        d.get("https://www.jobserve.com/gb/en/Job-Search/");
    d.findElement(By.xpath("//input[@id='txtKey']")).sendKeys("Selenium, Automation");
    d.findElement(By.xpath("//input[@id='txtLoc']")).clear();
    d.findElement(By.xpath("//input[@id='txtLoc']")).sendKeys("Remote");
    WebElement distance=d.findElement(By.id("selRad"));
    selectOptionForDropDown(distance,"Within 15 miles");
    WebElement adAge=d.findElement(By.id("selAge"));
    selectOptionForDropDown(adAge,"Within 3 days");
    WebElement jobType=d.findElement(By.id("selJType"));
    selectOptionForDropDown(jobType,"Contract/Permanant");
    d.findElement(By.id("btnSearch")).click();
    String element=d.findElement(By.xpath("//body/form[@id='frm1']/div[@id='pg']/div[1]/div[6]/div[5]/h4[1]")).getText();
    Assert.assertTrue(element.contains("jobs for Selenium"));
}

    private void selectOptionForDropDown(WebElement webElement, String valueToSearch) {
        Select select=new Select(webElement);
        List<WebElement> options=select.getOptions();
        for(WebElement element:options)
            if(element.getText().contains(valueToSearch)){
                element.click();
                break;
            }
    }
    @Test
    public void testRadioButtonUsingEvaluate(){
        d.get("file:///C:/Users/anuoc/Desktop/My%20Docs/CheckBoxRadioButton.html");
        JavascriptExecutor js=(JavascriptExecutor)d;
        WebElement testRadioButton=d.findElement(By.xpath("//input[@type='radio' and @value='Testing']"));
        //js.executeScript("arguments[0].click()",testRadioButton);


    }


}
