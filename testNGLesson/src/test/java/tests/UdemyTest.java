package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.UdemyPage;
import utilities.ConFigReader;
import utilities.Driver;

public class UdemyTest {

    UdemyPage udemy=new UdemyPage();//udemypage de tanımlarnmış ögeleri getiriyoruz



    @Test
    public void testUdemy() {
        // Udemy anasayfasını aç

        Driver.getDriver().get(ConFigReader.getProperty("urlUdemy"));//configurationdan istenilne url i çağırıyoruz

        //kurs arama textbox a "Appium Mobil Testing" yaz
        udemy.searchBox.sendKeys(ConFigReader.getProperty("searchtext1"), Keys.ENTER);

    }
}
