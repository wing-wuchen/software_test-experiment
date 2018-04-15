package hw3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read {

	public static Object[][] getTestData(String filePath) throws FileNotFoundException, IOException {
		File excelFile = new File(filePath);
		/*
		 * 判断给定文件的类型; 1.如果是xls的问价那类型就创建XSSFWorkBook ; 2.如果是xlsx的文件类型就创建HSSFWorkBook ;
		 */

		String xls = filePath.substring(filePath.indexOf('.'));
		//System.out.println("传入文件的后缀是：" + xls + " ;");
		if (xls.equals(".xls")) {
			
		} 
		else if (xls.equals(".xlsx")) {
			XSSFWorkbook wbxlsx = new XSSFWorkbook(new FileInputStream(excelFile));
			XSSFSheet sheet = wbxlsx.getSheetAt(0);

			int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			List<Object[]> list = new ArrayList<Object[]>();
			// System.out.println("---------该sheet总共有 ：" + rowcount + " ;");
			Row row;
			Cell cell;
			for (int i = 0; i < rowcount + 1; i++) {
				row = sheet.getRow(i);
				/*
				 * System.out.println("当前行是：" + (row.getRowNum() + 1) + " ;当前行的第一个单元格是：" +
				 * row.getFirstCellNum() + " ; 当前前的最后一个单元格是：" + row.getLastCellNum() + "; ");
				 */
				Object[] obj = new Object[row.getLastCellNum()];
				// System.out.println("obj 数组的长度是 ：" + obj.length + " ;");
				for (int j = 0; j < row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						obj[j] = cell.getRichStringCellValue().getString();
						/*
						 * System.out.print(cell.getRichStringCellValue(). getString());
						 * System.out.print("|");
						 */
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							obj[j] = cell.getDateCellValue();
							// System.out.print(String.valueOf(cell.getDateCellValue()));
						} else {
							obj[j] = cell.getNumericCellValue();
							// System.out.print(cell.getNumericCellValue());
						}
						// System.out.print("|");
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						obj[j] = cell.getBooleanCellValue();
						/*
						 * System.out.print(cell.getBooleanCellValue()); System.out.print("|");
						 */
						break;
					default:
					}

				}
				list.add(obj);
				System.out.println();
			}
			// System.out.println("list.size()===" + list.size());
			Object[][] object = new Object[list.size()][];
			for (int i = 0; i < object.length; i++) {
				object[i] = list.get(i);
			}
			return object;
		} else {
			System.out.println("指定的文件不是excle文件！");
		}
		return null;
	}
}
