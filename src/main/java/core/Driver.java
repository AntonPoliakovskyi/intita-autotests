package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Driver{

    private static WebDriver driver;

    public static WebDriver get(){
        if(driver == null) {
            init();
        }
        return driver;
    }

    private static Properties getProperties(){
        Properties prop = new Properties();
        InputStream input = null;
        try{
            input = new FileInputStream("configuration.properties");
            prop.load(input);
        } catch (java.lang.Exception e){
            e.printStackTrace();
        }
        return prop;
    }


    private static void init(){
        String browserName = getProperties().getProperty("browser");

        switch (browserName){
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
    }
}
