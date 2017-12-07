package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Date;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class Stepdefs {

    private StepsBase stepsBase;
    private WebDriver driver;

    private final String ADD_TAG_LINK = "Lisää Tagi";

    @Autowired
    public Stepdefs(StepsBase stepBase) {
        this.stepsBase = stepBase;
        this.driver = stepBase.getDriver();
    }

    @Given("^user is at home page$")
    public void user_is_at_home_page() throws Throwable {
        stepsBase.goToBaseUrl();
    }

    @Then("^page with video information is presented$")
    public void page_with_video_information_is_presented() throws Throwable {
        assertTrue(driver.getPageSource().contains("Video"));
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

    
    @Then("^a new blog is listed with the name \"([^\"]*)\"$")
    public void a_new_blog_is_listed_with_the_name(String title) throws Throwable {
        assertTrue(driver.getPageSource().contains(title));
    }


    @Given("^the page of the new blog with the name \"([^\"]*)\" is entered$")
    public void the_page_of_the_new_blog_with_the_name_is_entered(String name) throws Throwable {
        stepsBase.goToBaseUrl();
    	stepsBase.clickLinkWithText(name);
    }
    
    private Date publishTime;

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

    @Then("^an error message \"([^\"]*)\" will be shown$")
    public void an_error_message_will_be_shown(String error) throws Throwable {
        assertTrue(driver.getPageSource().contains(error));
    }

    @Given("^the page of the new book with the name \"([^\"]*)\" is entered$")
    public void the_page_of_the_new_book_with_the_name_is_entered(String name) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(name);
    }
    
    //marking a book and blog as read start from here
    @When("^the mark as read button is clicked$")
    public void the_mark_as_read_button_is_clicked() throws Throwable {
        WebElement element = driver.findElement(By.name("isRead"));
        element.click();
        
    }

    @Then("^the button's text changes to \"([^\"]*)\"$")
    public void the_buttons_text_changes_to(String text) throws Throwable {
        WebElement element = driver.findElement(By.name("isRead"));
        assertTrue(element.getAttribute("value").equals(text));
    }

    @When("^the mark as unread button is clicked$")
    public void the_mark_as_unread_button_is_clicked() throws Throwable {
        WebElement element = driver.findElement(By.name("isRead"));
        element.click();
    }

    //filtering_by_read_status_5_below
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
        
    @Given("^a tag \"([^\"]*)\" is added$")
    public void a_tag_is_added(String name) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_TAG_LINK);
        addTagWithName(name);
    }

    @When("^the hints are filtered by the newest tag$")
    public void the_hints_are_filtered_by_the_newest_tag() throws Throwable {
        WebElement element = driver.findElement(By.className("tag-checkbox"));
        element.click();
        element = driver.findElement(By.id("filter"));
        element.click();
    }

    private void addTagWithName(String name) {
    	WebElement element = driver.findElement(By.name("name"));
    	element.sendKeys(name);
    	element = driver.findElement(By.name("submit"));
    	element.click();
    }

}