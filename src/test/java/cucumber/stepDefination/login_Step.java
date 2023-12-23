package cucumber.stepDefination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.*;

public class login_Step extends Base {

    private String username;
    private String password;
    private String numOfitems;
    private String smallTitle;
    private String itemNames [];
    private Float itemPrices [];

    @Given("User should navigate to swag labs login page")
    public void user_should_navigate_to_swag_labs_login_page() {
        String url = "https://www.saucedemo.com/";
        driver = inheritance();
        driver.get(url);
    }

    @When("^User enter the \"([\\w\\s\"']*)\" and \"([\\w\\s\"']*)\"$")
    public void user_enter_the_Username(String Username, String Password) {
        username = Username;
        password = Password;
        Helper H1 = new Helper(driver);
        H1.typeUserName().sendKeys(Username);
        H1.typePassword().sendKeys(Password);

    }

    @When("User click the login button")
    public void user_click_the_login_button() {

        Helper H1 = new Helper(driver);
        H1.clickLoggingButton().click();

    }

    @Then("User should navigate to Swag Labs home page")
    public void user_should_navigate_to_swag_labs_home_page() throws InterruptedException {

        Helper H1 = new Helper(driver);
        boolean var1 = H1.HomePage().isDisplayed();

        if (var1 == true) {
            System.out.println("Navigated Successfully");
            Thread.sleep(2000);
            driver.close();
        } else {
            System.out.println("Not navigated");
        }

    }

    @Then("User should not navigate to Swag Labs home page")
    public void user_should_not_navigate_to_swag_labs_home_page() throws InterruptedException {

        Helper H1 = new Helper(driver);
        boolean var1 = H1.LoginPage().isDisplayed();

        if (var1 == true) {
            System.out.println("Not Navigated");
            Thread.sleep(2000);
            driver.close();
        } else {
            System.out.println("Navigated to Home page");

        }

    }
}
