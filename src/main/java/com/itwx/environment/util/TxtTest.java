package com.itwx.environment.util;

import javax.sql.DataSource;
import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wx
 * @Date:2019/9/6 9:45
 */
public class TxtTest {
    public static void main(String[] args) {
        readFile();
    }

    /**
     * 读入TXT文件
     */
    public static void readFile() {
        String pathname = "C:\\Users\\wangxuan\\Desktop\\Agilent上传模板.txt";
        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        try{
            File file = new File(pathname);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "GBK");
            BufferedReader br = new BufferedReader(read);
            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                if (line.trim().startsWith("样品")) {
                    System.out.println(line);
                    String[] split = line.split("\\s+");
                    for (int i = 0; i < split.length; i++) {
                        System.out.println(split[split.length - 1]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 写入TXT文件
     */
    public static void writeFile() {
        try {
            // 相对路径，如果没有则要建立一个新的output.txt文件
            File writeName = new File("output.txt");
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                // \r\n即为换行
                out.write("我会写入文件啦1\r\n");
                out.write("我会写入文件啦2\r\n");
                // 把缓存区内容压入文件
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 读取安捷伦有机酸结果
    public static Map<String, String> importOrganic_ajl(String path,
                                                        DataSource datasource) {
        String sqlstring = "select * from organic_new_param";
        String result = "";
        String OrgResult = "";
        DecimalFormat df = new DecimalFormat("0.00");
        Map<String, String> resmap = new HashMap();
        String jg = "";
        try {
//            List<Map<String, Object>> list = CommonMethod.getListMap(datasource, sqlstring, null);
            Map<String, String> map = new HashMap<String, String>();
//            for (int i = 0; i < list.size(); i++) {
//                String shortname = list.get(i).get("shortname").toString();
//                String percent = list.get(i).get("percent") == null ? "" : list.get(i).get("percent").toString();
//                String oldnum = list.get(i).get("oldnum") == null ? "" : list.get(i).get("oldnum").toString();
//                map.put(shortname + "_per", percent);
//                map.put(shortname + "_num", oldnum);
//            }
            String encoding = "UTF-8";
            String[] content;
            File file = new File(path);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                String name = "";
                String unit = "";
                String matching = "";
                String value = "";
                String percent = "";
                String oldnum = "";
                for (int i = 0; (lineTxt = bufferedReader.readLine()) != null; i++) {
                    if (i >= 22 && i <= 134) {
                        content = lineTxt.trim().split("\\s+");
                        if (content.length == 8) {
                            name = content[1];
                            value = content[5];
                            unit = content[6];
                            matching = content[7];
                            if (unit.indexOf("#") > -1 && Float.parseFloat(matching) < 80 && Float.parseFloat(value) < 100) {
                                value = "0.00";
                            }
                            if (map.containsKey(name + "_per")) {
                                percent = map.get(name + "_per");
                                oldnum = map.get(name + "_num");
                                if (percent.equals("") || oldnum.equals("")) {
                                    result += "org_"
                                            + name
                                            + ":"
                                            + df.format(Float.parseFloat(value))
                                            + ";";
                                } else {
                                    value = df.format(Float.parseFloat(value) * Float.parseFloat(percent));
                                    result += "org" + oldnum + ":" + value + ";";
                                }
                            }
                        } else if (content.length > 1) {
                            name = content[1];
                            if (map.containsKey(name + "_per")) {
                                percent = map.get(name + "_per");
                                oldnum = map.get(name + "_num");
                                if (percent.equals("") || oldnum.equals("")) {
                                    result += "org_" + name + ":0.00;";
                                } else {
                                    result += "org" + oldnum + ":0.00;";
                                }
                            }
                        }
                        // System.out.println(lineTxt);
                        /*
                         * if (content.length > 2) { OrgResult =
                         * String.valueOf(df.format(Float
                         * .parseFloat(content[2]))); if (result.equals(""))
                         * result += "org" + (i - 2) + ":" + OrgResult; else
                         * result += ";" + "org" + (i - 2) + ":" + OrgResult; }
                         */
                    }
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resmap.put("result", result);
        resmap.put("jg", "");
        return resmap;
    }



}
