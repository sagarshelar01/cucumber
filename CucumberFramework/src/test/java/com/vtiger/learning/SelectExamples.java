package com.vtiger.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExamples {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/admin/Downloads/Multi-Select%20Dropdown.html");
		
		/*
		 * WebElement elm= driver.findElement(By.name("login_theme")); Select sel=new
		 * Select(elm);
		 * 
		 * sel.selectByIndex(2); Thread.sleep(2000); sel.selectByValue("orange");
		 * Thread.sleep(2000); sel.selectByVisibleText("Aqua"); Thread.sleep(2000);
		 */
		
		Select s=new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("India");
		s.selectByVisibleText("Pakistan");
		s.selectByVisibleText("US");
		
		s.deselectByVisibleText("Pakistan");
		
		List<WebElement>ls=s.getOptions();
		System.out.println("Size=" +ls.size()); 
		System.out.println(s.getFirstSelectedOption().getText());
		
	
		
		
	}

}
