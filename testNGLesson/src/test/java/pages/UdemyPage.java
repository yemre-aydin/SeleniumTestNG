package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UdemyPage {

    public UdemyPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy (name="q")
    public WebElement searchBox;//searchbox elementinin bulunması

}
