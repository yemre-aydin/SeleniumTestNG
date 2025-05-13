package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseRapor {

    protected static ExtentReports extentReports;//extent report örneğine referand tutar
    protected static ExtentTest extentTest;//testin başarısını veya başarısızlığını tutar. ekran görüntüsü yakalamak için kullanılır

    //protected static ExtentHtmlReporter extentHtmlReporter;//html raporu oluşturur

    //tüm test metotlarından önce çalıştır
    @BeforeTest(alwaysRun = true)
    public void setUpTest(){
        extentReports=new ExtentReports();//extent report u başlatır

        //Html için extent yolunu belirleme
        String date =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath=System.getProperty("user.dir")+"/test-output/Rapor"+date+".html";
        /*
        extentHtmlReporter=new ExtentHtmlReperter(filePath);//html reprter dosya yolunu başlatır

        //rapor için ek sistem bilgilerini belirle
        extentReports.setSystemInfo("Environnement","QA");
        extentReports.setSystemInfo("Navigator", ConFigReader.getProperty("browser"));//örn chrome
        extentReports.setSystemInfo("Muhendis","Yunus Emre");
        extentHtmlReporter.config().setDocumentTitle("e2e Testing");//raporoun belg ebaşlığını belirle
        extentHtmlReporter.config().setReportName("TestNG Reports");//rapor adını belirle
        */

    }

    //Her bir test metodunda başarısızlık durumunda ekran görüntüsü alınır ve sürücüye kapatır
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus()==ITestResult.FAILURE){
            //test başarısız ise ekran görüntüsü yakala ve rapora ekle
            String screenshotLocation=ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());//test başarısız olarak kaydet
            extentTest.addScreenCaptureFromPath(screenshotLocation);//ekran görüntüsünü rapora ekle
            extentTest.fail(result.getThrowable());//hata ayrıntılarını kaydet
        } else if (result.getStatus() == ITestResult.SKIP) {
            //atlanan testler için
            extentTest.skip("Test durumu atlama:"+result.getName());
        }
        Driver.closeDriver();//her test metodundan sonra sürücüyü kapat
    }
    //Raporlamayı kaydetmek için raporu kaydedip sonlandır
    @AfterTest(alwaysRun = true)
    public void tearDownTest(){
        extentReports.flush();
    }
}
