package core;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    private static WebDriverWait wait;
    private static int timeOut = Integer.parseInt(IntitaProperties.getProperties().getProperty("webdriver.timeouts.implicit.wait"));

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(Driver.getDriver(), timeOut);
        }
        return wait;
    }
}
