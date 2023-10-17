//package com.example.singingclubvotingproject.ljx;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ReadExcel {
//
//    public static void main(String[] args) {
//        try {
//            //创建工作簿对象
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("F:\\WD\\ZM\\操作数据\\c1.xlsx"));
//            //获取工作簿下sheet的个数
//            int sheetNum = xssfWorkbook.getNumberOfSheets();
//            System.out.println("该excel文件中总共有："+sheetNum+"个sheet");
//            //遍历工作簿中的所有数据
//            for(int i = 0;i<sheetNum;i++) {
//                //读取第i个工作表
//                System.out.println("读取第"+(i+1)+"个sheet");
//                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
//
//
//                int maxRow = sheet.getLastRowNum();//获取最后一行的num，即总行数。此处从0开始
//                for (int row = 1; row <= maxRow; row++) {  //拿到列 从第一个开始最那个不要
//                    System.out.println(sheet.getRow(row).getCell(9)); //指定拿去第几行
////                    int maxRol = sheet.getRow(row).getLastCellNum();  //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
//
////                    System.out.println("--------第" + row + "行的数据如下--------");  //拿到行
////                    for (int rol = 0; rol < maxRol; rol++){
//
////                    }
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
//
