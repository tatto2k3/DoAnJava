/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;


import javax.swing.JTable;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class prExcelExporter {
    public static void exportToExcel(JTable table, String[] title,String filePath) {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        
        int rowCount1 = title.length;
        int columnCount1 = model.getColumnCount();
        for(int i=0;i<title.length;i++) {
            System.out.println(title[i]);
        }    
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        try {
            
          
            Row sheetRow = sheet.createRow(0);
            for (int col = 0; col < columnCount; col++) {
                
                Cell cell = sheetRow.createCell(col);
                
                cell.setCellValue(title[col]);
                
            }
                   
            
            for (int row = 0; row < rowCount; row++) {
                sheetRow = sheet.createRow(row+1);
                for (int col = 0; col < columnCount; col++) {
                    Object value = model.getValueAt(row, col);
                    Cell cell = sheetRow.createCell(col);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                }
            }

            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            outputStream.close();
            

            System.out.println("Data exported successfully to Excel file.");
        } catch (IOException e) {
            System.out.println("Error exporting data to Excel file: " + e.getMessage());
        }
    }
}
