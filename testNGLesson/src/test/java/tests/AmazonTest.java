package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConFigReader;
import utilities.Driver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static utilities.Driver.quitDriver;

public class AmazonTest {

    public WebDriver driver;
    AmazonPage amazon=new AmazonPage();//buradan amazon page objesini oluşturup ögeleri buraya çağırmış oluyoruz




    @Test
    public void searchProduct() throws InterruptedException {

        driver=Driver.getDriver();

        driver.get(ConFigReader.getProperty("urlAmazon"));

        amazon.searchBox.sendKeys(ConFigReader.getProperty("textSearch"));//burada searchbox ile elementi amazonpage den çekmiş oluyoruz aratacağımız kelimeyide configuration dosyasından çekiyoruz

        amazon.searchButton.click();

        Thread.sleep(3000);
        //başlığı al
        String pageTitle=driver.getTitle();
        String expectTitle="Amazon.com : Samsung Note 21";

        assertEquals(expectTitle,pageTitle);//assert ile karşılaştırma yapılıyor

        if (pageTitle.equals(expectTitle)){
            System.out.println("Başlık Doğrulandı");
        }else {
            System.out.println("Başlık Hatalı");
        }


        //Css sınıfına sahip olan ürün başlıklarını bul ve bir liste olarak al
        List<WebElement>productTitles=driver.findElements(By.cssSelector("a-size-medium a-spacing-none a-color-base a-text-normal"));

        //bu listedeki başlıkları yazdır
        for (WebElement productTitle : productTitles){
            String title=productTitle.getText();
            System.out.println(title);
        }

        int actualTitlCount= productTitles.size();
        System.out.println("Başlık Sayısı : "+actualTitlCount);

        int expectedTitleCount=0;
        assertEquals(actualTitlCount,expectedTitleCount,"Başlık doğrulaması başarısız. Beklenen:" + expectedTitleCount +", Gerçek: "+ actualTitlCount );
        //



        JavascriptExecutor js=(JavascriptExecutor) driver;
        // bu kod parçacığı Webdriver aracılığla js kodlarını çalıştırmamızı sağlayan js executor arabirimi

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//web sayfasının en altına otomatik kaydırıyor
        // window scroollTo işlevini kullanıyor bu kod sayfayı istenilen eksende kaydırmak için kullanılır


        quitDriver();




    }
}
