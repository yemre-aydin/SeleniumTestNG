import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class MultipleTests  {



    //prooritiy ile testleri önceliklendirebiliriz. bunu yapmazsak testler alfabetik sırayla test edilir
    @Test(priority = 4)
     public void openYoutube(){


        Driver.getDriver().get("https://www.youtube.com/");
        System.out.println("youtube");
        assertTrue(true);//sayfa gerçekten açıldı kontrolü

    }

    @Test(priority = 2/*buraya enable = false koyarsan bu testi atlayacaktır*/)
    public void openAmazon(){
        Driver.getDriver().get("https://www.amazon.com/");
        System.out.println("amazon");
        assertTrue(true);


    }

    @Test(priority = 3)
    public void openAliexpress(){
        Driver.getDriver().get("https://www.aliexpress.com/");
        System.out.println("aliexpress");
        assertTrue(true);
    }
    @Test(priority = 1,dependsOnMethods = "openYoutube") //depend yazarak priority 1 de olsa önce youtube çalıştırmış oluruz. bu teste youtube u bağlamış oluyoruz
    //depensonmethod ile 1 de olmasına rağmen şartı olduğu için altladı ve şartın gerçekleşmesini bekledi
    public void openFacebook(){
        Driver.getDriver().get("https://www.facebook.com/");
        System.out.println("facebook");
        assertTrue(true);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();


    }
}
