package SetupClass.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sli_search extends Set{
	
	WebDriverWait wait = new WebDriverWait(driver,50);


	@Given("^Open the website URL\\.$")
	public void open_the_website_URL() throws Throwable {
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1200);
	}
// Magento to SLI page
	@Then("^enter a keyword to search\\.$")
	public void enter_a_keyword_to_search() throws Throwable {
		
//User enter keyword in search box
		  WebElement search_btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
		  Thread.sleep(2000);
		  search_btn.sendKeys("HR"); 
		  Thread.sleep(4000);
		  
		  
// search suggestions are displayed
		  WebElement search_1 =wait.until(ExpectedConditions.elementToBeClickable(By.id("sli_ac_section_products"))); 
		  Thread.sleep(2000); 
		  String text1=search_1.getText(); 
		  System.out.println(text1); 
		  Thread.sleep(3000);
		  
		  String actual_text1="Product Suggestions for Hr Interview ";
		  
		  if(text1.equalsIgnoreCase(actual_text1)) {
		  log.info("product suggestion tab header is displayed correctly "); }
		  
		  WebElement prod_sugg =wait.until(ExpectedConditions.elementToBeClickable(By.id("sli_raclist_products"))); 
		  Thread.sleep(2000); 
		  String pro_sugg_loc=prod_sugg.getText();
		  System.out.println("product suggestion list name is ----"+pro_sugg_loc);
		  
		  WebElement parent_product =wait.until(ExpectedConditions.elementToBeClickable(By.className("sli_product_list"))); 
		  Thread.sleep(2000);
		  System.out.println("classname  of parent is ----------------------->"+parent_product);
		  
//Click on view all button
		  
		  WebElement View_All =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sli_autocomplete > div > div.sli_ac_products > div > div.sli_view_more_link_wrapper > a")));
		  Thread.sleep(2000);
		  View_All.click();
		  Thread.sleep(4000);
		  
		 /* WebElement child1_product = wait.until(ExpectedConditions.elementToBeClickable(By.className("sli_ac_product"))); 
		  Thread.sleep(1000); 
		  child1_product.click();
		  Thread.sleep(4000);*/
		  
//Select product
		  
		  driver.get("https://www.slideteam.net/human-resources-performance-management-metrics-powerpoint-presentation-slides.html");
		  
		  WebElement download_ppt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][contains(.,'Download this presentation')]"))); 
		  Thread.sleep(8000); 
		  download_ppt.click(); 
		   Thread.sleep(5000);
		  
		  driver.navigate().refresh(); Thread.sleep(3800);
		  
		  WebElement old_paid_email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		  old_paid_email.sendKeys("Sakshi.pathania@slidetech.in");
		  
		  WebElement old_paid_pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
		  old_paid_pass.sendKeys("Qwerty@1");
		  
		  WebElement old_paid_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.login > span:nth-child(1)")));
		  old_paid_login_btn.click();
		  
		  
		  WebElement download_ppt1 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][contains(.,'Download this presentation')]"))); 
		  Thread.sleep(2000); 
		  download_ppt1.click(); 
		  Thread.sleep(2000);
		  
		  driver.navigate().refresh(); 
		  Thread.sleep(3800);
		  
//SLI to SLI page
// Click on left side menu

          WebElement Left_Process =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='new-menu']/li[5]/a/p")));
		  Thread.sleep(3000);
		  Left_Process.click();
		  Thread.sleep(1000);
		  
		  WebElement Refine_node =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#facet-stages > li:nth-child(1) > input[type=checkbox]")));
		  Thread.sleep(3000);
		  Refine_node.click();
// Sort by drop down list
          Select dropdown= new select(driver.findElement(By.Id("#dk0-combobox")));
          dropdown.selectByVisibleText("Newest");
          Thread.sleep(3000);
		  
//SLI to Magento

          WebElement Left_Design =wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("#new-menu > li:nth-child(1) > a")));
		  Thread.sleep(3000);
		  Left_Design.click();
		  Thread.sleep(1000);
		  }
}
