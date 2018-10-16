import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private static final By sliderStartBtn = By.id("sliderButton");
    private static final By extendedRegestrationtuggle2 = By.xpath("//*[@class=\"regCheckbox\"]");


    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private MainPage clickOnSliderBtn(){
        driver.findElement(sliderStartBtn).click();
        return this;
    }

    public RegistrationPage startExtendedRegistration() throws InterruptedException {
        WebElement extendedRegestrationtuggleElement2 = driver.findElement(extendedRegestrationtuggle2);
        scroll(extendedRegestrationtuggleElement2);
        extendedRegestrationtuggleElement2.click();
        return new RegistrationPage(driver, wait);
    }

}
