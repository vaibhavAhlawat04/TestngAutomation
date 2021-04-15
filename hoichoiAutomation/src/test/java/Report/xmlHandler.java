package Report;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class xmlHandler extends DefaultHandler {
	parseResultXML resultxml=new parseResultXML();
	TestResult resultClass =new TestResult();
	HashMap<String,String> tests = new HashMap<String,String>();
	HashMap<String,String> testException = new HashMap<String,String>();
	String failTestName = null,exceptionName = null;


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{

		if(qName.equalsIgnoreCase("test-method")) {
			if(!attributes.getValue("name").equalsIgnoreCase("setUp")) {
				tests.put(attributes.getValue("name"),attributes.getValue("status"));
				resultxml.setTests(tests);
				resultClass.setTests(tests);

				if(attributes.getValue("status").equalsIgnoreCase("fail")) {
					//System.out.println("Failed Test is " +attributes.getValue("name"));
					failTestName=attributes.getValue("name");
				}

			}
		}
		if(qName.equalsIgnoreCase("exception")) {
			exceptionName=attributes.getValue("class");
			//System.out.println("Exception is :: " + exceptionName);
		}
		if(failTestName!=null&&exceptionName!=null) {
			testException.put(failTestName, exceptionName);
			resultClass.setTestException(testException);
			failTestName = null;
			//System.out.println(testException);
		}
	}//startElement


}
