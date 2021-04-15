package Report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

public class TestResult {
	
	private static HashMap<String,String> tests = new HashMap<String,String>();
	private static HashMap<String,String> testException = new HashMap<String,String>();
	
	
	public HashMap<String, String> getTestException() {
		return testException;
	}

	public void setTestException(HashMap<String, String> testException) {
		this.testException = testException;
	}

	public HashMap<String, String> getTests() {
		return tests;
	}

	public void setTests(HashMap<String, String> tests) {
		TestResult.tests = tests;
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String location = System.getProperty("user.dir")+"/test-output/testng-results.xml";
		File resultFile = new File(location);
		
		if(resultFile.exists()) {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			xmlHandler handler = new xmlHandler();
			parser.parse(resultFile, handler);
		}
		TestResult result = new TestResult();
		//System.out.println(result.getTests());
		//System.out.println(result.getTestException());
		
		Map<String,Object[]> data = new TreeMap<String,Object[]>();
		data.put("0", new Object[] {"Test Case","Status","Exception Message"});
		
		
		//Writing to Excel Sheet
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(" Tests Result ");
		XSSFRow row ;
		
		Object[] resultName = result.getTests().keySet().toArray();
		Object[] resultStatus=result.getTests().values().toArray();
		for(int i=0;i<resultName.length;i++) {
			String name= resultName[i].toString();
			String status=resultStatus[i].toString();
			String Exception = result.getTestException().get(resultName[i]);
		
			if(Exception==null)
			data.put(Integer.toString(i+1), new Object[] {name,status} );
			else
				data.put(Integer.toString(i+1),new Object[] {name,status,Exception});
		}
		
		
		
		
		Set<String> keyid = data.keySet();
		int rowid =0;
		
		for(String key:keyid) {
			System.out.println(data.get(key).toString());
		}
		
		
		
		
		for(String key : keyid) {
			row= sheet.createRow(rowid++);
			
			Object[] objectArr = data.get(key);
			int cellid=0;
			
			for(Object obj:objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue(obj.toString());
			}			
		}
		
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/TestResult.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Result File Created");
		
		
		
		
		
		
		
		

	}

}
