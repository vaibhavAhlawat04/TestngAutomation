package hoichoiAutomation_NonUser;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import hoichoiAutomation.BaseClass;
import io.appium.java_client.android.Activity;
import io.appium.java_client.serverevents.CommandEvent;
import io.appium.java_client.serverevents.ServerEvents;

public class LoadTime extends BaseClass {

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.setUp();
	}

	@Test
	public void LoadTimeTest() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,120);

		Activity act = new Activity("com.viewlift.hoichoi","com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		act.setAppWaitActivity(null);
		driver.startActivity(act);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Welcome to Hoichoi']")));
		
		ServerEvents evnts = driver.getEvents();
		
		List<CommandEvent> cmds = evnts.getCommands();
		//System.out.println(cmds);
		Optional<CommandEvent> startActCmd = cmds.stream()
				.filter((cmd)-> cmd.getName().equals("startActivity"))
				.findFirst();
		
		Optional<CommandEvent> findCmd = cmds.stream()
				.filter((cmd)-> cmd.getName().equals("findElement"))
				.findFirst();
		
		if(!startActCmd.isPresent() || !findCmd.isPresent()) {
			throw new Exception("could not determine start or end time of app launch");
		}
		
		long launchMs= startActCmd.get().endTimestamp - startActCmd.get().startTimestamp;
		long interactMs = findCmd.get().endTimestamp - findCmd.get().startTimestamp;
		
		System.out.println("\n The app took total <" + (launchMs/1000.0) + "s to launch" +
		" and total <" + (interactMs/1000.0) + "s to become interactable");
	}

}
