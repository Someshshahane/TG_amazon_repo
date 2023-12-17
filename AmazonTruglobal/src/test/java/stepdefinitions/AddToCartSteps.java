package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.AddToCartActions;
import utils.SeleniumDriver;

public class AddToCartSteps {
	AddToCartActions addToCartActions = new AddToCartActions(); 
	
	@Given("I am on the Home Page {string} of amazon Website")
	public void i_am_on_the_home_page_of_amazon_website(String url) {
		 SeleniumDriver.setUpDriver();
	    SeleniumDriver.openPage(url);
	}

	@When("I search on Search tab")
	public void i_search_on_search_tab() {
		addToCartActions.clickOnSearchBar();
	}

	@And("I search the {string}")
	public void i_search_the(String name) {
		addToCartActions.searchIphone(name);
	}

	@And("Select iphone as iphone fifthteen pro max from searchlist")
	public void select_iphone_as_iphone_fifthteen_pro_maxfrom_searchlist() throws InterruptedException {
		addToCartActions.selectIphone15ProMax();
	}

	@Then("Click on product details page")
	public void click_on_product_details_page() {
		addToCartActions.productDetailsPage();
	}

	@And("Check new window opened")
	public void check_new_window_opened() throws InterruptedException {
		addToCartActions.newWindowOpen();
	}

	@And("Store the price in variable")
	public void store_the_price_in_variable() {
		addToCartActions.storePriceInVariable();
	}

	@And("Click on Add to Cart")
	public void click_on_add_to_cart() throws InterruptedException {
		addToCartActions.clickOnAddToCart();
	}

	@And("Check the popup Added to Cart")
	public void check_the_popup_added_to_cart() {
		addToCartActions.popupAddedToCart();
	}

	@Then("Moving main Window")
	public void moving_main_window() {
		addToCartActions.mainWindow();
	}
	@And ("Click on Cart")
	public void click_on_cart() throws InterruptedException {
		addToCartActions.clickOnCart();
	}

	@And("Check the product added succesfully")
	public void check_the_product_added_succesfully() {
		addToCartActions.productAddedSuccessful();
	}


}
