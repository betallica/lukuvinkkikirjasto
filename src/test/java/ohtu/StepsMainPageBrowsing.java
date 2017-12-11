package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class StepsMainPageBrowsing {

    private StepsBase stepsBase;
    private WebDriver driver;

    @Autowired
    public StepsMainPageBrowsing(StepsBase stepBase) {
        this.stepsBase = stepBase;
        this.driver = stepBase.getDriver();
    }

    @Given("^user is at home page$")
    public void user_is_at_home_page() throws Throwable {
        stepsBase.goToBaseUrl();
    }

    @Then("^user is redirected to front page$")
    public void user_is_redirected_to_front_page() throws Throwable {
        assertTrue(driver.getPageSource().contains("Vinkit"));
    }

    @Then("^error message \"([^\"]*)\" is shown$")
    public void error_message_is_shown(String error_message) throws Throwable {
        assertTrue(driver.getPageSource().contains(error_message));
    }

    @When("^at the home page$")
    public void at_the_home_page() throws Throwable {
        stepsBase.goToBaseUrl();
    }

    @When("^next page is selected$")
    public void next_page_is_selected() throws Throwable {
        stepsBase.clickLinkWithText("Seuraava »");
    }

    @Then("^an error message \"([^\"]*)\" will be shown$")
    public void an_error_message_will_be_shown(String error) throws Throwable {
        assertTrue(driver.getPageSource().contains(error));
    }

    @When("^hints are filtered by being unread$")
    public void hints_are_filtered_by_being_unread() throws Throwable {
        stepsBase.goToBaseUrl();
        WebElement element = driver.findElement(By.id("filter_unread"));
        element.click();
        element = driver.findElement(By.id("filter"));
        element.click();
    }

    @When("^hints are filtered by being read$")
    public void hints_are_filtered_by_being_read() throws Throwable {
        stepsBase.goToBaseUrl();
        WebElement element = driver.findElement(By.id("filter_read"));
        element.click();
        element = driver.findElement(By.id("filter"));
        element.click();
    }

    @When("^hints are filtered by all$")
    public void hints_are_filtered_by_all() throws Throwable {
        stepsBase.goToBaseUrl();
        WebElement element = driver.findElement(By.id("filter_all"));
        element.click();
        element = driver.findElement(By.id("filter"));
        element.click();
    }

    @When("^the hints are filtered by the newest tag$")
    public void the_hints_are_filtered_by_the_newest_tag() throws Throwable {
        WebElement element = driver.findElement(By.className("tag-checkbox"));
        element.click();
        element = driver.findElement(By.id("filter"));
        element.click();
    }
    @Then("^notification \"([^\"]*)\" is shown$")
    public void notification_is_shown(String notification_text) throws Throwable {
        assertTrue(driver.getPageSource().contains(notification_text));
    }
}