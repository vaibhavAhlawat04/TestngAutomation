package hoichoiAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class Subscription extends BaseClass{

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}
	
	@Test
	public void subTest() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,120);
		
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		driver.startActivity(act);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		
		
		//Subscription
		System.out.println("Subscription starts...");
		driver.findElementByAccessibilityId("Account").click();
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"Subscribe Now\"]").click();
		System.out.println("Plans are Shown");
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"Continue with\"]").click();
	}

}
