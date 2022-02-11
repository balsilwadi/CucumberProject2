package steps;

import expectedText.ExpectedTexts;
import io.cucumber.datatable.DataTable;
import gherkin.ast.TableRow;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.SmartBearHomePage;
import pages.SmartBearOrderPage;
import pages.SmartBearWebOrdersPage;
import utilities.Driver;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.Waiter;

import javax.swing.text.TableView;
import java.text.SimpleDateFormat;
import java.util.*;

public class SmartBearSteps {
    WebDriver driver;
    SmartBearHomePage smartBearHomePage;
    SmartBearWebOrdersPage smartBearWebOrdersPage;
    SmartBearOrderPage smartBearOrdersPage;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        smartBearHomePage = new SmartBearHomePage(driver);
        smartBearWebOrdersPage = new SmartBearWebOrdersPage(driver);
        smartBearOrdersPage = new SmartBearOrderPage(driver);
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String username) {
        switch (username) {
            case "abcd" -> smartBearHomePage.usernameBox.sendKeys(username);
            case "Tester" -> smartBearHomePage.usernameBox.sendKeys(username);

        }

    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        switch (password) {
            case "abcd1234" -> smartBearHomePage.passwordBox.sendKeys(password);
            case "test" -> smartBearHomePage.passwordBox.sendKeys(password);

        }
    }


    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals(message, smartBearHomePage.message.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }


    @When("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        List<String> expectedMenuItems = dataTable.asList();
        for (int i = 0; i < smartBearWebOrdersPage.menu.size(); i++) {
            Assert.assertEquals(expectedMenuItems.get(i), smartBearWebOrdersPage.menu.get(i).getText());
        }
    }

    @When("user clicks on “Check All” button")
    public void userClicksOnCheckAllButton() {
        smartBearWebOrdersPage.checkAll.click();
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < smartBearWebOrdersPage.checkBox.size(); i++) {
            Assert.assertTrue(smartBearWebOrdersPage.checkBox.get(i).isSelected());
        }
    }



    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < smartBearWebOrdersPage.checkBox.size(); i++) {
            Assert.assertFalse(smartBearWebOrdersPage.checkBox.get(i).isSelected());
        }
    }


    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        switch (menuItem) {
            case "Order" -> smartBearWebOrdersPage.menu.get(2).click();
            case "View all orders" -> smartBearWebOrdersPage.menu.get(0).click();


        }
    }
    @And("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "Login" -> smartBearHomePage.loginButton.click();
            case "Check All" -> smartBearWebOrdersPage.checkAll.click();
            case "Uncheck All" -> smartBearWebOrdersPage.uncheckAll.click();
            case "Process" -> smartBearOrdersPage.process.click();
            case "Delete Selected" -> smartBearWebOrdersPage.delete.click();


        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String product) {
        new Select(smartBearOrdersPage.product).selectByIndex(1);
    }

    @And("user enters {string} as quantity")
    public void userEntersAsQuantity(String quantity) {
        Actions actions = new Actions(driver);
        actions.doubleClick(smartBearOrdersPage.textBoxes.get(0)).sendKeys(quantity).perform();

    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        for (int i = 0; i < ExpectedTexts.addressInfo.length; i++) {
            smartBearOrdersPage.addressInputs.get(i).sendKeys(ExpectedTexts.addressInfo[i]);
        }
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        smartBearOrdersPage.visa.click();
        for (int i = 0; i < ExpectedTexts.paymentInfo.length; i++) {
            smartBearOrdersPage.paymentInputs.get(i).sendKeys(ExpectedTexts.paymentInfo[i]);
        }

    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String arg0) {

        System.out.println(smartBearWebOrdersPage.userInfo.get(4).getText());
        sdf.setTimeZone(TimeZone.getTimeZone("UK"));
        Assert.assertEquals(sdf.format(new Date()),smartBearWebOrdersPage.userInfo.get(4).getText());
    }



    @And("validate all information entered displayed as below")
    public void validateAllInformationEnteredDisplayedAsBelow(DataTable dataTable) {
        List<String> list= new ArrayList<>(dataTable.asList());
        for (int i = 1; i < list.size(); i++) {
            Assert.assertEquals(list.get(i),smartBearWebOrdersPage.userInfo.get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the “List of All Orders”")
    public void validateAllOrdersAreDeletedFromTheListOfAllOrders() {
        Assert.assertEquals(0, smartBearWebOrdersPage.checkBox.size());
    }



    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertTrue(smartBearWebOrdersPage.message.isDisplayed());
        Assert.assertEquals(message,smartBearWebOrdersPage.message.getText());
    }
}

