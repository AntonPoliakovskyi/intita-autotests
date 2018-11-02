package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivationInfoPage extends BasePage{

    private static By infoBlock = By.cssSelector(".infoblock");

    public ActivationInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getActiovationInfo(){
        return findElement(infoBlock).getText();
    }
}
