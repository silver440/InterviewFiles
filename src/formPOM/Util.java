package formPOM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.logging.NeedsLocalLogs;
import formPOM.UserInfo;
public class Util {
	public static List<UserInfo>readInfoFromExcell(String  fn) throws IOException{
		FileInputStream fr=new FileInputStream(fn);
		XSSFWorkbook workbook = new XSSFWorkbook(fr);
		XSSFSheet sh1 = workbook.getSheetAt(0);
		List<UserInfo> usrList=new ArrayList<UserInfo>();
//		UsrInfo curUsr = new UsrInfo();
		int rowCnt = sh1.getPhysicalNumberOfRows();
		for (int i = 1; i < rowCnt; i++) {
			Row curRow = sh1.getRow(i);
			
			UserInfo curUsr=new UserInfo();
			DataFormatter formatter = new DataFormatter();
			// int infoCnt=curRow.getPhysicalNumberOfCells();
			curUsr.setFrstName(curRow.getCell(0).getStringCellValue());// firstname
			curUsr.setLstName(curRow.getCell(1).getStringCellValue()); // lastname
			curUsr.setEmail(curRow.getCell(2).getStringCellValue());// email
			curUsr.setGender(curRow.getCell(3).getStringCellValue());// gender
			// curUsr.setMobile(curRow.getCell(4).getStringCellValue());//mobile
			curUsr.setMobile(formatter.formatCellValue(curRow.getCell(4)));
			// curUsr.setDOB(curRow.getCell(5).getStringCellValue());//DOB

			String birthday = formatter.formatCellValue(curRow.getCell(5));
			curUsr.setDOB(birthday);
			curUsr.setSubject(curRow.getCell(6).getStringCellValue());
			curUsr.setHobbies(curRow.getCell(7).getStringCellValue());
			curUsr.setPicLoc(curRow.getCell(8).getStringCellValue());
			curUsr.setAddr(curRow.getCell(9).getStringCellValue());
			curUsr.setState(curRow.getCell(10).getStringCellValue());
			curUsr.setCity(curRow.getCell(11).getStringCellValue());
			
			usrList.add(curUsr);
	}
	
	return usrList;

}
}