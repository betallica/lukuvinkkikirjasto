package ohtu;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

    WebDriver driver;
    
    private final String BASE_URL = "http://localhost:8080";

    public Stepdefs() {
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else {
            file = new File("lib/geckodriver");
        }
        final String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);

        driver = new HtmlUnitDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Given("^command add book is selected$")
    public void command_add_book_is_selected() throws Throwable {
        driver.get(BASE_URL);
        clickLinkWithText("Lisää kirja");
    }

    @When("^valid name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_valid_author_and_valid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }

    @Then("^user is redirected to front page$")
    public void user_is_redirected_to_front_page() throws Throwable {
        assertTrue(driver.getPageSource().contains("Kirjat"));
    }
    
    @Then("^a new book is listed with the isbn \"([^\"]*)\"$")
    public void a_new_book_is_listed_with_the_isbn(String isbn) throws Throwable {
        assertTrue(driver.getPageSource().contains(isbn));
    }

    @When("^empty name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void empty_name_and_valid_author_and_valid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }

    @Then("^error message \"([^\"]*)\" is shown$")
    public void error_message_is_shown(String error_message) throws Throwable {
        assertTrue(driver.getPageSource().contains(error_message));
    }

    @When("^valid name \"([^\"]*)\" and empty author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_author_and_valid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }

    @When("^valid name \"([^\"]*)\" and empty author \"([^\"]*)\" and invalid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_author_and_invalid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }
    
    @Given("^a book with a name \"([^\"]*)\" and author \"([^\"]*)\" and isbn \"([^\"]*)\" is added$")
    public void a_book_with_a_name_and_author_and_isbn_is_added(String name, String author, String isbn) throws Throwable {
        driver.get(BASE_URL);
        clickLinkWithText("Lisää kirja");
        addBookWith(name, author, isbn);
    }

    @When("^at the home page$")
    public void at_the_home_page() throws Throwable {
        driver.get(BASE_URL);
    }
    
    @Given("^ten books are created with same name \"([^\"]*)\" same author \"([^\"]*)\" and same isbn \"([^\"]*)\"$")
    public void ten_books_are_created_with_same_name_same_author_and_same_isbn(String name, String author, String isbn) throws Throwable {
        for(int i = 0; i < 10; i++) {
        	driver.get(BASE_URL);
        	clickLinkWithText("Lisää kirja");
        	addBookWith(name, author, isbn);
        }
    }

    @When("^next page is selected$")
    public void next_page_is_selected() throws Throwable {
        clickLinkWithText("Next »");
    }


    
    private void addBookWith(String name, String author, String isbn) {
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(name);
        element = driver.findElement(By.name("author"));
        element.sendKeys(author);
        element = driver.findElement(By.name("isbn"));
        element.sendKeys(isbn);
        element = driver.findElement(By.name("submit"));
        element.click();
    }

    private void clickLinkWithText(String text) {
        int trials = 0;
        while( trials++<5 ) {
            try{
                final WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;           
            } catch(Exception e) {
                e.getStackTrace();
            }
        }
    }
    
}
