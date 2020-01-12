package testVagrant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcelClass {

	private static Workbook wb;
	static Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();
	static Map<String, String> dataMap = new HashMap<String, String>();

	public static Map<String, Map<String, String>> setMapData(String newspaper) throws IOException {
		String currentUsersHomeDir = System.getProperty("user.dir");
		String path = currentUsersHomeDir+"\\resource\\TestVagrant Newspaper Cost.xlsx";
		FileInputStream fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		// gets the row of the particular newspaper
		int rowOfNewsPaper = calNewsPaperRow(path, newspaper);
		for (int j = 1; j <= noOfColumns - 1; j++) {
			Row row1 = sheet.getRow(rowOfNewsPaper);
			Cell keyCell1 = sheet.getRow(0).getCell(j);
			Cell valueCell = row1.getCell(j);
			String value = valueCell.getStringCellValue().trim();
			String key1 = keyCell1.getStringCellValue().trim();
			// Putting key & value in dataMap
			dataMap.put(key1, value);
			// Putting dataMap to excelFileMap
			excelFileMap.put("DataSheet", dataMap);
		}
		return excelFileMap;
	}

	public static Map<String, String> getMapData(String key) throws IOException {

		Map<String, String> m = setMapData(key).get("DataSheet");
		/*
		 * System.out.println(m); String value = m.get(key);
		 */
		return m;
	}

	public static int calNewsPaperRow(String path, String newspaper) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		int i;
		for (i = 0; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			Cell keyCell = row.getCell(0);
			String key = keyCell.getStringCellValue().trim();
			if (key.equals(newspaper)) {
				break;
			}
		}
		wb.close();
		return i;
	}
}
