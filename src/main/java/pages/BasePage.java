package pages;

import core.WebDriverAdaptor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.courses.CoursesPage;

import static common.MenuItems.COURSES;

public abstract class BasePage extends WebDriverAdaptor {

    private static final String languageSwitcher = "//*[@id=\"lang\"]/descendant::node()/a[text()[contains(.,'%s')]]";
    private static final By selectedLanguage = By.xpath("//div[@class='languageRow']/a[@class=\"selectedLang\"]");
    private static final String menuItem = "//tr[@class=\"main\"]/descendant::a[contains(@href,'%s')]";
    private static final By coursesBtn = By.xpath(String.format(menuItem, COURSES.getItem()));
    private static final By loginBtn = By.id("enter_button");

    protected WebDriverWait wait;


    public BasePage(final WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 5);
    }

    public CoursesPage navigateToCoursesPage() {
        findElement(coursesBtn).click();
        return new CoursesPage(driver);
    }

    public void getLoginPopUp() {
        WebElement popUp = findElement(loginBtn);
        popUp.click();
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
