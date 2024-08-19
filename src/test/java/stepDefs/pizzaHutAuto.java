package stepDefs;


import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class pizzaHutAuto {
	List<String> tab;
	Map<String,String> table;
	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		driver.get("https://www.pizzahut.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Hooks.test.log(LogStatus.PASS, "Application Launched");
        
        
	            }
	@When("I enter the location as {string}")
	public void i_enter_the_location_as(String cityName) {
		WebElement location = driver.findElement(By.xpath("//input[@type='text']"));
		location.sendKeys(cityName);
		
           }
    @When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list()  {
		
		List<WebElement> list = driver.findElements(By.xpath("//div[text()='Pune Railway Station']"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Pune Railway Station")) {
				list.get(i).click();
			}}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
     @Then("I should be able to see {string}")
	public void i_should_be_able_to_see(String args)  {
		WebElement basketElement = driver.findElement(By.xpath("//*[contains(text(),'Your Basket')]"));
		Assert.assertTrue(basketElement.isDisplayed());
		System.out.println(basketElement.getText());	
		}
	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String tab) {
		WebElement pizatab=driver.findElement(By.xpath("//div[@class='flex lg:flex-col']/div[1]/div[1]/a[2]/span"));
		pizatab.click();
         }
	@Then("I select the deal {string}")
	public void i_select_the_deal(String deal)  {
		WebElement panOption = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/span[1]/div[1]/a[2]/div[3]/div[1]/div[1]/div[1]/label[1]/select[1]"));
		Select dealPlan = new Select(panOption);
		dealPlan.selectByVisibleText(deal);
	    }
	@Then("I add {string} to the basket")
	public void i_add_to_the_basket(String additem) {
		WebElement additem1 = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/span[1]/div[1]/a[2]/div[3]/div[1]/button[1]/span[1]"));
		additem1.click();
		}
	@Then("I note down the price displayed on the screen")
	public void i_note_down_the_price_displayed_on_the_screen() {
		WebElement payableamount = driver.findElement(By.xpath("//span[@class='amountdue']"));
		System.out.println(payableamount.getText());
	    }
	@Then("I should see the pizza {string} is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart(String expRes)  {
		WebElement actRes = driver.findElement(By.xpath("//div[text()='Medium Schezwan Margherita']"));
		System.out.println(actRes.isDisplayed());
        }
	@Then("price is also displayed correctly")
	public void price_is_also_displayed_correctly() {
		WebElement payableAmount = driver.findElement(By.xpath("//span[@class='amountdue']"));
		Assert.assertTrue(payableAmount.isDisplayed());
	    }
	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button()  {
		WebElement chkoutbtn = driver.findElement(By.xpath("//div[@class='basket-checkout']"));
		chkoutbtn.click();
	    }
	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
		WebElement element = driver.findElement(By.xpath("//span[text()='Secure Checkout']"));
		Assert.assertTrue(element.isDisplayed());
	    }
	@Then("I enter the personal details")
	public void i_enter_the_personal_details(Map<String,String> table1)  {
		this.table = table1;
		System.out.println(table);
		}
	@Then("I enter the address details")
	public void i_enter_the_address_details(List<String> tab2) {
		this.tab = tab2;
		System.out.println(tab);
	     }
	@Then("The cash icon should be disable")
	public void the_cash_icon_should_be_disable() {
		WebElement cashbtn = driver.findElement(By.id("payment-method--cash"));
		if (cashbtn.isEnabled()) {
			System.out.println("cashbtn is Enable");
		} else {
			System.out.println("cashbtn is disbale");
		}
	}
}
