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

public class HomePageModules extends BaseClass {

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}
	@Test
	public void Home_modules() {
		WebDriverWait wait = new WebDriverWait(driver,120);

		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		act.setAppWaitActivity(null);
		driver.startActivity(act);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		scroll();
		
		if(driver.findElementByXPath("//*[@text='Just Added']").isDisplayed()) System.out.println("Recent Added is visible");
		scroll();
		if(driver.findElementByXPath("//*[@text='Hoichoi Top 10']").isDisplayed()) System.out.println("Top 10 is visible");
		scroll();
		if(driver.findElementByXPath("").isDisplayed()) System.out.println("");
		


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
