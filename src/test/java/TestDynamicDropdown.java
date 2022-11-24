import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestDynamicDropdown extends BaseSetUp1{
private WebDriver d;
private Properties objectRepo;
@SneakyThrows
@Before
    public void init(){
    WebDriverManager.chromedriver().setup();
    super.init();
    d=getWebDriver();
    objectRepo=getObjRepo();
}
@Test
    @SneakyThrows
    public void dynamicDropdownTest(){
    d.get("https://www.skyscanner.net/?previousCultureSource=COOKIE&redirectedFrom=www.skyscanner.com");
    d.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
    d.findElement(By.xpath("//button[@id='acceptCookieButton']")).click();
    d.manage().window().maximize();
    populateSourceCity();
}
@SneakyThrows
    private void populateSourceCity() {
        WebElement element=d.findElement(By.xpath("//input[@id='fsc-origin-search']"));
         element.sendKeys(Keys.SPACE, Keys.BACK_SPACE);

        element.sendKeys("Lon");
        List<WebElement> searchResults=d.findElements(By.xpath("//ul[@class='BpkAutosuggest_bpk-autosuggest__suggestions-list__OTg2N LocationSelector_fsc-suggestions-list__NDI5N']"));
        for (WebElement e:searchResults){
            System.out.println(e.getText());
        }
    }}

