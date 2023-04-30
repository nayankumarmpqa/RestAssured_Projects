package Resources;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDrivenPOI {

    public ArrayList<String> getExcelData() throws IOException {
        ArrayList<String> cellStrings = new ArrayList<>(); // Arraylist var to save excel cell values

        FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\APIFramework\\TestApachePOIFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheetscount = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetscount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("TestCaseSheet")) {
                XSSFSheet requiredSheet = workbook.getSheetAt(i);

                Iterator<Row> rowsIterator = requiredSheet.iterator(); // returns Iterator of rows
                Row firstRow = rowsIterator.next();

                // get Cell Iterator fo the first row
                Iterator<Cell> firstRowCellsIterator = firstRow.cellIterator();

                // now Iterate cells and compare string value using while loop
                int counter = 0;
                int columnNum = 0;

                while (firstRowCellsIterator.hasNext()) {
                    Cell nextCellInFirstRow = firstRowCellsIterator.next();
                    if (nextCellInFirstRow.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        columnNum = counter;
                    }
                    counter++;
                }
                System.out.println("column number is = " + columnNum);

                //in the identified column - Find required cell and its row number
                // using while loop

                while (rowsIterator.hasNext()) {
                    Row nextRow = rowsIterator.next();
                    if (nextRow.getCell(columnNum).getStringCellValue().equalsIgnoreCase("Purchase")) {
                        Iterator<Cell> cellIterator = nextRow.cellIterator();

                        while (cellIterator.hasNext()) {
                            //System.out.print(cellIterator.next().getStringCellValue() + " - ");
                            // above print statement will work if the values are string only

                            //Below code is used when the cells may have numeric values to fetch
                            Cell cellValue = cellIterator.next();
                            if (cellValue.getCellType() == CellType.STRING) {
                                cellStrings.add(cellValue.getStringCellValue());
                            } else {
                                cellStrings.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
                            }
                        }
                    }

                }
            }

        }
        return cellStrings;
    }


}
