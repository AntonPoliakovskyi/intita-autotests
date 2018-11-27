package pages;

import core.IntitaProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {


    private static final By sliderStartBtn = By.id("sliderButton");
    private static final By extendedRegistrationTuggle = By.xpath("//*[@class=\"regCheckbox\"]");
    private static final String BASE_URL = IntitaProperties.getProperties().getProperty("base.url");

    public MainPage(WebDriver driver) {
        super(driver);
        waitForPageTobeLoaded();
    }

    public MainPage openMainPage() {
        get(BASE_URL);
        return this;
    }

    private MainPage clickOnSliderBtn() {
        findElement(sliderStartBtn).click();
        return this;
    }

    public RegistrationPage startExtendedRegistration() throws InterruptedException {
        WebElement extendedRegistrationTuggleElement = findElement(extendedRegistrationTuggle);
        scroll(extendedRegistrationTuggleElement);
        extendedRegistrationTuggleElement.click();
        return new RegistrationPage(driver);
    }

}
