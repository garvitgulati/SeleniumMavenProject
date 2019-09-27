package util;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class basic {
public	WebDriver driver;
Properties prop;
  @BeforeTest
  public void beforeTest() throws FileNotFoundException, IOException {
	 prop=new Properties();
	   prop.load(new FileInputStream(".//Settings.property"));
	   System.out.println(prop.getProperty("url"));
	   
	   if(prop.getProperty("browser").equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver","D:\\1SEL\\chromedriver.exe");
		  driver=new ChromeDriver();
	   }
	   else  if(prop.getProperty("browser").equals("firefox"))
	   {
		   System.setProperty("webdriver.gecko.driver","D:\\1SEL\\geckodriver.exe");
		 driver=new FirefoxDriver();
	   }
  }

  @AfterTest
  public void afterTest() {
	 // driver.quit();
  }

}
