package com.vtiger.learning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

		
		public static void main(String args[]) throws InterruptedException
		{
			WebDriver driver=new ChromeDriver();
			driver.get("http://localhost:100/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.name("Login")).click();
			driver.findElement(By.linkText("New Lead")).click();
			driver.findElement(By.name("button")).click();
			
			Alert alt=driver.switchTo().alert();
			alt.accept();
			alt.dismiss();
			alt.getText();
			
		}

}
