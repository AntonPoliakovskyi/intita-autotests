import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivationInfoPage extends BasePage{

    private static By infoBlock = By.cssSelector(".infoblock");
    public ActivationInfoPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getActiovationInfo(){
        return driver.findElement(infoBlock).getText();
    }
}
