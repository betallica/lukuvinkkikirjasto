package ohtu;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class StepsTags {

    private StepsBase stepsBase;
    private WebDriver driver;
    private final String ADD_TAG_LINK = "Lisää Tagi";

    @Autowired
    public StepsTags(StepsBase stepsBase) {
        this.stepsBase = stepsBase;
        this.driver = stepsBase.getDriver();
    }

    @Given("^a tag \"([^\"]*)\" is added$")
    public void a_tag_is_added(String name) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_TAG_LINK);
        addTagWithName(name);
    }

    private void addTagWithName(String name) {
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(name);
        element = driver.findElement(By.name("submit"));
        element.click();
    }

}
