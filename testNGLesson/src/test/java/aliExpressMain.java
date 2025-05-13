import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class aliExpressMain {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aliexpress.com");
    }

    @Test
    public void testProductSearches() throws InterruptedException {

        Thread.sleep(2000);
        //sayfanın altında açılan pencereyi bulma
        String mainWindowHandle=driver.getWindowHandle();
        for (String windowHandle :driver.getWindowHandles()){
            if (!windowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //üst kısma tıklama
        WebElement btnCookie=driver.findElement(By.className("btn-accept"));
        btnCookie.click();
        //ana pencereye geri dönme

        driver.switchTo().window(mainWindowHandle);

        //Ürün Arama

        String searchKeyword="phone";
        WebElement searchBox= driver.findElement(By.id("search-words"));
        searchBox.sendKeys(searchKeyword,Keys.ENTER);







    }
}
