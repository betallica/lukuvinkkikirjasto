package ohtu;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class StepsComments {

    private StepsBase stepsBase;
    private WebDriver driver;
    private Date publishTime;

    @Autowired
    public StepsComments(StepsBase stepsBase) {
        this.stepsBase = stepsBase;
        this.driver = stepsBase.getDriver();
    }

    @When("^a comment with text \"([^\"]*)\" is added$")
    public void a_comment_with_text_is_added(String text) throws Throwable {
        WebElement element = driver.findElement(By.name("text"));
        element.sendKeys(text);
        element = driver.findElement(By.name("addComment"));
        element.click();

        publishTime = new Date();
    }

    @Then("^the new comment with text \"([^\"]*)\" is shown$")
    public void the_new_comment_with_text_is_shown_with_the_right_publish_time(String text) throws Throwable {
        assertTrue(driver.getPageSource().contains(text));
    }

    @When("^an empty comment is added$")
    public void an_empty_comment_is_added() throws Throwable {
        WebElement element = driver.findElement(By.name("addComment"));
        element.click();
    }

}
