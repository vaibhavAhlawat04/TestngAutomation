package hoichoiAutomation;

import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScreenShot  extends BaseClass{

	public static void main(String[] args){
		BaseClass base = new BaseClass();
		base.setUp();
	}

	@Test
	public void ScreenShots() {
		WebDriverWait wait = new WebDriverWait(driver,120);

		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		driver.startActivity(act);

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));

			System.out.println(java.time.LocalTime.now());
			System.out.println("ScreenShots Test Started");
			File scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("MainPage.jpg"));
			scroll();


			driver.findElement(By.xpath("//*[@text='Discover']")).click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("Discover.jpg"));
			scroll();

			driver.findElement(By.xpath("//*[@text='Downloads']")).click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("Downloads.jpg"));
			scroll();

			driver.findElement(By.xpath("//*[@text='Upcoming']")).click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("FreePage.jpg"));
			scroll();

			driver.findElementByXPath("//*[@text='Account']").click();
			scrShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrShot, new File("MenuPage.jpg"));
	
		}catch(Exception exc) {
			exc.printStackTrace();
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
