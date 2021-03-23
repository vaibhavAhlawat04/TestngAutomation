package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadData {
	public static List<String> Data() throws IOException{
		List<String> numbers = new ArrayList<>();

		File file = new File(System.getProperty("user.dir")+"/TestData/testData.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wrkBk = new XSSFWorkbook(fis);
		XSSFSheet sheet = wrkBk.getSheetAt(0);
		DataFormatter formater = new DataFormatter();
		//number[0] = formater.formatCellValue(sheet.getRow(2).getCell(0));

		Iterator<Row> itr = sheet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			Cell cell = row.getCell(0);
			if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
				numbers.add(formater.formatCellValue(cell));
				//System.out.println(formater.formatCellValue(cell));
			}
		}
		wrkBk.close();
		return numbers;
	}

}
