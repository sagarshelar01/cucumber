package com.vtiger.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public LoginPage loginPage;
	public HomePage homePage;
	public NewLeadPage newleadPage;
	
	public LoginPage getLoginPage()
	{
		return(loginPage==null) ? loginPage=new LoginPage(driver): loginPage;
		
	}
	public HomePage getHomePage()
	{
		return(homePage==null) ? homePage=new HomePage(driver): homePage;
		
	}
	public NewLeadPage getNewLeadPage()
	{
		return(newleadPage==null) ? newleadPage=new NewLeadPage(driver): newleadPage;
		
	}
	

}
