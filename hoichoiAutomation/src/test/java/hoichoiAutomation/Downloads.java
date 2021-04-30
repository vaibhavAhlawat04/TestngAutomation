package hoichoiAutomation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Downloads extends BaseClass {
	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}

	@Test
	public void DownloadsTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,120);

		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		act.setAppWaitActivity(null);
		driver.startActivity(act);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		Thread.sleep(2000);
		
		driver.findElementByAccessibilityId("Downloads").click();
		
		if(driver.findElementByXPath("//*[@text='No Downloads Yet!']").isDisplayed()) {
			System.out.println("No Downloads Yet!!!!");
		}
		driver.findElementByAccessibilityId("Discover Movies & Shows").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		
		scroll();
		
		driver.findElementByXPath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[1]").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]")));
		//System.out.println(driver.findElement(By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]")).getText());
		
		List<String> DownloadList = new ArrayList<>();
		String StreamName = driver.findElementByXPath("//android.view.ViewGroup/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]").getText();
		DownloadList.add(StreamName);
		driver.findElementByAccessibilityId("Download").click();
		
		System.out.println("List is " + DownloadList);
		
		
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
