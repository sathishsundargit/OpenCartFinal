package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider method will read the data from the Excel and store it in the two
	// dimenstional array.
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		// (.\\ represents the current project path. )

		String path = ".\\testData\\Opencart_LoginData.xlsx"; // taking xl file from testData.

		ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility

		int totalrows = xlutil.getRowCount("Sheet1"); // passing sheetname
		int totalcols = xlutil.getCellCount("Sheet1", 1); // 1 represents rownum

		String logindata[][] = new String[totalrows][totalcols]; // created for two dimensional array;

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				// [i-1] -- we dont want to waste the 0th index position in array
				// why we initializex i=1 means, we don't want the header
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // Row = 1 and Col =0
			}
		}
		return logindata; // returning two dimension array

	}

}
