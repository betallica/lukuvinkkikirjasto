package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class StepsVideos {

    private StepsBase stepsBase;
    private WebDriver driver;
    private final String ADD_VIDEO_LINK = "Video";

    @Autowired
    public StepsVideos(StepsBase stepsBase) {
        this.stepsBase = stepsBase;
        driver = this.stepsBase.getDriver();
    }

    @Given("^command add video is selected$")
    public void command_add_video_is_selected() throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_VIDEO_LINK);
    }

    @Given("^the page of the new video with the name \"([^\"]*)\" is entered$")
    public void the_page_of_the_new_video_with_the_name_is_entered(String name) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(name);
    }

    @Given("^ten videos are created with same name \"([^\"]*)\" same author \"([^\"]*)\" and same url \"([^\"]*)\"$")
    public void ten_videos_are_created_with_same_name_same_author_and_same_url(String name, String author, String url) throws Throwable {
        for (int i = 0; i < 10; i++) {
            a_video_with_a_name_and_author_and_url_is_added(name, author, url);
        }
    }

    @Given("^video with valid name \"([^\"]*)\" and valid vidauthor \"([^\"]*)\" and valid url \"([^\"]*)\" is entered")
    public void video_with_valid_name_and_valid_vidauthor_and_valid_url_is_entered(String name, String author, String url) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_VIDEO_LINK);
        addVideoWith(name, author, url);
    }
    
    @Given("^command edit video is selected$")
    public void command_edit_video_is_selected() throws Throwable {
        stepsBase.clickLinkWithId("edit");
    }
    
    @Then("^user is redirected to videos \"([^\"]*)\" page$") 
    public void user_is_redirected_to_named_videos_page(String name) throws Throwable {
        assertTrue(driver.getPageSource().contains(name));
    }

    @When("^video name is clicked$")
    public void video_name_is_clicked() throws Throwable {
        stepsBase.clickLinkWithText("What is Agile?");
    }

    @When("^valid name \"([^\"]*)\" and valid vidauthor \"([^\"]*)\" and valid url \"([^\"]*)\" are entered$")
    public void valid_name_and_valid_vidauthor_and_valid_url_are_entered(String name, String author, String url) throws Throwable {
        addVideoWith(name, author, url);
    }

    @When("^empty name \"([^\"]*)\" and valid vidauthor \"([^\"]*)\" and valid url \"([^\"]*)\" are entered$")
    public void empty_name_and_valid_vidauthor_and_valid_url_are_entered(String name, String author, String url) throws Throwable {
        addVideoWith(name, author, url);
    }

    @When("^valid name \"([^\"]*)\" and empty vidauthor \"([^\"]*)\" and valid url \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_vidauthor_and_valid_url_are_entered(String name, String author, String url) throws Throwable {
        addVideoWith(name, author, url);
    }

    @When("^valid name \"([^\"]*)\" and valid vidauthor \"([^\"]*)\" and empty url \"([^\"]*)\" are entered$")
    public void valid_name_and_valid_vidauthor_and_empty_url_are_entered(String name, String author, String url) throws Throwable {
        addVideoWith(name, author, url);
    }

    @Given("^a video with a name \"([^\"]*)\" and author \"([^\"]*)\" and url \"([^\"]*)\" is added$")
    public void a_video_with_a_name_and_author_and_url_is_added(String name, String author, String url) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_VIDEO_LINK);
        addVideoWith(name, author, url);
    }

    @Then("^a new video is listed with the name \"([^\"]*)\"$")
    public void a_new_video_is_listed_with_the_name(String title) throws Throwable {
        assertTrue(driver.getPageSource().contains(title));
    }

    @Then("^page with video information is presented$")
    public void page_with_video_information_is_presented() throws Throwable {
        assertTrue(driver.getPageSource().contains("Video"));
    }

    private void addVideoWith(String name, String author, String url) {
        WebElement element = driver.findElement(By.name("name"));
        element.clear();
        element.sendKeys(name);
        element = driver.findElement(By.name("author"));
        element.clear();
        element.sendKeys(author);
        element = driver.findElement(By.name("url"));
        element.clear();
        element.sendKeys(url);
        element = driver.findElement(By.name("submit"));
        element.click();
    }

}