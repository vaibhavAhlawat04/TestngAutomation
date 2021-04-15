package hoichoiAutomation;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MatchGenres extends BaseClass{

	public static void main(String[] args) {
	BaseClass base = new BaseClass();
	base.setUp();

	}

	
	@Test
	public void GenresTest() {
		WebDriverWait wait = new WebDriverWait(driver,120);
		
		try {
			System.out.println("Starting Genres Test...");
			Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
			driver.startActivity(act);
			
			try {
				MobileElement el = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Skip and Browse\"]"));
				el.click();
			}catch(Exception exc) {
				System.out.println("User is Logged In");
			}
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
			
			driver.findElementByAccessibilityId("Genre").click();
			
			String[] Genres= {"Family","Action","Drama","Comedy","Horror","US","British","Asian","Indian","Reality and Talk", "Holiday"};
			
			List<MobileElement> GenreList= new ArrayList<>();
			
			//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View"));
			
			
			scroll();
			GenreList = driver.findElementsByClassName("android.view.View");
			for(MobileElement genre: GenreList) {
				System.out.println(genre.getText());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scroll(){  
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(888,1418))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
		.moveTo(PointOption.point(888,742))
		.release()
		.perform();
	}
}
