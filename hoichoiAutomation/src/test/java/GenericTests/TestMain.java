package GenericTests;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestMain {

	public static void main(String[] args) {
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add(System.getProperty("user.dir")+"/testng.xml");
			testng.setTestSuites(suites);
			System.out.println("XmlSuite location:  " +System.getProperty("user.dir")+"/testng.xml");
			System.out.println("Starting Testing...");
			testng.run();
		
	}

}
