package core;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    private static WebDriverWait wait;

    private static int timeOut;

    public static WebDriverWait getWait(int timeOut) {
        if(wait == null) {
            wait = new WebDriverWait(Driver.get(), timeOut);
        }
        return wait;
    }

    public static WebDriverWait getWait(){
        return getWait(5);
    }
}
