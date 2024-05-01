package com.vtiger.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.stepsdefinations.BaseDefination;

public class PageAction {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public PageAction(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(0));
	}
	
	public String getScreenshot()
	{
		Date d=new Date();
		DateFormat ft=new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName=ft.format(d);
		String path=System.getProperty("user.dir")+"/src/test/java/com/vtiger/report/screenshot" + fileName +".png";
		TakesScreenshot ts=((TakesScreenshot)driver);
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path);
		try
		{
			FileUtils.copyFile(SrcFile,DestFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return path;
		
		
		
	}
	
	public void setText(WebElement elm,String value,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(value);
		BaseDefination.logger.pass(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefination.logger.fail("step fail due to error"+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void validate_Expected_Actual(String exp,String act,String msg)
	{
		if(exp.equals(act))
		{
			BaseDefination.logger.pass(msg);
		}
		else
		{
			BaseDefination.logger.fail("Comparison failed because text is"+exp+" Actual Was" +act+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	public void setText(By elm,String value)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(elm)));
		driver.findElement(elm).clear();
		driver.findElement(elm).sendKeys(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setText(String elm,String value)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));
		driver.findElement(By.xpath(elm)).clear();
		driver.findElement(By.xpath(elm)).sendKeys(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void ClickElement(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		BaseDefination.logger.pass(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefination.logger.fail("step fail due to error"+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	public void ElementExist(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
		BaseDefination.logger.pass(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefination.logger.fail("Elemebnt not found due to error"+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
		
	}
	public void selectText(WebElement elm,String value,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		Select sel=new Select(elm);
		elm.sendKeys(value);
		BaseDefination.logger.pass(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BaseDefination.logger.fail("step fail due to error"+e.getMessage()+"<a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}


}
