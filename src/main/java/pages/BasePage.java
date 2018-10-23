package pages;

import core.Driver;
import core.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.courses.CoursesPage;

import java.util.List;
import java.util.Set;

public abstract class BasePage implements WebDriver {

    private static final String languageSwitcher = "//*[@id=\"lang\"]/descendant::node()/a[text()[contains(.,'%s')]]";

    private static final By selectedLanguage = By.xpath("//div[@class='languageRow']/a[@class=\"selectedLang\"]");

    private static final String menuItem = "//tr[@class=\"main\"]/descendant::node()/a[text()[contains(.,'%s')]]";

    private static final By coursesBtn = By.xpath(String.format(menuItem, "Курси") + "|" + String.format(menuItem, "Courses") + "|" + String.format(menuItem, "Курсы"));

    private static final By loginBtn = By.id("enter_button");
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage() {
        driver = Driver.get();
        wait = Wait.getWait();
    }

    public CoursesPage navigateToCoursesPage() {
        findElement(coursesBtn).click();
        return new CoursesPage();
    }

    public void getLoginPopUp() {
        findElement(loginBtn).click();
        WebElement popUp = findElement(loginBtn);

    }

    protected String getSelectedLanguage() {
        return findElement(selectedLanguage).getText();
    }

    protected void chooseLanguage(Languages languages) {
        WebElement chosenLanguageSwitcher = findElement(By.xpath(String.format(languageSwitcher, languages.getLanguage())));
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

    @Override
    public void get(String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

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


}
