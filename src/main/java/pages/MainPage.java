package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private static final By sliderStartBtn = By.id("sliderButton");
    private static final By extendedRegestrationtuggle2 = By.xpath("//*[@class=\"regCheckbox\"]");




    private MainPage clickOnSliderBtn(){
        driver.findElement(sliderStartBtn).click();
        return this;
    }

    public RegistrationPage startExtendedRegistration() throws InterruptedException {
        WebElement extendedRegestrationtuggleElement2 = driver.findElement(extendedRegestrationtuggle2);
        scroll(extendedRegestrationtuggleElement2);
        extendedRegestrationtuggleElement2.click();
        return new RegistrationPage();
    }

}
