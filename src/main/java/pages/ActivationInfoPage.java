package pages;

import org.openqa.selenium.By;

public class ActivationInfoPage extends BasePage{

    private static By infoBlock = By.cssSelector(".infoblock");
    public String getActiovationInfo(){
        return findElement(infoBlock).getText();
    }
}
