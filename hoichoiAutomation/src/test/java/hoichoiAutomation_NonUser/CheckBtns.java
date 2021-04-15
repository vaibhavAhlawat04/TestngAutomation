package hoichoiAutomation_NonUser;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import hoichoiAutomation.BaseClass;
import io.appium.java_client.android.Activity;

public class CheckBtns extends BaseClass {

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}

	@Test
	public void testAllBtns() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,120);

		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		act.setAppWaitActivity(null);
		driver.startActivity(act);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Welcome to Hoichoi']")));
		driver.findElementByAccessibilityId("Skip and Browse").click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		Thread.sleep(2000);

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
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("Close web view").click();
		driver.findElementByXPath("//android.view.View[@content-desc=\"FAQ\"]").click();
		driver.findElementByAccessibilityId("Navigate up").click();	
	}
}
