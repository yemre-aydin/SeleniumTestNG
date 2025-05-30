package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    private  Driver(){

        // private constructor - Driver sınıfının  dışında nesne  oluşturulmasını engeller

    }
    //bu sınıf, selenium webdriver'ı yönetmek  ve tarayıcıları yapılandırmak için kullanılır

    public static WebDriver getDriver(){// yönetilen Webdriver nesnesini döndüren bir metot tanımlanır.

        String Browser=ConFigReader.getProperty("browser"   );

        if (driver==null){
            switch (Browser){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//bulunamayan bir element için 15 sn bekler
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.close();//webdriver i kapatır ve sıfırlar
            driver=null;
        }


    }
    public static void  quitDriver(){
        driver.quit();//webdriver i kapatır ve sıfırlar
        driver=null;

    }
}
