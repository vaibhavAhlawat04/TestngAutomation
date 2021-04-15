package hoichoiAutomation;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.serverevents.CommandEvent;
import io.appium.java_client.serverevents.ServerEvents;

public class HomePage extends BaseClass{

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}

	@Test
	public void HomePageTest() {
		WebDriverWait wait = new WebDriverWait(driver,120);

		System.out.println("HomePageTest begins...");
		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		driver.startActivity(act);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));

		//If logged in
		driver.findElementByXPath("//android.view.View[@content-desc=\"Movies, #Movies#\"]").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));

		driver.findElementByXPath("//android.view.View[@content-desc=\"Shows, #Shows#\"]").click();;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));
		
		driver.findElementByXPath("//android.view.View[@content-desc=\"Free, #Free#\"]").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.widget.ImageView[3]")));

		
		
		
		driver.findElement(By.xpath("//*[@text='Genre']")).click();
		/*
		List<MobileElement> genreList = driver.findElementsByClassName("android.view.View");
		for(int i=0;i<genreList.size();i++) {
			System.out.println(i+1 + " " + genreList.get(i).getText());
		}*/
	}
}
