package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConFigReader;
import utilities.Driver;

public class AmazonPage {

    public  AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);

        Driver.getDriver().get(ConFigReader.getProperty("urlAmazon"));

    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchButton;

}
