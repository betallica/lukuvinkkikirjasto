package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Stepdefs {

    WebDriver driver;

    public Stepdefs() {
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else {
            file = new File("lib/geckodriver");
        }
        final String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);

        this.driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^user is at the main page$")
    public void user_is_at_the_main_page() throws Throwable {
        driver.get("http://localhost:" + 8080 + "/" );
        Thread.sleep(1000);        
    }

    @When("^a link is clicked$")
    public void a_link_is_clicked() throws Throwable {
        Thread.sleep(1000);  
        clickLinkWithText("linkki" );
        Thread.sleep(1000);  
    }    
   
    @Then("^\"([^\"]*)\" is shown$")
    public void is_shown(String arg1) throws Throwable {
        assertTrue(driver.findElement(By.tagName("body"))
                .getText().contains(arg1));
    }
    
    @Given("^command add book is selected$")
    public void command_add_book_is_selected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^valid name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_valid_author_and_valid_isbn_are_entered(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user is redirected to front page$")
    public void user_is_redirected_to_front_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the new book is listed$")
    public void the_new_book_is_listed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^empty name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void empty_name_and_valid_author_and_valid_isbn_are_entered(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^error message \"([^\"]*)\" is shown$")
    public void error_message_is_shown(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^valid name \"([^\"]*)\" and empty author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_author_and_valid_isbn_are_entered(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^valid name \"([^\"]*)\" and empty author \"([^\"]*)\" and invalid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_author_and_invalid_isbn_are_entered(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    private void clickLinkWithText(String text) {
        int trials = 0;
        while( trials++<5 ) {
            try{
                final WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;           
            } catch(Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
    
}
