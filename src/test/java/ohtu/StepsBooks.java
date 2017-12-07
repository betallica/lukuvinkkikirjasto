package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepsBooks {

    private StepsBase stepsBase;
    private WebDriver driver;
    private final String ADD_BOOK_LINK = "Kirja";

    @Autowired
    public StepsBooks(StepsBase stepsBase) {
        this.stepsBase = stepsBase;
        this.driver = stepsBase.getDriver();
    }

    @Given("^command add book is selected$")
    public void command_add_book_is_selected() throws Throwable {
        driver.get(stepsBase.BASE_URL);
        stepsBase.clickLinkWithText(ADD_BOOK_LINK);
    }

    @Given("^a book with a name \"([^\"]*)\" and author \"([^\"]*)\" and isbn \"([^\"]*)\" is added$")
    public void a_book_with_a_name_and_author_and_isbn_is_added(String name, String author, String isbn) throws Throwable {
        driver.get(stepsBase.BASE_URL);
        stepsBase.clickLinkWithText(ADD_BOOK_LINK);
        addBookWith(name, author, isbn);
    }

    @Given("^ten books are created with same name \"([^\"]*)\" same author \"([^\"]*)\" and same isbn \"([^\"]*)\"$")
    public void ten_books_are_created_with_same_name_same_author_and_same_isbn(String name, String author, String isbn) throws Throwable {
        for(int i = 0; i < 10; i++) {
            driver.get(stepsBase.BASE_URL);
            stepsBase.clickLinkWithText(ADD_BOOK_LINK);
            addBookWith(name, author, isbn);
        }
    }

    @Given("^a new book with name \"([^\"]*)\" and author \"([^\"]*)\" and isbn \"([^\"]*)\" and the newest tag is added$")
    public void a_new_book_with_name_and_author_and_isbn_and_the_newest_tag_is_added(String name, String author, String isbn) throws Throwable {
        driver.get(stepsBase.BASE_URL);
        stepsBase.clickLinkWithText(ADD_BOOK_LINK);
        addBookWithNewestTag(name, author, isbn);
    }

    @Given("^a new book with a name \"([^\"]*)\" and author \"([^\"]*)\" and isbn \"([^\"]*)\" is added$")
    public void a_new_book_with_a_name_and_author_and_isbn_is_added(String name, String author, String isbn) throws Throwable {
        driver.get(stepsBase.BASE_URL);
        stepsBase.clickLinkWithText(ADD_BOOK_LINK);
        addBookWith(name, author, isbn);
    }

    @When("^book name is clicked$")
    public void book_name_is_clicked() throws Throwable {
        stepsBase.clickLinkWithText("Clean Code");
    }

    @Then("^page with book information is presented$")
    public void page_with_book_information_is_presented() throws Throwable {
        assertTrue(driver.getPageSource().contains("Kirja"));
    }

    @When("^valid name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_valid_author_and_valid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }

    @Then("^a new book is listed with the name \"([^\"]*)\"$")
    public void a_new_book_is_listed_with_the_name(String title) throws Throwable {
        assertTrue(driver.getPageSource().contains(title));
    }

    @When("^empty name \"([^\"]*)\" and valid author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void empty_name_and_valid_author_and_valid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }

    @When("^valid name \"([^\"]*)\" and empty author \"([^\"]*)\" and valid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_author_and_valid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }

    @When("^valid name \"([^\"]*)\" and empty author \"([^\"]*)\" and invalid isbn \"([^\"]*)\" are entered$")
    public void valid_name_and_empty_author_and_invalid_isbn_are_entered(String name, String author, String isbn) throws Throwable {
        addBookWith(name, author, isbn);
    }

    @Then("^a book with the name \"([^\"]*)\" is shown$")
    public void a_book_with_the_name_is_shown(String name) throws Throwable {
        assertTrue(driver.getPageSource().contains(name));
    }

    @Then("^a book with the name \"([^\"]*)\" is not shown$")
    public void a_book_with_the_name_is_not_shown(String name) throws Throwable {
        assertFalse(driver.getPageSource().contains(name));
    }

    @Given("^the book with name \"([^\"]*)\" is marked as read$")
    public void the_book_with_name_is_marked_as_read(String name) throws Throwable {
        driver.get(stepsBase.BASE_URL);
        stepsBase.clickLinkWithText(name);
        WebElement element = driver.findElement(By.name("isRead"));
        element.click();
    }

    private void addBookWithNewestTag(String name, String author, String isbn) {
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(name);
        element = driver.findElement(By.name("author"));
        element.sendKeys(author);
        element = driver.findElement(By.name("isbn"));
        element.sendKeys(isbn);
        element = driver.findElement(By.id("tags1"));
        element.click();
        element = driver.findElement(By.name("submit"));
        element.click();
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

}
