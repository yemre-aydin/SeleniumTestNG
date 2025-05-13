package tests;

import org.testng.annotations.Test;
import pages.RaporluTeknosaPage;
import utilities.ConFigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class RaporluTeknosaTest extends TestBaseRapor {

    RaporluTeknosaPage teknosa=new RaporluTeknosaPage();//web elementlerimizi alacağız

    @Test
    public void test1(){
        extentTest=extentReports.createTest("Teknosa arama testi");
        //extentreports kütüphanesinde bir testi oluşturmak için kullanılır.
        //bu yöntem, bir testin adını ve açıklamasını belirlemenizi sağlar
        Driver.getDriver().get(ConFigReader.getProperty("urlTeknosa"));
        extentTest.info("Kullanıcı Teknosa anasayfasına gider");

         teknosa.search.sendKeys("Monster");
        //raporlamada çıkması iin her adımda extenttest.info yazılmalıdır
        extentTest.info("Arama kutusuna belirlenen kelime yazılır ve aratırlır");


    }
}
