package GenericTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.serverevents.CommandEvent;
import io.appium.java_client.serverevents.ServerEvents;

public class MainClass {
	public AndroidDriver<MobileElement> driver = null;

	@BeforeClass
	public void setup() {
		System.out.println("In Setup");
		DesiredCapabilities dcap = new DesiredCapabilities();


		dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy J7 Prime");
		dcap.setCapability("udid", "52032bb1419b1401");
		//dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dcap.setCapability("platformName", "android");
		dcap.setCapability("platformVersion", "8.1.0");
		dcap.setCapability("automationName", "UiAutomator2");
		dcap.setCapability("app","/home/vaibhav/Documents/Apks/old.apk");
		//dcap.setCapability("appPackage", "com.viewlift.hoichoi");
		//dcap.setCapability("appActivity", "com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		dcap.setCapability("autoLaunch", false);
		dcap.setCapability("eventTimings", true);
		dcap.setCapability("clearDeviceLogsOnStart", true);
		try {
			URL url = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver<>(url,dcap);
		}catch(MalformedURLException malUrl) {
			malUrl.printStackTrace();
		}

		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void LaunchApp() throws InterruptedException {
		
		System.out.println("This is Launch Test");
		driver.launchApp();
		
		Thread.sleep(5000);
		
	}
	
	@Test
	public void LaunchTime() throws Exception {
		System.out.println("This is Launch Time Test");
		ServerEvents evnts = driver.getEvents();

		List<CommandEvent> cmds = evnts.getCommands();
		
		Optional<CommandEvent> launchCmd = cmds.stream()
				.filter((cmd)-> cmd.getName().equals("launchApp"))
				.findFirst();
		
		if(!launchCmd.isPresent()) {
			throw new Exception("could not determine start or end time of app launch");
		}
		
		long launchMs= launchCmd.get().endTimestamp - launchCmd.get().startTimestamp;
		System.out.println("\n The app took total <" + (launchMs/1000.0) + "s to launch");
	}

}
