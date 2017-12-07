package ohtu;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class StepsMarkAsRead {

    private StepsBase stepsBase;
    private WebDriver driver;

    public StepsMarkAsRead(StepsBase stepsBase) {
        this.stepsBase = stepsBase;
        this.driver = stepsBase.getDriver();
    }

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

}
