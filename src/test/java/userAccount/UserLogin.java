package userAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ubuy.Ubuy_Checkout;

public class UserLogin{
	
	public WebDriver driver;
	
	@Test(priority = 2)
	public void login () throws Exception
	{
	
	Ubuy_Checkout ub = new Ubuy_Checkout();
	ub.captureScreenMethod();
	
	
	driver.findElement(By.xpath("//*[@id=\\\"search-form\\\"]/input")).sendKeys("jeans");
	//driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
	
	}
	

}
