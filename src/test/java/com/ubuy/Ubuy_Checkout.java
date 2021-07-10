package com.ubuy;
import static com.ubuy.Ubuy_Checkout.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import userAccount.UserLogin;

import com.google.inject.spi.Element;
public class Ubuy_Checkout extends Locaters {
	
	static WebDriver driver;
	
	
public static void text(String text,String locaters)
	
	{
		
		driver.findElement(By.xpath(locaters)).sendKeys(text);
	}
	
	public static void link_btn(String locaters)
	
	{
		
		driver.findElement(By.xpath(locaters)).click();
		
	}
	
	

	//static WebDriver driver;
	@Test(priority = 1)
	public  void captureScreenMethod() throws Exception {


		System.setProperty("webdriver.chrome.driver","/home/shailendra/eclipse-workspace/Ubuy/Drivers/chromedriver");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("window-size=1400,800");
		//op.addArguments("headless");
		driver = new ChromeDriver(op);

		FileInputStream file = new FileInputStream(new File("/home/shailendra/eclipse-workspace/Ubuy/CountriesURL.xlsx"));
		@SuppressWarnings("resource")
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.get(url);
			System.out.println(url);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
WebElement element5 = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(search)));

			element5.sendKeys("laptop");
			
		
			
			//driver.findElement(By.xpath(clickonsearchbutton)).click();
			
			link_btn(clickonsearchbutton);
			
			
			Thread.sleep(3000);
			link_btn(selectProducts);
			
			link_btn(addtocart);
			Thread.sleep(3000);
			
			String Parent_Window1 = driver.getWindowHandle(); for (String Child_Window1 : driver.getWindowHandles())
			
			{
				driver.switchTo().window(Child_Window1);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  WebElement element = driver.findElement(By.xpath(popup));
			 JavascriptExecutor executor = (JavascriptExecutor) driver;
			  executor.executeScript("arguments[0].click();", element); }
			driver.switchTo().window(Parent_Window1);
			
			
			
			link_btn(proceedtocheckout);
			
			link_btn(loginlink);
			
			
			String Parent_Window2 = driver.getWindowHandle(); for (String Child_Window2 : driver.getWindowHandles())
				
			{
				driver.switchTo().window(Child_Window2);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				WebElement ele=driver.findElement(By.xpath(email));
				
				ele.sendKeys("shailendra.singh@ubuy.co.in");
				
				WebElement ele2 = driver.findElement(By.xpath(password));
				
				ele2.sendKeys("testing1234");
				
				
			  WebElement element1 = driver.findElement(By.xpath(loginbtn));
			 JavascriptExecutor executor = (JavascriptExecutor) driver;
			  executor.executeScript("arguments[0].click();", element1); }
			driver.switchTo().window(Parent_Window2);
			
			
			
			
			
			/*
			 * System.out.println("Search Products LAPTOP");
			 * 
			 * webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 * webDriver.findElement(By.xpath(SelectProducts)).click();
			 * System.out.println("Select products"); String st = webDriver.getCurrentUrl();
			 * System.out.println(i + " " + st); Thread.sleep(2000); //
			 * webDriver.navigate().refresh(); WebElement element1 = (new
			 * WebDriverWait(webDriver, 20))
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(AddToCart)));
			 * element1.click(); webDriver.manage().timeouts().implicitlyWait(5,
			 * TimeUnit.SECONDS); System.out.println("Click on Add to Cart Button"); String
			 * Parent_Window1 = webDriver.getWindowHandle(); for (String Child_Window1 :
			 * webDriver.getWindowHandles()) { webDriver.switchTo().window(Child_Window1);
			 * webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 * WebElement element = webDriver.findElement(By.xpath(PopUp));
			 * JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			 * executor.executeScript("arguments[0].click();", element); }
			 * webDriver.switchTo().window(Parent_Window1);
			 * webDriver.findElement(By.xpath(ProceedToCheckOut)).click();
			 * webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 * System.out.println("Click on proceed to checkout button"); //
			 * logger.info("click on Proceed To CheckOut button");
			 * webDriver.findElement(By.xpath(UserName)).sendKeys(
			 * "shailendra.singh@ubuy.co.in"); System.out.println("Enter USerName");
			 * webDriver.findElement(By.xpath(Password)).sendKeys("123456");
			 * System.out.println("Enter Password"); // //
			 * logger.info("Enter user login detail");
			 * webDriver.findElement(By.xpath(LoginButton)).click();
			 * System.out.println("Click on Login button"); Thread.sleep(4000);
			 * webDriver.findElement(By.xpath(NewAdress)).click();
			 * webDriver.findElement(By.xpath(FirstNAme)).sendKeys("shailendra");
			 * System.out.println("Enter First Name");
			 * webDriver.findElement(By.xpath(LAstName)).sendKeys("singh");
			 * System.out.println("Enter Last Name");
			 * webDriver.findElement(By.xpath(TelephoneNumber)).sendKeys("1234567802");
			 * System.out.println("Enter Telephone number"); String billingregion = State;
			 * System.out.println("Select State"); String billingcity = state1; Boolean
			 * is_billingcity = false; WebElement ele1; try { ele1 =
			 * webDriver.findElement(By.xpath(billingregion)); } catch (Exception e) { ele1
			 * = webDriver.findElement(By.xpath(billingcity)); is_billingcity = true; } if
			 * (ele1.isEnabled()) { if (is_billingcity) { Select city1 = new Select(ele1);
			 * city1.selectByIndex(3); } else { Select city2 = new Select(ele1);
			 * city2.selectByIndex(3); } } String input_city =
			 * "//input[@id='billing:city']"; String select_city =
			 * "//select[@id='billing:city']"; Boolean is_select = false; WebElement ele;
			 * try { ele = webDriver.findElement(By.xpath(input_city)); } catch (Exception
			 * e) { ele = webDriver.findElement(By.xpath(select_city)); is_select = true; }
			 * if (ele.isEnabled()) { if (is_select) { Select cityfromdrop = new
			 * Select(ele); cityfromdrop.selectByIndex(2); } else { ele.sendKeys("2589566");
			 * } } webDriver.findElement(By.xpath(House)).sendKeys("ElecTronicMarket");
			 * webDriver.findElement(By.xpath(Street)).sendKeys("Ridhi Sidhi"); try { if
			 * (webDriver.findElement(By.xpath("//input[@id='billing:address_block']")).
			 * isEnabled()) {
			 * webDriver.findElement(By.xpath("//input[@id='billing:address_block']")).
			 * sendKeys("T block"); } } catch (Exception e) { } try { if
			 * (webDriver.findElement(By.xpath("//input[@id='billing:address_appartment']"))
			 * .isEnabled()) {
			 * webDriver.findElement(By.xpath("//input[@id='billing:address_appartment']"))
			 * .sendKeys("Qatar AppartMent"); } } catch (Exception e) { } try { if
			 * (webDriver.findElement(By.xpath("//input[@id='billing:address_avenue']")).
			 * isEnabled()) {
			 * webDriver.findElement(By.xpath("//input[@id='billing:address_avenue']")).
			 * sendKeys("Qatar Avenue"); } } catch (Exception e) { } // Jordan try { if
			 * (webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).isEnabled
			 * ()) {
			 * webDriver.findElement(By.xpath("//input[@id='billing:idnumber']")).sendKeys(
			 * "12569857"); } } catch (Exception e) { } try { if
			 * (webDriver.findElement(By.xpath(Zip)).isEnabled()) {
			 * webDriver.findElement(By.xpath(Zip)).sendKeys("5454545454"); } } catch
			 * (Exception e) { } webDriver.findElement(By.xpath(ContinueButton)).click();
			 * Thread.sleep(4000); webDriver.findElement(By.xpath(ShippingSelect)).click();
			 * System.out.println("Select Shipping method");
			 * webDriver.findElement(By.xpath(ContinueFromShipping)).click();
			 * System.out.println("Click on continue button"); Thread.sleep(4000); //
			 * logger.info("Enter all mandatory field in address page");
			 * webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 * WebElement element2 = webDriver .findElement(By.
			 * xpath("//*[@id='p_method_cybersecure' and @name='payment[method]']"));
			 * JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			 * executor.executeScript("arguments[0].click();", element2); Select Card = new
			 * Select(webDriver.findElement(By.xpath(CardType))); Card.selectByIndex(2);
			 * System.out.println("Select Card type"); // logger.info("Select card type ");
			 * webDriver.findElement(By.xpath(CardNumber)).sendKeys("5105105105105100");
			 * System.out.println("Enter Card number"); Select ExpiryDate = new
			 * Select(webDriver.findElement(By.xpath(ExpiryMonth)));
			 * ExpiryDate.selectByVisibleText("03 - March");
			 * System.out.println("Select Expiry month"); Select ExpiryDateYear = new
			 * Select(webDriver.findElement(By.xpath(ExpiryYear)));
			 * ExpiryDateYear.selectByVisibleText("2023");
			 * System.out.println("Select Expiry Year");
			 * webDriver.findElement(By.xpath(CardVerificationNumber)).sendKeys("123");
			 * System.out.println("enter CVV number");
			 * webDriver.findElement(By.xpath(ContinueFromPaymentOption)).click(); // //
			 * logger.info("click on place order button");
			 * System.out.println("Click on Continue Button"); Thread.sleep(5000);
			 * webDriver.findElement(By.xpath(PlaceOrderFinal)).click();
			 * System.out.println("Place orders");
			 * System.out.println("-------------------------------------------------------")
			 * ;
			 */
		}
	}
}
/*
 * @AfterMethod // AfterMethod annotation - This method executes after every
 * test execution public void screenShot(ITestResult result) { if
 * (ITestResult.FAILURE == result.getStatus()) { System.out.println("here 1");
 * try { System.out.println("here 2"); TakesScreenshot screenshot =
 * (TakesScreenshot) webDriver; System.out.println("here 3");
 * 
 * @SuppressWarnings("unused") File src =
 * screenshot.getScreenshotAs(OutputType.FILE); File file = ((TakesScreenshot)
 * webDriver).getScreenshotAs(OutputType.FILE); System.out.println("here 4");
 * FileUtils.copyFile(file, new File(
 * "/home/shailendra/my all data/My Data/NewWorkSpace-20200306T055832Z-001/NewWorkSpace/UBUY_WorkSpace/UBUY_Checkout/screenshot.png"
 * )); System.out.println("Successfully captured a screenshot"); EmailAttachment
 * attachment = new EmailAttachment(); attachment.setPath(
 * "/home/shailendra/my all data/My Data/NewWorkSpace-20200306T055832Z-001/NewWorkSpace/UBUY_WorkSpace/UBUY_Checkout/screenshot.png"
 * ); attachment.setDisposition(EmailAttachment.ATTACHMENT);
 * attachment.setDescription("Error"); attachment.setName("ErrorImage");
 * attachment.getURL(); // Create the email message MultiPartEmail email = new
 * MultiPartEmail(); email.setHostName("smtp.gmail.com");
 * email.setSmtpPort(465); email.setAuthenticator(new
 * DefaultAuthenticator("Shailendra1707198912@gmail.com", "testing123ubuy"));
 * email.setSSLOnConnect(true); email.setFrom("Shailendra1707198912@gmail.com");
 * email.setSubject("Error in Sites"); email.setMsg("Website Error");
 * email.addTo("shailendra.singh@ubuy.com"); email.attach(attachment);
 * email.send(); System.out.println("Mail sent succesfully"); } catch (Exception
 * e) { System.out.println("Exception while taking screenshot " +
 * e.getMessage()); } } webDriver.quit(); }
 */