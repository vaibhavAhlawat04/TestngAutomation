package Report;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.common.excelreport.ExcelReportGenerator;
public class ExcelGenerate {
	public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException
	{			
	ExcelReportGenerator.generateExcelReport("ReportResult.xls",System.getProperty("user.dir"));
	}	
}
