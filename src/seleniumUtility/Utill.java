package seleniumUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.aggregates.CustomViewSettingsRecordAggregate;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import seleniumTest.userInfo;

 public   class Utill {
//public static 	userInfo readInfoFromExcell(String fn) throws IOException {
     public static List<userInfo> readInfoFromExcell(String fn)throws Exception{
    	 
	 DataFormatter dFormatter=new DataFormatter();
		 FileInputStream fr= new FileInputStream(fn);
		XSSFWorkbook book=new XSSFWorkbook(fr);
		XSSFSheet  sh1=book.getSheetAt(0);
	//add different code order to get more rows from excell
		List<userInfo> userList=new ArrayList<userInfo>();
		int rowCnt=sh1.getPhysicalNumberOfRows();
		for(int i=1; i<rowCnt;i++) {
			Row currenRow=sh1.getRow(i);
	
//		Row currenRow=sh1.getRow(1);
		  userInfo curUserInfo=new userInfo();
	//	  int infoCount=currenRow.getPhysicalNumberOfCells();
		  	
		  curUserInfo.setFrsName(currenRow.getCell(0).getStringCellValue());
		  curUserInfo.setLstNname(currenRow.getCell(1).getStringCellValue());
		  curUserInfo.setEmail(currenRow.getCell(2).getStringCellValue());
		  curUserInfo.setGender(currenRow.getCell(3).getStringCellValue());
	//	  curUserInfo.setMobile(currenRow.getCell(4).getStringCellValue());
		  curUserInfo.setMobile(dFormatter.formatCellValue(currenRow.getCell(4)));
	//	  curUserInfo.setDob(currenRow.getCell(5).getStringCellValue());
		  String birthday=dFormatter.formatCellValue(currenRow.getCell(5));
		  curUserInfo.setDob(birthday);
		  curUserInfo.setSubject(currenRow.getCell(6).getStringCellValue());
		  curUserInfo.setHobbies(currenRow.getCell(7).getStringCellValue());
		  curUserInfo.setPicLoad(currenRow.getCell(8).getStringCellValue());
		  curUserInfo.setAddress(currenRow.getCell(9).getStringCellValue());
		  curUserInfo.setState(currenRow.getCell(10).getStringCellValue());
		  curUserInfo.setCity(currenRow.getCell(11).getStringCellValue());
		  userList.add(curUserInfo);
		} 
		 // return curUserInfo;
		return userList;
		  
		  
			  
		  
		
		
		
		
		
	}

}
