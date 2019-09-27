package util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Keywords {
WebDriver driver;
Select select;
	public Keywords(WebDriver driver)
{
	this.driver=driver;
}
	public void type(String Locator,String data)
	{
		//id:=P11_USERNAME
		String LocatorType=Locator.split(":=")[0];
		String LocatorValue=Locator.split(":=")[1];
		
		switch(LocatorType)
		{
		case "id":
			 driver.findElement(By.id(LocatorValue)).sendKeys(data);
			 break;
			 
		case "name":
			 driver.findElement(By.name(LocatorValue)).sendKeys(data);
			 break;

		case "css":
			 driver.findElement(By.cssSelector(LocatorValue)).sendKeys(data);
			 break;

		case "xpath":
			 driver.findElement(By.xpath(LocatorValue)).sendKeys(data);
			 break;

		case "link":
			 driver.findElement(By.linkText(LocatorValue)).sendKeys(data);
			 break;
			 	 	 	 
		}
	}
	public void click(String Locator)
	{
		String LocatorType=Locator.split(":=")[0];
		String LocatorValue=Locator.split(":=")[1];
		
		switch(LocatorType)
		{
		case "id":
			 driver.findElement(By.id(LocatorValue)).click();
			 break;
			 
		case "name":
			 driver.findElement(By.name(LocatorValue)).click();
			 break;

		case "css":
			 driver.findElement(By.cssSelector(LocatorValue)).click();
			 break;

		case "xpath":
			 driver.findElement(By.xpath(LocatorValue)).click();
			 break;

		case "link":
			 driver.findElement(By.linkText(LocatorValue)).click();
			 break;
			 	 	 	 
		}
	}
	public void takeScreenShot(String LocationWithName) throws IOException {
		
		
	    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(src, new File(LocationWithName));
		
	}
	public void getURL(String URL)
	{
		driver.get(URL);
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	public void dropdown(String Locator,String data) {
		

			String LocatorType=Locator.split(":=")[0];
			String LocatorValue=Locator.split(":=")[1];
		
			switch(LocatorType)
			{
			case "id":
				 select=new Select(driver.findElement(By.id(LocatorValue)));
			
				 break;
				 
			case "name":
			 select=new Select(driver.findElement(By.name(LocatorValue)));
		
				 break;

			case "css":
			 select=new Select(driver.findElement(By.cssSelector(LocatorValue)));
					
				 break;

			case "xpath":
		 select=new Select(driver.findElement(By.xpath(LocatorValue)));
	
				 break;

			case "link":
			select=new Select(driver.findElement(By.linkText(LocatorValue)));
				
				 break;
				 	 	 	 
			}
			select.selectByVisibleText(data);
}
}