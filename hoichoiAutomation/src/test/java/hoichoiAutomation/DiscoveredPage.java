package hoichoiAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;

public class DiscoveredPage extends BaseClass {

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}

	@Test
	public void DiscoveredPageTest() {
		WebDriverWait wait = new WebDriverWait(driver,60);

		try {
			Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
			driver.startActivity(act);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));

			driver.findElementByXPath("//*[@text='Discover']").click();

			List<MobileElement> DiscPage= 	driver.findElementsByClassName("android.view.View");

			System.out.println(DiscPage.get(1).getText());
			//DiscPage.get(1).click();
			
			DiscPage.get(1).sendKeys("vaibhav");
			
			
			//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View[2]")).sendKeys("abac");


		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
