package hoichoiAutomation;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.serverevents.CustomEvent;
import io.appium.java_client.serverevents.ServerEvents;
import io.appium.java_client.serverevents.TimedEvent;

public class GetTime extends BaseClass{

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}

	@Test
	public void Get_Time(){

		WebDriverWait wait = new WebDriverWait(driver,120);
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		driver.startActivity(act);

		CustomEvent evt = new CustomEvent();
		evt.setEventName("start");
		evt.setVendor("appium");
		driver.logEvent(evt);

		/*try {
			driver.findElementByAccessibilityId("Skip and Browse").click();
		}catch(Exception edddd) {
			System.out.println("User is not loggedIn!!!!");
		}*/

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		evt.setEventName("All");
		evt.setVendor("appium");
		driver.logEvent(evt);


		//If logged in
		driver.findElementByXPath("//android.view.View[@content-desc=\"Movies, #Movies#\"]").click();
		evt.setEventName("Movies_click");
		evt.setVendor("appium");
		driver.logEvent(evt);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		evt.setEventName("Movies");
		evt.setVendor("appium");
		driver.logEvent(evt);

		driver.findElementByXPath("//android.view.View[@content-desc=\"Shows, #Shows#\"]").click();
		evt.setEventName("Shows_click");
		evt.setVendor("appium");
		driver.logEvent(evt);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		evt.setEventName("Shows");
		evt.setVendor("appium");
		driver.logEvent(evt);

		driver.findElementByXPath("//android.view.View[@content-desc=\"Free, #Free#\"]").click();
		evt.setEventName("Free_click");
		evt.setVendor("appium");
		driver.logEvent(evt);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		evt.setEventName("Free");
		evt.setVendor("appium");
		driver.logEvent(evt);
		
		ServerEvents ents = driver.getEvents();
		System.out.println(ents);
		
		long AllTime=getTimeStamp("appium:All").get(0)-getTimeStamp("appium:start").get(0);
		
		long MoviesTime=getTimeStamp("appium:Movies").get(0)-getTimeStamp("appium:Movies_click").get(0);
		
		long ShowsTime=getTimeStamp("appium:Shows").get(0)-getTimeStamp("appium:Shows_click").get(0);

		long FreeTime = getTimeStamp("appium:Free").get(0)-getTimeStamp("appium:Free_click").get(0);

		System.out.println("All took " + (AllTime/1000.0) + "s");
		System.out.println("Movies took " + (MoviesTime/1000.0) + "s");
		System.out.println("Shows took " + (ShowsTime/1000.0) + "s");
		System.out.println("Free took " + (FreeTime/1000.0) + "s");
		//System.out.println("Time is ::" + (time/1000.0) + "s");


		//System.out.println("Time of First is Start" + findFirst.get().startTimestamp);
		//System.out.println("Time of First is End" + findFirst.get());

	}
	public List<Long> getTimeStamp(String name) {
		ServerEvents evnts = driver.getEvents();
		List<TimedEvent> timed = evnts.getEvents();
		Optional<TimedEvent> findFirst = timed.stream()
				.filter((evnt)-> evnt.getName().equals(name))
				.findFirst();
		return findFirst.get().occurrences;

	}
}
