package in.source.country;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {

	public static void main(String[] args) {

		국가데이터();

	}

	private static void 국가데이터() {
		
		System.out.println("start");
		
		try {
			
			// 파일을 읽기위해 엑셀파일을 가져온다
			File f = new File("data\\국가.xls");
			FileInputStream fis = new FileInputStream(f);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			int rowindex = 0;
			int columnindex = 0;
			// 시트 수 (첫번째에만 존재하므로 0을 준다)
			// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
			HSSFSheet sheet = workbook.getSheetAt(2);
			// 행의 수
			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println("행수 : " + rows);
			for (rowindex = 4; rowindex < 11; rowindex++) {
				// 행을 읽는다
				HSSFRow row = sheet.getRow(rowindex);
				if (row != null) {
					// 셀의 수
					int cells = row.getPhysicalNumberOfCells();
					for (columnindex = 1; columnindex <= 6; columnindex++) {
						// 셀값을 읽는다
						HSSFCell cell = row.getCell(columnindex);
						String value = "";
						// 셀이 빈값일경우를 위한 널체크
						if (cell == null) {
							continue;
						} else {
							// 타입별로 내용 읽기
							switch (cell.getCellType()) {
							case HSSFCell.CELL_TYPE_FORMULA:
								value = cell.getCellFormula();
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								value = cell.getNumericCellValue() + "";
								break;
							case HSSFCell.CELL_TYPE_STRING:
								value = cell.getStringCellValue() + "";
								break;
							case HSSFCell.CELL_TYPE_BLANK:
								value = cell.getBooleanCellValue() + "";
								break;
							case HSSFCell.CELL_TYPE_ERROR:
								value = cell.getErrorCellValue() + "";
								break;
							}
						}
						System.out.println("각 셀 내용 :" + value);
					}
					System.out.println();
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println("end");
		
		


	}

}
