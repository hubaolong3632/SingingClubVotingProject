package com.example.singingclubvotingproject.Text;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static void main(String[] args) {


        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("F:\\WD\\ZM\\操作数据\\c1.xlsx"));
            //获取工作簿下sheet的个数
            int sheetNum = xssfWorkbook.getNumberOfSheets();
            System.out.println("》》该excel文件中总共有："+sheetNum+"个sheet");
            //遍历工作簿中的所有数据
            for(int i = 0;i<sheetNum;i++) {
                //读取第i个工作表
                System.out.println("》》开始读取第:"+(i+1)+"个sheet");
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);


                int maxRow = sheet.getLastRowNum();//获取最后一行的num，即总行数。此处从0开始
                double sum=0;//计算平均分
                for (int row = 1; row <= maxRow; row++) {  //拿到列 从第一个开始最那个不要
                    Double integer = Double.valueOf(sheet.getRow(row).getCell(8).toString());
                    sum+=integer;

                    System.out.println(integer); //指定拿去第几行
                }
                System.out.println("--------------------------------------");
                System.out.println("投票人数:"+maxRow);//输出总评分
                System.out.println("平均分数:"+(sum / maxRow));
                System.out.println("总评分:"+sum);//输出总评分




            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

