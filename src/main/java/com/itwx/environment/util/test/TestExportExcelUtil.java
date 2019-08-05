package com.itwx.environment.util.test;

import com.itwx.environment.util.ExportExcelUtil;
import com.itwx.environment.util.model.Student;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wx
 * @Date:2019/7/17 16:57
 */
public class TestExportExcelUtil {

    public static void main(String[] args) throws Exception{
        ExportExcelUtil<Student> util = new ExportExcelUtil<>();
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111,"张三asdf"+i,"男"));
        }
        String[] columnNames = { "ID", "姓名", "性别" };
//        util.exportExcel2007("用户导出", columnNames, list, new FileOutputStream("D:/test.xlsx"), null);
    }
}
