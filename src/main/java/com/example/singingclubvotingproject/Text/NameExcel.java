package com.example.singingclubvotingproject.Text;

import com.example.singingclubvotingproject.model.StudentListModel;
import com.example.singingclubvotingproject.model.StudentModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;

public class NameExcel {

    public static void main(String[] args) {

        NameExcel nameExcel = new NameExcel();
        nameExcel.main();

    }
    public void main(){
        HashMap<String, StudentListModel> studentMap = new HashMap<>();

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
                for (int row = 1; row <= maxRow; row++) {  //拿到列 从第一个开始最那个不要
                    String department = sheet.getRow(row).getCell(4).toString(); //系部
                    String grade = sheet.getRow(row).getCell(5).toString(); //班级
                    String name = sheet.getRow(row).getCell(6).toString();//姓名


                    StudentModel student = new StudentModel();
                    student.setName(name);
                    student.setDepartment(department);
                    student.setGrade(grade);


                    addStudent(studentMap,student); //添加

                    System.out.println(department+"          "+grade+"     "+name+"     "); //指定拿去第几行
                }
                System.out.println("--------------------------------------");




            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : studentMap.keySet()) {
            System.out.println("------------------------------------------------");
            System.out.println(s);
                for (StudentModel studentModel : studentMap.get(s).getStudent()) {
                    System.out.println(studentModel);
                }
        }

    }

    public void addStudent(HashMap<String, StudentListModel> studentMap,StudentModel student){
        if (studentMap.containsKey(student.getDepartment())==false) {
            studentMap.put(student.getDepartment(),new StudentListModel());
        }
        studentMap.get(student.getDepartment()).setStudent(student); //添加进集合


    }


}

