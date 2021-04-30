package hoichoiAutomation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
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
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Welcome to Hoichoi']")));
		driver.findElementByXPath("//android.widget.Button[@content-desc=\"Skip and Browse\"]").click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		scroll();
		
		if(driver.findElementByXPath("//*[@text='Just Added']").isDisplayed()) System.out.println("Recent Added is visible");
		scroll();
		
		if(driver.findElementByXPath("//*[@text='hoichoi Top 10']").isDisplayed()) System.out.println("Top 10 is visible");
		scroll();
		
		if(driver.findElementByXPath("//*[@text='Trending']").isDisplayed()) System.out.println("Trending Displayed");
		scroll();
		
		if(driver.findElementByXPath("//*[@text='From Page to Screen']").isDisplayed()) System.out.println("From Page to Screen is visible");		
		scroll();
		if(driver.findElementByXPath("//*[@text='Underrated Gems']").isDisplayed()) System.out.println("UnderRated Gem is Visible");
		scroll();
		if(driver.findElementByXPath("//*[@text='Double the Fun']").isDisplayed()) System.out.println("Double the Fun is visible");
		scroll();
		if(driver.findElementByXPath("//*[@text='Offbeat Tales of Love']").isDisplayed()) System.out.println("Offbeat Tales of Love is visible");
		scroll();
		if(driver.findElementByXPath("//*[@text='The City of Joy']").isDisplayed()) System.out.println("The City of Joy is visible");
		scroll();

		
		if(driver.findElementByXPath("//*[@text='Friends Forever']").isDisplayed()) System.out.println("Friends Forever  is visible");
		scroll();	if(driver.findElementByXPath("//*[@text='Comedy Unlimited']").isDisplayed()) System.out.println("Comedy Unlimited is visible");
		
		//MoviesTab
		driver.findElementByXPath("//android.view.View[@content-desc=\"Movies, #Movies#\"]").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		scroll();
		
		driver.findElementByXPath("//*[@text='Just Added Movies']").isDisplayed(); System.out.println("JustAdded is Visible");
		scroll();
		scroll();
		driver.findElementByXPath("//*[@text='Once Upon A Time']").isDisplayed(); System.out.println("Once UPon a time is visible");
		scroll();
		driver.findElementByXPath("//*[@text='Movies to Remember']").isDisplayed(); System.out.println("Movies To Remember is visible");
		
		scroll();
		driver.findElementByXPath("//*[@text='Laughter Therapy']").isDisplayed(); System.out.println("Laughter therapy  is visible");
		scroll();
		
		driver.findElementByXPath("//*[@text='From Page To Screen']").isDisplayed(); System.out.println("From Page to Screen is Visible");
		
		
		System.out.println("\n Shows Tab");
		
		driver.findElementByXPath("//android.view.View[@content-desc=\"Shows, #Shows#\"]").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		scroll();
		
		driver.findElementByXPath("//[@text='Popular Series'").isDisplayed(); System.out.println("Popular series is visible");
		scroll();
		driver.findElementByXPath("//[@text='Trending Series'").isDisplayed(); System.out.println("Thriller series is visible");	
		scroll();
		scroll();
		
		driver.findElementByXPath("//[@text='Thriller Series'").isDisplayed(); System.out.println("Thriller series is visible");
		scroll();
		driver.findElementByXPath("//[@text='Horror Series'").isDisplayed(); System.out.println("Horror series is visible");	
		scroll();
		scroll();
		
		driver.findElementByXPath("//[@text='Comedy Series'").isDisplayed(); System.out.println("comedy series is visible");	
		scroll();
		driver.findElementByXPath("//[@text='Women centric Series'").isDisplayed(); System.out.println("Women centric series is visible");	
		scroll();
		driver.findElementByXPath("//[@text='Drama Series'").isDisplayed(); System.out.println("Drama series is visible");	
		scroll();
		driver.findElementByXPath("//[@text='Non-fiction Series'").isDisplayed(); System.out.println("Non-fiction series is visible");
		
		
		
	}
	
	public void scroll(){
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(588,1418))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
		.moveTo(PointOption.point(588,602))
		.release()
		.perform();
	}
	public void scrollTo(String text) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
	}

}
