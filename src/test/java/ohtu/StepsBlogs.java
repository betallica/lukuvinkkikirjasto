package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class StepsBlogs {

    private StepsBase stepsBase;
    private WebDriver driver;
    private final String ADD_BLOG_LINK = "Blogi";

    @Autowired
    public StepsBlogs(StepsBase stepsBase) {
        this.stepsBase = stepsBase;
        this.driver = stepsBase.getDriver();
    }

    @Given("^command add blog is selected$")
    public void command_add_blog_is_selected() throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_BLOG_LINK);
    }

    @Given("^blog with valid name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid url \"([^\"]*)\" is entered")
    public void a_blog_has_been_entered(String name, String author, String url) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_BLOG_LINK);
        addBlogWith(name, author, url);
    }

    @When("^valid name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid url \"([^\"]*)\" are entered$")
    public void valid_name_and_valid_author_and_valid_url_are_entered(String name, String author, String url) throws Throwable {
        addBlogWith(name, author, url);
    }

    @When("^empty name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid url \"([^\"]*)\" are entered$")
    public void empty_name_and_valid_author_and_valid_url_are_entered(String name, String author, String url) throws Throwable {
        addBlogWith(name, author, url);
    }

    @When("^valid name \"([^\"]*)\" and empty author \"([^\"]*)\" and valid url \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_author_and_valid_url_are_entered(String name, String author, String url) throws Throwable {
        addBlogWith(name, author, url);
    }

    @When("^valid name \"([^\"]*)\" and valid author \"([^\"]*)\" and empty url \"([^\"]*)\" are entered$")
    public void valid_name_and_valid_author_and_empty_url_are_entered(String name, String author, String url) throws Throwable {
        addBlogWith(name, author, url);
    }

    @Given("^ten blogs are created with same name \"([^\"]*)\" same author \"([^\"]*)\" and same url \"([^\"]*)\"$")
    public void ten_blogs_are_created_with_same_name_same_author_and_same_url(String name, String author, String url) throws Throwable {
        for(int i = 0; i < 10; i++) {
            stepsBase.goToBaseUrl();
            stepsBase.clickLinkWithText(ADD_BLOG_LINK);
            addBlogWith(name, author, url);
        }
    }

    @Given("^a blog with a name \"([^\"]*)\" and author \"([^\"]*)\" and url \"([^\"]*)\" is added$")
    public void a_blog_with_a_name_and_author_and_url_is_added(String name, String author, String url) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(ADD_BLOG_LINK);
        addBlogWith(name, author, url);
    }
    
    @Given("^user is at the blogs \"([^\"]*)\" info page$")
    public void user_is_at_the_named_blogs_info_page(String name) throws Throwable {
        stepsBase.goToBaseUrl();
        stepsBase.clickLinkWithText(name);
    }
    
    @Given("^command edit blog is selected$")
    public void command_edit_blog_is_selected() throws Throwable {
        stepsBase.clickLinkWithId("edit");
    }
    
    @Then("^user is redirected to blogs \"([^\"]*)\" page$") 
    public void user_is_redirected_to_named_blogs_page(String name) throws Throwable {
        assertTrue(driver.getPageSource().contains(name));
    }

    @Then("^page with blog information is presented$")
    public void page_with_blog_information_is_presented() throws Throwable {
        assertTrue(driver.getPageSource().contains("Blogi"));
    }

    @When("^blog name is clicked$")
    public void blog_name_is_clicked() throws Throwable {
        stepsBase.clickLinkWithText("A Simple Way to Run a Sprint Retrospective");
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

    private void addBlogWith(String name, String author, String url) {
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
