package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {


    private static final By sliderStartBtn = By.id("sliderButton");
    private static final By extendedRegestrationtuggle2 = By.xpath("//*[@class=\"regCheckbox\"]");


    public MainPage(WebDriver driver) {
        super(driver);
        waitForPageTobeLoaded();
    }

    public MainPage openMainPage(){
        get("https://intita.itatests.com");
        return this;
    }

    private MainPage clickOnSliderBtn(){
        findElement(sliderStartBtn).click();
        return this;
    }

    public RegistrationPage startExtendedRegistration() throws InterruptedException {
        WebElement extendedRegestrationtuggleElement2 = findElement(extendedRegestrationtuggle2);
        scroll(extendedRegestrationtuggleElement2);
        extendedRegestrationtuggleElement2.click();
        return new RegistrationPage(driver);
    }

}
