package com.frank.boot.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.frank.boot.domain.system.SysExportConfig;
import com.frank.boot.exception.SystemException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiExcelUtils {
    public final static int XLS = 97;
    public final static int XLSX = 2007;

    /**
     * 创建Workbook
     * @param type          Excel类型, 97-2003或2007
     * @return
     * @throws IOException
     */
    public static Workbook createWorkBook(int type) throws IOException {
        Workbook wb = null;
        if(type == XLSX) {
            wb = new XSSFWorkbook();
        } else {
            wb = new HSSFWorkbook();
        }
        return wb;
    }



    /**
     * 将数据写入到文件中
     * @param wb
     * @param sheetResult
     * @throws IOException
     * @throws NoStartRowException 
     */
    public static Workbook writeDataToExcel(Workbook wb, SysExportConfig sheetResult) throws IOException, SystemException {
    	int rownum = 0;
        int column = 0;
        Sheet sheet = null;
    	if("N".equals(sheetResult.getIstem())){
	        sheet = createSheet(wb, sheetResult.getSheetName());
	        
	        CellStyle cellStyle = createHeadCellStyle(wb);
        
        	//写头部信息
            Row headerRow = createRow(sheet, rownum);
            column = 0;
            String[] headers = sheetResult.getColNames().split(",");
            
            for(String title : headers) {
                Cell cell = createCell(headerRow, column);
                cell.setCellValue(title);
                cell.setCellStyle(cellStyle);
                
                column++;
            }
        }else{
        	// 获取第一个sheet
        	sheet = wb.getSheetAt(0);
        	rownum = sheetResult.getStartrow();
        }
        
        CellStyle defaultStyle = createDefaultCellStyle(wb);
        List datas = sheetResult.getDataList();
        List<String> fileds = new ArrayList<String>();
       
        if(datas.size()>0){
        	if("N".equals(sheetResult.getIstem())){ 
        		fileds = Arrays.asList(sheetResult.getSqlField().split(","));
        	}else if(fileds.size()==0){ 
        		Row dataFiledRow = sheet.getRow(rownum);
            	int k = 0;
            	if(dataFiledRow == null){
            		throw new SystemException("未找到起始行,请确认导出模板startrow");
            	}
            	while(dataFiledRow.getCell(k)!=null){
        			fileds.add(dataFiledRow.getCell(k).getStringCellValue().replace("$", ""));
        			k++;
            	}
            	rownum--;
        	}
            //写数据部分
        	int num = 0;
            for(int i = 0, len = sheetResult.getDataList().size(); i < len; i++) {
            	Row row = null;
            	row = createRow(sheet, i+rownum+1);
                column = 0;
                Map<String,Object> colDatas = new HashMap<>();
                if(datas.get(i) instanceof HashMap){
                    colDatas = (HashMap)datas.get(i);
                }else{
                    colDatas = TransUtils.objectToMap(datas.get(i),null);
                }
                
                for(int j =0;j < fileds.size(); j++) {
                    Cell cell = createCell(row, column);
                    if(colDatas.get(fileds.get(j))==null){
                        cell.setCellValue("");
                    }else{
                        cell.setCellValue(colDatas.get(fileds.get(j)).toString());
                        sheet.setColumnWidth(column, fileds.get(j).toString().getBytes().length*2*256);
                    }
                    cell.setCellStyle(defaultStyle);
                    column++;
                }
            
                	
                	 
               
            	
            }
        }


//        Map<String, MergingCell> mergeMap = getMerginCellMap(sheetResult);

//        //合并行列
//        for(Entry<String, MergingCell> entry: mergeMap.entrySet()) {
//            MergingCell mergingCell = entry.getValue();
//            MergingCells(sheet, mergingCell.getFirstRow(), mergingCell.getLastRow(),
//                    mergingCell.getFirstColumn(), mergingCell.getLastColumn());
//        }

        return wb;
    }

//    /**
//     * 获取头部列的行列合并信息
//     * @param sheetResult
//     * @return
//     */
//    private static Map<String, MergingCell> getMerginCellMap(SheetResult sheetResult) {
//        Map<String, MergingCell> mergeMap = new HashMap<String, MergingCell>();
//
//        //记录已合并的列索引集合
//        Set<Integer> colIndexSet = new HashSet<Integer>();
//
//        String tempValue = null;
//        int colSum = 0;
//        int rowSum = 0;
//
//        for(int i = 0, len = sheetResult.getHeadRowNum() ; i < len; i++) {
//
//            for(int j = 0, jLen = sheetResult.getDataList().get(i).size(); j < jLen; j++) {
//                tempValue = sheetResult.getDataList().get(i).get(j);
//                colSum = 0;
//                rowSum = 0;
//                if(!"".equals(tempValue)) {
//
//                    //列合并搜索
//                    for(int k = j + 1; k < jLen; k++) {
//                        if("".equals(sheetResult.getDataList().get(i).get(k)) && !colIndexSet.contains(k)) {
//                            colSum++;
//                        } else {
//                            break;
//                        }
//                    }
//
//                    //行处理
//                    for(int m = i + 1; m < sheetResult.getHeadRowNum(); m++) {
//                        if("".equals(sheetResult.getDataList().get(m).get(j))) {
//                            rowSum++;
//                        } else {
//                            break;
//                        }
//                    }
//
//                    if(colSum != 0 || rowSum != 0) {
//                        if(mergeMap.get(tempValue) == null) {
//                            MergingCell mergingCell = new MergingCell();
//                            mergingCell.setFirstColumn(j);
//                            mergingCell.setLastColumn(j + colSum);
//                            mergingCell.setFirstRow(i);
//                            mergingCell.setLastRow(i + rowSum);
//                            mergeMap.put(tempValue, mergingCell);
//                            colIndexSet.add(j);
//                        }
//                        j += colSum;
//                    }
//                }
//            }
//        }
//        return mergeMap;
//    }
//
//    /**
//     * "HI"  "FH"  ""   "LI"    ""  ""  ""  "WO"    ""  ""  "NA"    ""  ""  ""  "LEVELGROUP"    ""
//     * ""  "FHI"  "FHT" "NI"    "SHI"   "SHUI"  "A" "BU"    "JIAO"  "WO"    "NAGE"  ""  "SHIGE" ""  ""  ""
//     * ""  "FHIQ"  "FHTQ"   "NIQ"   "SHIQ"  "SHUIQ" "AQ"    "BUQ"   "JIAOQ" "WOQ"   "INAGE" "PNAGE" "ISHIGE"    "PNAGE" ""  ""
//     */
//    public static void testHead() {
//        List<List<String>> headList = new ArrayList<List<String>>();
//        String[][] headTitles = new String[][]{
//                {"HI" , "FH" , "","LI"  ,"","", "", "WO","",    "", "NA","",    "", "", "LEVELGROUP",""},
//                {"","FHI", "FHT","NI","SHI","SHUI","A","BU","JIAO","WO","NAGE", "", "SHIGE","", "", ""},
//                {"", "FHIQ", "FHTQ","NIQ","SHIQ","SHUIQ","AQ","BUQ","JIAOQ","WOQ","INAGE","PNAGE","ISHIGE", "PNAGE","", ""}
//
//        };
//        for(int i = 0, len = headTitles.length; i < len; i++) {
//            List<String> rowDataList = new ArrayList<String>();
//            for(int j = 0, jLen = headTitles[i].length; j < jLen; j++) {
//                rowDataList.add(headTitles[i][j]);
//            }
//            headList.add(rowDataList);
//        }
//
//        Map<String, MergingCell> mergeMap = new HashMap<String, MergingCell>();
//        String tempValue = null;
//        int num = 0;
//
//        for(int i = 0, len = headList.size() ; i < len; i++) {
//            for(int j = 0, jLen = headList.get(i).size(); j < jLen; j++) {
//                tempValue = headList.get(i).get(j);
//                if(!"".equals(tempValue)) {
//                    for(int k = j + 1; k < jLen; k++) {
//                        if("".equals(headList.get(i).get(j))) {
//                            num++;
//                        }
//                    }
//                    if(num != 0) {
//                        if(mergeMap.get(tempValue) == null) {
//                            MergingCell mergingCell = new MergingCell();
//                            mergingCell.setFirstColumn(j);
//                            mergingCell.setLastColumn(j + num);
//                            mergingCell.setFirstRow(i);
//                            mergingCell.setLastRow(i);
//                        }
//                        j += num;
//                    }
//                }
//            }
//        }
//
//        SheetResult sheetResult = new SheetResult();
//        sheetResult.setHeadRowNum(3);
//        sheetResult.setDataList(headList);
//
//        try {
//            writeDataToExcel(createWorkBook(XLSX), "Cell", "J:\\MyEclipse2014\\studyworkspace\\MicroftOffice\\temp\\writehead.xlsx", sheetResult);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 合并单元格，可以根据设置的值来合并行和列
//     * @param sheet
//     * @param firstRow
//     * @param lastRow
//     * @param firstColumn
//     * @param lastColumn
//     */
//    private static void MergingCells(Sheet sheet, int firstRow, int lastRow,
//                                     int firstColumn, int lastColumn) {
//        sheet.addMergedRegion(new CellRangeAddress(
//                firstRow, //first row (0-based)
//                lastRow, //last row  (0-based)
//                firstColumn, //first column (0-based)
//                lastColumn  //last column  (0-based)
//        ));
//    }
//
    /**
     * 创建头部样式
     * @param wb
     * @return
     */
    private static CellStyle createHeadCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        addBorderStyle(cellStyle, BorderStyle.THIN, IndexedColors.BLACK.getIndex());
        addColor(cellStyle, IndexedColors.PALE_BLUE.getIndex(), FillPatternType.LESS_DOTS);
        return cellStyle;
    }

    /**
     * 创建普通单元格样式
     * @param wb
     * @return
     */
    private static CellStyle createDefaultCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        addAlignStyle(cellStyle, HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        addBorderStyle(cellStyle, BorderStyle.THIN, IndexedColors.BLACK.getIndex());
        return cellStyle;
    }

    /**
     * cell文本位置样式
     * @param cellStyle
     * @param halign
     * @param valign
     * @return
     */
    private static CellStyle addAlignStyle(CellStyle cellStyle,
                                           HorizontalAlignment halign, VerticalAlignment valign) {
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        return cellStyle;
    }

    /**
     * cell边框样式
     * @param cellStyle
     * @return
     */
    private static CellStyle addBorderStyle(CellStyle cellStyle, BorderStyle borderStyle, short colorIndex) {
        cellStyle.setBorderBottom(borderStyle);
        cellStyle.setBottomBorderColor(colorIndex);
        cellStyle.setBorderLeft(borderStyle);
        cellStyle.setLeftBorderColor(colorIndex);
        cellStyle.setBorderRight(borderStyle);
        cellStyle.setRightBorderColor(colorIndex);
        cellStyle.setBorderTop(borderStyle);
        cellStyle.setTopBorderColor(colorIndex);
        return cellStyle;
    }

    /**
     * 给cell设置颜色
     * @param cellStyle
     * @param backgroundColor
     * @param fillPattern
     * @return
     */
    private static CellStyle addColor(CellStyle cellStyle,
                                      short backgroundColor, FillPatternType fillPattern ) {
        cellStyle.setFillForegroundColor(backgroundColor);
        cellStyle.setFillPattern(fillPattern);
        return cellStyle;
    }

    private static Sheet createSheet(Workbook wb, String sheetName) {
        return wb.createSheet(sheetName);
    }
    private static Row createRow(Sheet sheet, int rownum) {
        return sheet.createRow(rownum);
    }

    private static Cell createCell(Row row, int column) {
        return row.createCell(column);
    }

    public static void main(String [] args) throws IOException, InvalidFormatException, SystemException {
        Workbook wb = createWorkBook(XLSX);
        Workbook wb1 = new XSSFWorkbook("D://upload/template/事业部咨询统计表.xlsx");
        SysExportConfig sheetResult = new SysExportConfig();
        String headers = "字段1,字段2,字段3,字段4,字段5";
        sheetResult.setColNames(headers);
        sheetResult.setStartrow(3);
        List dataList = new ArrayList<>();
        List<String> line1 = new ArrayList<String>();
        line1.add("11");
        line1.add("22");
        line1.add("32");
        line1.add("43");
        line1.add("54");
        dataList.add(line1);
        dataList.add(line1);
        dataList.add(line1);
        dataList.add(line1);
        dataList.add(line1);
        sheetResult.setDataList(dataList);
        writeDataToExcel(wb1,sheetResult);
    }
}
