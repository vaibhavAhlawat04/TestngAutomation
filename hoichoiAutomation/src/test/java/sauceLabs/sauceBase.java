package sauceLabs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class sauceBase {



	public AndroidDriver<MobileElement> driver = null;

	@BeforeClass
	public void setUp() {
		//	String Appid="d797da59-1a30-4267-8c83-a61025f56911";
		DesiredCapabilities dcap = new DesiredCapabilities();
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.16.0");
		caps.setCapability("deviceName","Samsung_Galaxy_S9_free");
		caps.setCapability("deviceOrientation", "portrait"); 
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion","10");
		caps.setCapability("platformName","Android");
		caps.setCapability("app","storage:filename=app_2.3.78_release_22-03-2021.apk");

		try {

			URL url =   new URL("https://vaibhav1804:c0d04d55-1d51-4ef1-a20b-dfd77895c33b@ondemand.us-west-1.saucelabs.com:443/wd/hub");

			driver = new AndroidDriver<>(url,dcap);
		}catch(MalformedURLException malUrl) {
			malUrl.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}//setUp




}
