package dataDriven;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import hoichoiAutomation.BaseClass;
import io.appium.java_client.MobileElement;

public class LoginTest extends BaseClass {
	public static void main(String[] args) throws IOException {
		BaseClass base = new BaseClass();
		base.setUp();
	}

	/*
	 * @AfterTest public void End() { driver.quit(); }
	 */
	@Test
	public void loginTest() {
		System.out.println("LoginTest begins...");
		WebDriverWait wait = new WebDriverWait(driver,0);

		//Starting App 
		//Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.mobile.AppCMSLaunchActivity");
		//driver.startActivity(act);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Welcome to Hoichoi']")));
		
		driver.findElement(By.xpath("//*[@text='Login']")).click();
	    MobileElement els5 = driver.findElementByClassName("android.widget.EditText");
		
		try {
			for(int i=0;i<ReadData.Data().size();i++) {
				String number = ReadData.Data().get(i).toString();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				els5.clear();
				els5.sendKeys(number);
				driver.findElement(By.xpath("//*[@text='Continue']")).click();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
