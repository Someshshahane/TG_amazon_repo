package pages.actions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import pages.locators.AddToCartLocators;
import utils.SeleniumDriver;

public class AddToCartActions {
	String mainWindowHandle;
	SoftAssert softAssert;

	AddToCartLocators addToCartLocators ;
	
	public AddToCartActions(){
		  this.addToCartLocators = new AddToCartLocators();
	        PageFactory.initElements(SeleniumDriver.getDriver(), addToCartLocators);
	    }
	
	public void clickOnSearchBar() {
		  WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), SeleniumDriver.TIMEOUT);
		  System.out.println("Is click");
		  SeleniumDriver.getDriver().findElement(By.xpath("//form[@id='nav-search-bar-form']//input[@id='twotabsearchtextbox' and @type='text']")).click();
		//    addToCartLocators.search.click();
		}
	public void searchIphone(String productname) {
		 SeleniumDriver.getDriver().findElement(By.xpath("//form[@id='nav-search-bar-form']//input[@id='twotabsearchtextbox' and @type='text']")).sendKeys(productname);
		 WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), SeleniumDriver.TIMEOUT);
	}
	
	public void selectIphone15ProMax() throws InterruptedException {
		Thread.sleep(3000);
		 WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), SeleniumDriver.TIMEOUT);
		 SeleniumDriver.getDriver().findElement(By.xpath("//div[@aria-label='iphone 15 pro max']")).click();

	}
	public void productDetailsPage() {
		 JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
		 js.executeScript("window.scrollBy(0,250)");
		 WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), SeleniumDriver.TIMEOUT);
		 SeleniumDriver.getDriver().findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div[@class='a-section aok-relative s-image-fixed-height']")).click();
	
	}
	public void newWindowOpen() throws InterruptedException {
		 Thread.sleep(4000);
		
		  mainWindowHandle = SeleniumDriver.getDriver().getWindowHandle();
	      SeleniumDriver.switchToNewWindow();
	      WebElement newWindow = SeleniumDriver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));
	      newWindow.click();

	       assertTrue(newWindow.isDisplayed());
	}
	public void storePriceInVariable() {
		
	  WebElement price = SeleniumDriver.getDriver().findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));

		String Price = price.getText();
  	    System.out.println("Product Price is "+Price);
	}
	public void clickOnAddToCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
		 js.executeScript("window.scrollBy(0,200)");
		 WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), SeleniumDriver.TIMEOUT);
		 Thread.sleep(2000);
		 SeleniumDriver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//span[@id='submit.add-to-cart']")).click();
		 Thread.sleep(3000);
	}
	public void popupAddedToCart() {
		
		  WebElement addedToCart = SeleniumDriver.getDriver().findElement(By.xpath("//div[@id='attach-added-to-cart-message']//h4[text()='Added to Cart']"));

          assertTrue(addedToCart.isDisplayed());
	}
	public void mainWindow() {
		SeleniumDriver.switchToWindow(mainWindowHandle);
	}
	public void clickOnCart() throws InterruptedException {
		Thread.sleep(3000);
		SeleniumDriver.getDriver().findElement(By.id("nav-cart-count-container")).click();
		Thread.sleep(2000);
	}
	public void productAddedSuccessful() {
		 WebElement addedToCartSuccesfull = SeleniumDriver.getDriver().findElement(By.xpath("//span[text()='Apple iPhone 15 Pro Max (256 GB) - Natural Titanium' and @class='a-truncate-cut']"));

        assertTrue(addedToCartSuccesfull.isDisplayed());
	}
}
