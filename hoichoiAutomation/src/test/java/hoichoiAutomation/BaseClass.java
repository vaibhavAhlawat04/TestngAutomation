package hoichoiAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
public AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void setUp() {
		DesiredCapabilities dcap = new DesiredCapabilities();
		
		
		//dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy J7 Prime");
		//dcap.setCapability("udid", "52032bb1419b1401");
		dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dcap.setCapability("platformName", "android");
		dcap.setCapability("platformVersion", "8.1.0");
		dcap.setCapability("appPackage", "com.viewlift.hoichoi");
		dcap.setCapability("appActivity", "com.viewlift.hoichoi.framework.presentation.splash.SplashActivity");
		dcap.setCapability("autoLaunch", true);
		dcap.setCapability("eventTimings", true);
		dcap.setCapability("clearDeviceLogsOnStart", true);
		
		
		try {
			URL url = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver<>(url,dcap);
		}catch(MalformedURLException malUrl) {
			malUrl.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}//setUp
	

}
