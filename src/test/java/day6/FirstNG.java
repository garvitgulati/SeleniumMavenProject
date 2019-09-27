package day6;

import org.testng.annotations.Test;

import util.basic;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class FirstNG extends basic {
	/*WebDriver driver;*/
  @Test
  public void f() {

	  driver.get("http://agiletestingalliance.org/");
	  driver.findElement(By.linkText("Certifications")).click();
	  List<WebElement> gg=driver.findElements(By.xpath("//area"));
	
		  System.out.println("No of certification are"+gg.size());
String url=driver.findElement(By.xpath("/html/body/section/div/div[2]/map/area[5]")).getAttribute("href");
	 System.out.println("href of the CP-BAT url is"+url); 
  }


}
