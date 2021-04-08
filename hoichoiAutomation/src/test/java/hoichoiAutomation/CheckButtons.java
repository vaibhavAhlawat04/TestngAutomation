package hoichoiAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class CheckButtons extends BaseClass {

	public static void main(String[] args) {
		
		BaseClass base = new BaseClass();
		base.setUp();
	}
	
	@Test
	public void ButtonTest() {
		WebDriverWait wait = new WebDriverWait(driver,120);
		
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		act.setAppWaitActivity(null);
		driver.startActivity(act);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		
		
		System.out.println("Testing Downloads Tab...");
		driver.findElementByXPath("//*[@text='Downloads']").click();
		
		driver.findElementByXPath("//android.view.View[@content-desc=\"Movies, #Movies#\"]").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"Shows, #Shows#\"]").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"Music, #Music#\"]").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"All, #All#\"]").click();
		
		driver.findElementByXPath("//android.view.ViewGroup/android.view.View/android.view.View[2]").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"Close\"]").click();
		
		driver.findElementByXPath("//android.view.View[@content-desc=\"Discover Movies & Shows\"]").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		
		
		
		System.out.println("Clicking Accounts...");
		
		driver.findElementByXPath("//android.view.View[@content-desc=\"Account\"]").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"About Hoichoi\"]").click();
		driver.findElementByAccessibilityId("Close tab").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"FAQ\"]").click();
		driver.navigate().back();
		
		
		
	}
}
