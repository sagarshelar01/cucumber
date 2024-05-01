package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.PageAction;
import com.vtiger.stepsdefinations.BaseDefination;

public class LoginPage extends PageAction {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="user_name")
	WebElement tb_useid;
	
	@FindBy(name="user_password")
	WebElement tb_pass;
	
	@FindBy(name="Login")
	WebElement btn_login;
	
	@FindBy(name="login_theme")
	WebElement dp_theme;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement img_logo;
	
	@FindBy(xpath="//font[text()='Key Modules']")
	WebElement txt_keymodule;
	
	
	
	
	public void verifyTitle(String ExpectedTitle)
	{
		validate_Expected_Actual(ExpectedTitle, driver.getTitle(), "Expected And Actual title validate sucessfully");
	}
	

	public void verifyLogo()
	{
		ElementExist(img_logo,"Logo displayed sucessfully");
	}
	
	public void verifykeymoduletext()
	{
		ElementExist(txt_keymodule,"text key module displayed sucessfully");
	}
	
	public void verifyalltext(String txt)
	{
		try {
		WebElement elm=driver.findElement(By.xpath("//*[contains(text()='"+txt+"')]"));
		ElementExist(elm,"text "+txt+" displayed sucessfully on login page");
		}
		catch(Exception e)
		{
			BaseDefination.logger.fail("Elemebnt not found due to error"+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	public void login(String uid,String pwd)
	{
		SetUsername(uid);
		setPassword(pwd);
		clickLogin();
		
	}
	public void login(String uid,String pwd,String theme)
	{
		SetUsername(uid);
		setPassword(pwd);
		selectTheme(theme);
		clickLogin();
		
	}
	
	public void SetUsername(String uid)
	{
		setText(tb_useid,uid,uid+"has been entered userid field sucessfully");
	}
	public void setPassword(String pwd)
	{
		setText(tb_pass,pwd,pwd+"has been entered password field sucessfully");
	}
	public void clickLogin()
	{
		ClickElement(btn_login,"login button clicked sucessfully");
	}
	public void selectTheme(String theme)
	{
		selectText(dp_theme,theme,theme+"Selected from theme dropdown");
	}

}
