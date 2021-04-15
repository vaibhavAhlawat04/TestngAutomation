package hoichoiAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DescriptionPage extends BaseClass {

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}
	
	@Test
	public void Description_Page() {
		WebDriverWait wait = new WebDriverWait(driver,120);
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		driver.startActivity(act);
		
		try {
			driver.findElementByAccessibilityId("Skip and Browse").click();
		}catch(Exception edddd) {
			System.out.println("User is not loggedIn!!!!");
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		
		scroll();
		
		driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[10]").click();
		
		try {
		driver.findElementByXPath("//android.view.ViewGroup/android.view.View/android.widget.ImageView[1]").isDisplayed();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Play Now']")));
		
		driver.findElementByXPath("//*[@text='Watchlist']").isDisplayed();
		driver.findElementByXPath("//*[@text='Like']").isDisplayed();
		driver.findElementByXPath("//*[@text='Play Trailer']").isDisplayed();
		driver.findElementByXPath("//*[@text='WhatsApp']").isDisplayed();
		driver.findElementByXPath("//*[@text='Share']").isDisplayed();
		System.out.println("All Elements are visible.");
		}catch(Exception es) {
		System.out.println("All Elements are not Visible!!!!!!");
		}
	}
	
	public void scroll(){
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(588,1418))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
		.moveTo(PointOption.point(588,742))
		.release()
		.perform();
	}

}
