package haruo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertTrue;

public class ExampleTest {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Given("^I am on Google home page$")
    public void i_am_on_Google_home_page() throws Throwable {
        driver.get("http://www.google.com");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String searchParameter) throws Throwable {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchParameter);
        element.submit();
    }

    @Then("^the page title should contain \"([^\"]*)\"$")
    public void the_page_title_should_contain(String title) throws Throwable {
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> {
            return d.getTitle().startsWith(title);
        });
        assertTrue(driver.getTitle().contains(title));
    }
}