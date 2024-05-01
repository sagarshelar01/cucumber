package com.vtiger.stepsdefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class leadSteps extends BaseDefination {
	
	
	@When("user click on new leads")
	public void click_new_lead() {
		
		driver.findElement(By.linkText("New Lead")).click(); 
	}
	

	@When("fill all mandatory fielda and click on save button")
	public void fill_mandatory_lead_form() {
		
		driver.findElement(By.name("lastname")).sendKeys(dt.get(TCName).get("Lastname"));
		driver.findElement(By.name("company")).sendKeys(dt.get(TCName).get("Company"));
		driver.findElement(By.name("button")).click();
		   
	}
	
	@When("lead should be created sucesstully")
	public void validate_lead_creation() {
		
		driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals("Pawar");
		driver.findElement(By.xpath("//td[text()='Company:']/following::td[1]")).getText().equals("ATQ");
	}
	
	@When("user creates multiple leads with {string} and {string} verified")
	public void user_creates_multiple_leads_with_and_verified(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		List<Map<String,String>>dt=dataTable.asMaps();
		for(Map<String,String> m:dt)
		{
		driver.findElement(By.linkText("New Lead")).click(); 
		driver.findElement(By.name("lastname")).sendKeys(m.get("lastname"));
		driver.findElement(By.name("company")).sendKeys(m.get("company"));
		driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals(m.get("lastname"));
		driver.findElement(By.xpath("//td[text()='Company:']/following::td[1]")).getText().equals(m.get("company"));
		}
	}
	@When("click on logout button")
	public void click_on_logout_button() {
	
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@When("Alert should be populated for Lastname field")
	public void alert_should_be_populated_for_lastname_field() throws InterruptedException {
		
		
		Alert alt=driver.switchTo().alert();
		Thread.sleep(2000);
		alt.accept();    
	}
	
	@When("user fill the lastname field")
	public void user_fill_the_lastname_field() {
		
		driver.findElement(By.name("lastname")).sendKeys("Pawar");	
	    
	}
	
	@When("Alert should be populated for company field")
	public void alert_should_be_populated_for_company_field() throws InterruptedException {
		
		Alert alt=driver.switchTo().alert();
		Thread.sleep(1000);
		alt.accept();   
	}

	@When("user fill the company field")
	public void user_fill_the_company_field() {
		
		driver.findElement(By.name("company")).sendKeys("sigma");	
	    
	}
	
	@When("click on save button")
	public void click_on_save_button() 
	{
		driver.findElements(By.name("button")).get(2).click();
	}
	
	@Given("user should click on leads menu")
	public void user_should_click_on_leads_menu() {
		
		driver.findElement(By.linkText("Leads")).click();
	    
	}
	@When("user enters lastname and company field")
	public void user_enters_lastname_and_company_field() {
		
		driver.findElements(By.name("lastname")).get(1).sendKeys("pawar");
		driver.findElements(By.name("company")).get(1).sendKeys("sigma");
		
	    
	}
	@When("user serch the record")
	public void user_serch_the_record() {
		
		driver.findElements(By.name("button")).get(1).click();
	    
	}
	@Then("user select the id and click the checkbox")
	public void user_select_the_id_and_click_the_checkbox() {
		
		driver.findElements(By.name("selected_id")).get(0).click();
	    
	}
	@Then("user should delete the record.")
	public void user_should_delete_the_record() {
		
		driver.findElements(By.className("button")).get(3).click();
	    
	}


}
