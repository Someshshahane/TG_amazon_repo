package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.actions.ValidateFilterListActions;

public class ValidateFilterList {
	ValidateFilterListActions validateFilterListActions = new ValidateFilterListActions();
	
	@And("Select Mobile")
	public void select_mobile() throws InterruptedException {
		validateFilterListActions.selectMobiles();
	}

	@Then("Apply brand filter")
	public void apply_brand_filter() {
		validateFilterListActions.selectBrandName();
	}

	@And("Validate result as per brand name")
	public void validate_result_as_per_brand_name() throws InterruptedException {
		validateFilterListActions.validateProductList();
	  	}
}
