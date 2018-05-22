package com.xyb2c.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static byte[] getExcleBytes(List<String> rowname, List<List<String>> data) {
		// 第一步，创建一个webbook，对应一个Excel文件
		// HSSFWorkbook wb = new HSSFWorkbook();
		// HSSFFont font = wb.createFont();
		XSSFWorkbook wb = new XSSFWorkbook();
		// XSSFSheet sheet1= wb.createSheet("test");
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet("数据");

		/*
		 * for (int i = 0; i < 11; i++) { sheet.setColumnWidth(i, 100*60); }
		 */

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		XSSFCell cell = row.createCell(0);
		for (int i = 0; i < rowname.size(); i++) {
			cell.setCellValue(rowname.get(i));
			cell.setCellStyle(style);
			cell = row.createCell(i + 1);

		}
		// Map<String,Object> paramMap = new HashMap<String,Object>();

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		// List<OrderTrade> tradeList =this.orderTradeService.selectAll();

		// OrderTrade ot=null;
		for (int i = 0; i < data.size(); i++) {
			row = sheet.createRow(i + 1);
			List<String> data1 = data.get(i);
			for (int j = 0; j < data1.size(); j++) {
				row.createCell(j).setCellValue(data1.get(j));
			}
		}
		for (List<String> data1 : data) {
			for (int i = 0; i < data1.size(); i++) {
				row.createCell((short) i).setCellValue(data1.get(i));
			}
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			wb.write(out);
			out.close();
		} catch (IOException e) {

		}
		return out.toByteArray();

	}

	/**
	 * 
	 * @param is
	 *            excel的流
	 * @param c
	 *            需要转换成的类型
	 * @param prams
	 *            需要转换的bean里面的需要转换的熟属性（一定要按照顺序）
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> parse(InputStream is, Class<T> c, List<String> prams) throws Exception {
		List<T> list = new ArrayList<>();
		Workbook workbook = WorkbookFactory.create(is);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			T t = c.newInstance();
			Row row = sheet.getRow(i);
			for (int j = 0; j < prams.size(); j++) {
				Field fd = c.getDeclaredField(prams.get(j));
				fd.setAccessible(true);
				if (fd.getType().toString().endsWith("String")) {
					try {
						fd.set(t, row.getCell(j).getStringCellValue());
					} catch (Exception e) {
						fd.set(t, new Integer((int) row.getCell(j).getNumericCellValue()) + "");
					}
				}
				if (fd.getType().toString().endsWith("Integer") || fd.getType().toString().endsWith("int")) {
					try {
						fd.set(t, row.getCell(j).getNumericCellValue());
					} catch (Exception e) {
						fd.set(t, new Integer(row.getCell(j).getStringCellValue()));
					}

				}
				if (fd.getType().toString().endsWith("Date")) {
					fd.set(t, row.getCell(j).getDateCellValue());
				}
			}
			list.add(t);
		}

		return list;
	}

	@SuppressWarnings({ "static-access", "unused" })
	private static String getValue(Cell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 布尔类型
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// 整型
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			// 字符串
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
}
