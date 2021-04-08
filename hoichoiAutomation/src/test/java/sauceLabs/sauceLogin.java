package sauceLabs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dataDriven.ReadData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;

public class sauceLogin extends sauceBase{

	public static void main(String[] args) {
		sauceBase base = new sauceBase();
		base.setUp();
	
		
	}
	@Test
	public void loginTest() {
		System.out.println("LoginTest begins...");
		WebDriverWait wait = new WebDriverWait(driver,0);

		//Starting App 
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.mobile.AppCMSLaunchActivity");
		driver.startActivity(act);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Welcome to Hoichoi']")));

		driver.findElement(By.xpath("//*[@text='Login']")).click();
		MobileElement els5 = driver.findElementByClassName("android.widget.EditText");

		try {
			for(int i=0;i<ReadData.Data().size();i++) {
				String number = ReadData.Data().get(i).toString();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				els5.clear();
				els5.sendKeys(number);
				driver.findElement(By.xpath("//*[@text='Continue']")).click();
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

//curl -u <vaibhav1804>:<c0d04d55-1d51-4ef1-a20b-dfd77895c33b>
//https://saucelabs.com/rest/v1/storage/<vaibhav1804>






