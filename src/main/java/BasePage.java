import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private static final String languageSwitcher = "//*[@id=\"lang\"]/descendant::node()/a[text()[contains(.,'%s')]]";
    private static final By selectedLanguage = By.xpath("//div[@class='languageRow']/a[@class=\"selectedLang\"]");

    private static final String menuItem = "//tr[@class=\"main\"]/descendant::node()/a[text()[contains(.,'%s')]]";

    private static final By coursesBtn = By.xpath(String.format(menuItem, "Курси") + "|" + String.format(menuItem, "Courses") + "|" + String.format(menuItem, "Курсы"));

    private static final By loginBtn = By.id("enter_button");

    public enum Languages {
        UA("ua"),
        EN("en"),
        RU("ru");

        private String language;

        Languages(final String language) {
            this.language = language;
        }

        public String getLanguage() {
            return language;
        }
    }

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickCourses() {
        driver.findElement(coursesBtn).click();
    }

    public void getLoginPopUp() {
        driver.findElement(loginBtn).click();
        WebElement popUp = driver.findElement(loginBtn);

    }

    protected String getSelectedLanguage() {
        return driver.findElement(selectedLanguage).getText();
    }

    protected void chooseLanguage(Languages languages) {
        WebElement chosenLanguageSwitcher = driver.findElement(By.xpath(String.format(languageSwitcher, languages.getLanguage())));
        chosenLanguageSwitcher.click();
        waitForPageTobeLoaded();
    }

    protected void scroll(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    protected void waitForPageTobeLoaded() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
