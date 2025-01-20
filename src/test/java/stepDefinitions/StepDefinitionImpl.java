package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	String confirmMessage;

	@Given("I landed on Ecomm Page")
	public void I_landed_on_Ecomm_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);
	}

	@When("^I add the product productname (.+) to Cart$") 
	public void I_add_the_product_to_Cart(String productName)  {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	@And("^Checkout productname (.+) and submit the order$")
	public void Checkout_product_and_submit_the_order(String productName) throws InterruptedException {
		CartPage cartPage = productCatalogue.gotoCartPage();
		Thread.sleep(3000);
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.gotoCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}

	@Then("{string} message is displayed on confirmationPage")
	public void message_is_displayed_on_confirmationPage(String string) {
		confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
}
