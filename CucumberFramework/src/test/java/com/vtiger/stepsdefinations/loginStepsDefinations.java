package com.vtiger.stepsdefinations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.pages.LoginPage;
import com.vtiger.pages.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepsDefinations extends BaseDefination{
	
	public PageObjectManager pageobjectmanager;
	
	@Before
	public void getScenarioName(Scenario scenario)
	{
		TCName=scenario.getName();
		initiation();
		logger=extent.createTest(TCName);
	}
	@After
	public void closeApp()
	{
		extent.flush();
		
	}
	
	
	
	@Given("user should be login page")
	public void user_should_be_login_page() {
		
		if(driver==null)
		{
				launchApp();
		}
		
		 pageobjectmanager=new PageObjectManager(driver);
		   
	}
	
	@When("user can verify Title")
	public void verifytitle()
	{
		pageobjectmanager.getLoginPage().verifyTitle(dt.get(TCName).get("Title"));
	}
	@When("user can verify Logo")
	public void verifylogo()
	{
		pageobjectmanager.getLoginPage().verifyLogo();
	}
	@When("user can verify KeyModule Text")
	public void verifykeymoduletext()
	{
		pageobjectmanager.getLoginPage().verifykeymoduletext();
	}
	   
	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		

		pageobjectmanager.getLoginPage().SetUsername(prop.getProperty("userid"));
		pageobjectmanager.getLoginPage().setPassword(prop.getProperty("password"));
	   
	}
	@When("click on login button")
	public void click_on_login_button() {
		
		pageobjectmanager.getLoginPage().clickLogin();
	    
	}
	@Then("should navigated to home page")
	public void should_navigated_to_home_page() {
		
		driver.findElement(By.linkText("Home")).isDisplayed();
	    
	}
	@Then("user can click on logout link")
	public void user_can_click_on_logout_link() {
		
		driver.findElement(By.linkText("Logout")).click();
	    
	}
	
	@When("user enters Invalid credentials")
	public void user_enters_invalid_credentials() {
		
		pageobjectmanager.getLoginPage().SetUsername("admin123");
		pageobjectmanager.getLoginPage().setPassword("admin123");
	}
	@When("user can validate error message on login page")
	public void user_can_validate_error_message_on_login_page() {
		
		driver.findElement(By.xpath("//td[contains(text(),' You must specify a valid username and password.')]/.")).isDisplayed();
	   
	}
	
	@When("user enters Invalid userid as {string} and password as {string}")
	public void user_enters_invalid_userid_as_and_password_as(String uid, String pwd) {
		
	
		pageobjectmanager.getLoginPage().SetUsername(uid);
		pageobjectmanager.getLoginPage().setPassword(pwd);
	    
	}
	
	@When("user can verify the existing text {string}")
	public void vetify_all_texts(String txt) {
		
		pageobjectmanager.getLoginPage().verifyalltext(txt);
	    
	}
	
	@Given("user can verify size of dropdown list")
	public void user_can_verify_size_of_dropdown_list() {
		WebElement elm=driver.findElement(By.name("login_theme"));
		Select s=new Select(elm);
		List<WebElement> ls=s.getOptions();
		System.out.println("Size"+ls.size());
	    
	}

	@Given("user can verify Expected and Actual list in dropdown")
	public void user_can_verify_expected_and_actual_list_in_dropdown() {
		
	    List<String> expdv=new ArrayList<String>();
	    {
	    	{
	    		expdv.add("Aqua");
	    		expdv.add("blue");
	    		expdv.add("nature");
	    		expdv.add("orange");
	    		
	    	}
	    	
	    };
	    System.out.println("Expected dropdown value");
	    for(String expectedOptions:expdv)
	    {
	    	System.out.println(expectedOptions.toString());
	    }
	    
	    WebElement elm=driver.findElement(By.name("login_theme"));
		Select s=new Select(elm);
	   
		List<WebElement> actdv=s.getOptions();
		System.out.println("Actual values in dropdown");
		for(WebElement actalvalues:actdv)
		{
			System.out.println(actalvalues.getText());
		}
		System.out.println("Compare theActual values and expected values in dropdown");
		for(int i=0;i<actdv.size();i++)
		{
			if(actdv.get(i).getText().equals(expdv.get(i).toString()))
			{
				 System.out.println("Value Matching :"+"Actual List Value="+actdv.get(i).getText()+" And Expected Value="+expdv.get(i));
			}
			else
			{
				System.out.println("Value not Matching :"+"Actual List Value="+actdv.get(i).getText()+" And Expected Value="+expdv.get(i));
			}
		}
		
	}

	@Given("User can verify dropdown list are sorted")
	public void user_can_verify_dropdown_list_are_sorted() {
		WebElement elm=driver.findElement(By.name("login_theme"));
		Select se=new Select(elm);
		ArrayList original=new ArrayList();
		for(WebElement e:se.getOptions())
		{
			original.add(e.getText());
		}
		System.out.println("Original List"+original);
		
		ArrayList temp=original;
		Collections.sort(temp);
		
		
		System.out.println("Original List"+original);
		System.out.println("Temporary List"+temp);
		
		if(original==temp)
		{
			System.out.println("Dropdown are sorted");
			
		}
		else
		{
			System.out.println("Dropdown are not sorted");
		}
	}

	@Given("User can verify default selected item")
	public void user_can_verify_default_selected_item() {
		WebElement elm=driver.findElement(By.name("login_theme"));
		Select sel=new Select(elm);
		System.out.println(sel.getFirstSelectedOption().getText());
	}




}
