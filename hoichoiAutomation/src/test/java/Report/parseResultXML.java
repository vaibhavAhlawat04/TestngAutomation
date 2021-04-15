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

public class parseResultXML {
	private static HashMap<String,String> tests = new HashMap<String,String>();
	
	public HashMap<String, String> getTests() {
		return tests;
	}

	public void setTests(HashMap<String, String> tests) {
		this.tests = tests;
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		int passedTests=0,skippedTests=0,failedTests=0,totalTests=0;
		
		
		String location = System.getProperty("user.dir")+"/test-output/testng-results.xml";
		File file = new File(location);
		
		if(file.exists()) {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			xmlHandler handler = new xmlHandler();
			parser.parse(file, handler);
		}
		parseResultXML result = new parseResultXML();
		
		System.out.println(result.getTests());
		totalTests=result.getTests().size();
		for(String i : result.getTests().keySet()) {
			if(result.getTests().get(i).equalsIgnoreCase("skip")) {
				skippedTests++;
			}
			if(result.getTests().get(i).equalsIgnoreCase("Pass")) {
				passedTests++;
			}
			if(result.getTests().get(i).equalsIgnoreCase("Fail")) {
				failedTests++;
			}
		}
		System.out.println("Total Tests : " + totalTests);
		System.out.println("Passed Tests : " + passedTests);
		System.out.println("Failed Tests : " + failedTests);
		System.out.println("Skipped Tests : " + skippedTests);
		
	// Writing to excel File 
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(" Tests Result ");
		XSSFRow row ;
		
		Map<String,Object[]> data = new TreeMap<String,Object[]>();
		data.put("0", new Object[] {"Total Tests" , "Passed Tests" , "Failed Tests", "Skipped Tests"});
		data.put("1", new Object[] {totalTests, passedTests, failedTests, skippedTests});
		
		Set<String> keyid = data.keySet();
		int rowid =0;
		
		for(String key : keyid) {
			row= sheet.createRow(rowid++);
			Object[] objectArr = data.get(key);
			int cellid=0;
			
			for(Object obj:objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue(obj.toString());
			}			
		}
		
		FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"/ReportResult.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Result File Created");
		
		
	}

}

