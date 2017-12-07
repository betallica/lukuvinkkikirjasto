package ohtu;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class StepsBase {

    private class SilentHtmlUnitDriver extends HtmlUnitDriver {
        SilentHtmlUnitDriver() {
            super();
            this.getWebClient().setCssErrorHandler(new SilentCssErrorHandler());
        }
    }

    private WebDriver driver;
    public final String BASE_URL = "http://localhost:8080";

    public StepsBase() {
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
                file = new File("lib/macgeckodriver");
            } else {
                file = new File("lib/geckodriver");
            }
        final String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);
        driver = new SilentHtmlUnitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void goToBaseUrl() {
        getDriver().get(BASE_URL);
    }

    public void clickLinkWithText(String text) {
        int trials = 0;
        while( trials++<5 ) {
            try{
                final WebElement element = getDriver().findElement(By.linkText(text));
                element.click();
                break;
            } catch(Exception e) {
                e.getStackTrace();
            }
        }
    }
}


