package stepdefinitions;


import io.cucumber.java.After;
import utils.SeleniumDriver;

public class AfterActions {

	@After
	public static void tearDown() {

		SeleniumDriver.tearDown();
	}
}
