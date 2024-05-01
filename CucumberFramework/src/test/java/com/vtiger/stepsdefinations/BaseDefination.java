package com.vtiger.stepsdefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.util.StringMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefination {
	
	
	
	public static WebDriver driver;
	public Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static String TCName;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public void initiation()
	{
		if(extent==null)
		createExtentReport();
		readProperties();
		dt=readExcelData(System.getProperty("user.dir")+"/src/test/resources/Data/test.xlsx","Sheet1");
		System.out.println(dt);
		
	}
	
	public void launchApp()
	{
		if(prop.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(prop.getProperty("browser").equals("headless"))
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--headless=new");
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitwait"))));
	}
	public void readProperties()
	{
		
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/setting.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Map<String,Map<String,String>> readExcelData(String file,String Sheet)
	{
		Map<String,Map<String,String>> dt=new HashMap<>();
		try {
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(file);
		String strQuery="Select * from "+Sheet;
		Recordset recordset=connection.executeQuery(strQuery);
		int rowcont=recordset.getCount();
		List<String> lst=recordset.getFieldNames();
		int clmcount=lst.size();
		
		 
		while(recordset.next()){

		Map<String,String> rowdata=new HashMap<>();
		
			for(int i=0;i<clmcount;i++)
			{
				rowdata.put(lst.get(i), recordset.getField(lst.get(i)));
			}
			dt.put(recordset.getField("TCName"), rowdata);
		}
		
		
		recordset.close();
		connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return dt;
	}
	
	public void createExtentReport()
	{
		Date d=new Date();
		DateFormat ft=new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName=ft.format(d);
		ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/report/ExtentReport"+fileName+".html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HostName", "Automation hub");
		extent.setSystemInfo("Enviornment", "Test");
		extent.setSystemInfo("Username", "Suman");
		htmlreporter.config().setDocumentTitle("Title of the report come here");
		htmlreporter.config().setReportName("Name of the report comes here");
		htmlreporter.config().setTheme(Theme.STANDARD);		
	}
	

}
