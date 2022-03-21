package APOI;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

public class PoiCalendarExemple {
    public static void main(String[] args) {
        //Workbook wb = new HSSFWorkbook();
        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);

        // Create a cell and put a date value in it.  The first cell is not styled
        // as a date.
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());

        // we style the second cell as a date (and time).  It is important to
        // create a new cell style from the workbook otherwise you can end up
        // modifying the built in style and effecting not only this cell but other cells.
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/dd/yyyy h:mm"));
        cell = row.createCell(1);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);

        //you can also set date as java.util.Calendar
        cell = row.createCell(2);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cellStyle);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue(1.1);
        row2.createCell(1).setCellValue(new Date());
        row2.createCell(2).setCellValue(Calendar.getInstance());
        row2.createCell(3).setCellValue("a string");
        row2.createCell(4).setCellValue(true);
//        row2.createCell(5).setCellType(CellType.ERROR);

        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream("workbookCalendar2022.xlsx")) {
            wb.write(fileOut);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace()
            ;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
