package com.automation.supporters;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private String filepath;
	private FileInputStream fis;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String celldata;

	public ExcelReader(String filepath) throws IOException {
		this.filepath = filepath;
		fis = new FileInputStream(filepath);
		workbook = WorkbookFactory.create(fis);

	}

	public Sheet getsheetobj(String how, String value) {
		if (workbook != null) {
			if (how.equalsIgnoreCase("sheetname")) {
				sheet = workbook.getSheet(value);
			} else if (how.equalsIgnoreCase("index")) {
				int sheetindex = Integer.parseInt(value);
				sheet = workbook.getSheetAt(sheetindex);
			}
		}
		return sheet;
		

	}

	public String getsinglecellData(String how, String value,int rownum, int cellnum) {
	sheet=getsheetobj(how, value);
	
			if (sheet!=null) {
				 row=sheet.getRow(rownum);
				if (row!=null) {
					 cell=row.getCell(cellnum);
					if (cell!=null) {
						if (cell.getCellType()==CellType.STRING) {
							celldata=cell.getStringCellValue();
							
						}
						else if (cell.getCellType()==CellType.NUMERIC) {
							celldata=cell.getNumericCellValue()+"";
						
							
						}
						else if (cell.getCellType()==CellType.BOOLEAN) {
							celldata=cell.getBooleanCellValue()+"";
						}
						}
					}}
			return celldata;
	}

	public List< String> getSingleRowDate(String how, String value,int rownum) {
		List< String>rowdata=new ArrayList<>();
		sheet=getsheetobj(how, value);
		
		if (sheet!=null) {
			 row=sheet.getRow(rownum);
			if (row!=null) {
				for(int i=0;i<=row.getLastCellNum();i++) {
					cell=row.getCell(i);
					if (cell!=null) {
						if (cell.getCellType()==CellType.STRING) {
							celldata=cell.getStringCellValue();
							
						}
						else if (cell.getCellType()==CellType.NUMERIC) {
							celldata=cell.getNumericCellValue()+"";
						
							
						}
						else if (cell.getCellType()==CellType.BOOLEAN) {
							celldata=cell.getBooleanCellValue()+"";
						}
						}
				}
			}
			}
		return rowdata;
}
	public List<String> getTotalDataSheet(String how,String value) {
		List< String>sheetdata=new ArrayList<>();
		sheet=getsheetobj(how, value);
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			row=sheet.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++) {
				cell=row.getCell(j);
				if (cell!=null) {
					if (cell.getCellType()==CellType.STRING) {
						celldata=cell.getStringCellValue();
						sheetdata.add(celldata);
					}
					else if (cell.getCellType()==CellType.NUMERIC) {
						celldata=cell.getNumericCellValue()+"";
					
						sheetdata.add(celldata);	
					}
					else if (cell.getCellType()==CellType.BOOLEAN) {
						celldata=cell.getBooleanCellValue()+"";
						sheetdata.add(celldata);
					}
					}
			}
		}
		return sheetdata;
		

	}
	public Set<String> getTotalSheetDatauniqu(String how,String value){
		List<String>data=getTotalDataSheet(how, value);
		Set<String>setdata=new HashSet<>(data);
		return setdata;
	}
	
}
