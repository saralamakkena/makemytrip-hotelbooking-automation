package com.ustg.makemytriptest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HotelBooking {
 
	
	static ChromeDriver driver;
	static String path;
	
	
	@Before
	public  void initialise()
	{
	path=System.getProperty("user.dir")+"/lib/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
@Test
public void loginTest() throws InterruptedException {
	// login page test
	 driver.get("https://www.makemytrip.com/");
	 Thread.sleep(5000);
	 driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.id("username")).sendKeys("giveyourmailid/username");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button/span")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.id("password")).sendKeys("enter your password");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/section/form/div[2]/button/span")).click();
	 Thread.sleep(2000);
	 WebElement loginmsg= driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[6]/div/p"));
	assertTrue(loginmsg.getText().equals("Hey (Username)"));
	driver.manage().deleteAllCookies();
	driver.close();	
}	
@Test
public void hotelTest() throws InterruptedException, IOException {
	
	 driver.get("https://www.makemytrip.com/");	
	 Thread.sleep(5000);
	 driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
	 Thread.sleep(5000);
	 WebElement hotel= driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/a/span[1]"));
	 Thread.sleep(5000);
	 hotel.click();
	 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[1]/label/span")).click();
	 Thread.sleep(5000);
	 WebElement city= driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']"));
	 Thread.sleep(5000);
     city.sendKeys("Hyderabad");
     Thread.sleep(5000);
     city.sendKeys(Keys.ARROW_DOWN);
     Thread.sleep(5000);
     city.sendKeys(Keys.ENTER);
     Thread.sleep(5000);
   
      driver.findElement(By.xpath("//*[@id=\'checkin\']")).click();
     
     Thread.sleep(5000);
     
     WebElement checkin= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[6]"));
     Thread.sleep(5000);
     checkin.click();
     WebElement checkout = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[1]"));
     Thread.sleep(2000);
     checkout.click(); 
     Thread.sleep(2000);
     driver.findElement(By.id("guest")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[4]/div[1]/div[1]/div/div[2]/div/ul[1]/li[1]")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[1]/div[4]/div[1]/div[2]/button[2]")).click();
     Thread.sleep(2000);
     driver.findElement(By.id("hsw_search_button")).click();
     Thread.sleep(2000);
     
     //applying filters
     Actions drag = new Actions(driver);
     WebElement slider;
     slider = driver.findElement(By.className("input-range__slider"));
     
     WebDriverWait wait = new WebDriverWait(driver,30);
     wait.until(ExpectedConditions.elementToBeClickable(slider));
     
     int xCoord = slider.getLocation().getX();
     
     drag.moveToElement(slider).click().dragAndDropBy(slider,xCoord+40,0).build().perform();
     Thread.sleep(5000);
     driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_star_category\"]/ul/li[2]/span[1]/label")).click();
     Thread.sleep(5000);
     driver.findElement(By.xpath("//*[@id=\"hlistpg_fr_locality\"]/div/div[1]/ul/li[1]/span/label/span")).click();
     Thread.sleep(5000);
     
     //BookThisNow
     driver.findElement(By.id("htl_id_seo_201306201237062445")).click();
     Thread.sleep(5000);
     
     String bookNow = driver.getWindowHandle();
     Set<String> bkw = driver.getWindowHandles();
     Iterator<String> bn =  bkw.iterator();
     while (bn.hasNext()) {
    	 driver.switchTo().window(bn.next());
    	 System.out.println(driver.getTitle());
     }
     Thread.sleep(5000);
     driver.findElement(By.xpath("//*[@id='detpg_headerright_book_now'][@class='primaryBtn ']")).click();
    
     //Traveller Information & checkout
     Select sc = new Select(driver.findElement(By.id("title")));
     sc.selectByVisibleText("Ms");
     Thread.sleep(2000);
     
     //Firstname of  traveller
     WebElement fname = driver.findElement(By.id("fName"));
     Thread.sleep(3000);
     driver.findElement(By.className("close")).click();
     Thread.sleep(2000);
     fname.sendKeys("Harika");
     Thread.sleep(2000);
     
     //Lastname of traveller
     WebElement lname = driver.findElement(By.id("lName"));
     Thread.sleep(2000);
     lname.sendKeys("maheshwaran");
     Thread.sleep(2000);
     
     //Email
     WebElement email = driver.findElement(By.id("email"));
     Thread.sleep(2000);
     email.sendKeys("cantshowthis12@gmail.com");
     Thread.sleep(2000);
     
     //contact number
     WebElement phn = driver.findElement(By.id("mNo"));
     Thread.sleep(2000);
     phn.sendKeys("9876543210");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div[1]/div[9]/ul/li[4]/span/span/span/label")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div[1]/div[9]/ul/li[5]/span/span/span/label")).click();
     Thread.sleep(2000);
     driver.findElement(By.id("109")).sendKeys("No other requests");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div[2]/div[1]/div/a/div")).click();
     
     //Payment details
     
    
     Thread.sleep(5000);
     driver.findElement(By.xpath("//*[@id=\"CC\"]/span[2]")).click();
     Thread.sleep(2000);
     //card number
     driver.findElement(By.id("PAYMENT_cardNumber")).sendKeys("1234568901595377");
     Thread.sleep(2000);
     //name of card holder
     driver.findElement(By.id("PAYMENT_nameOnCard")).sendKeys("Mouni Roy");
     Thread.sleep(2000);
     
     Select month = new Select(driver.findElement(By.id("PAYMENT_expiryMonth")));
     month.selectByVisibleText("05");
     Thread.sleep(2000);
     Select year = new Select(driver.findElement(By.id("PAYMENT_expiryYear")));
     year.selectByVisibleText("2024");
     Thread.sleep(2000);
     driver.findElement(By.id("PAYMENT_cvv")).sendKeys("523");
     /*Thread.sleep(2000);
     Select country = new Select(driver.findElement(By.id("PAYMENT_billingCountry")));
     country.selectByVisibleText("India");
     Thread.sleep(2000);
     driver.findElement(By.id("PAYMENT_billingAddress")).sendKeys("Hyderabad");
     Thread.sleep(2000);
     driver.findElement(By.id("PAYMENT_billingCity")).sendKeys("Hyd");
     Thread.sleep(2000);
     driver.findElement(By.id("PAYMENT_billingPin")).sendKeys("512356");
     Thread.sleep(2000);
     driver.findElement(By.id("PAYMENT_billingState")).sendKeys("Telengana");*/
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"widgetPayBtn\"]/span")).click();
     Thread.sleep(2000);
     
     
     //Taking screenshot  of invalid payment details
     File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	 String imagePath=System.getProperty("user.dir")+"/screenshots/javaimagesearch.png";
 	 FileUtils.copyFile(screenshot, new File(imagePath));
 
}


@After
public static void close()
{
 driver.quit();	
}
}



