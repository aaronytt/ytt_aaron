package com.ytt.Util;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有(C) 2017 上海银路投资管理有限公司
 * 描述:
 * 作者: aaron
 * 创建日期: 2017-11-08 11:05
 * 修改记录:
 */
public class CSVUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVUtil.class);

    /**
     * 读取CSV文件
     */
    public static List<String[]> readCSVUtil(String csvFilePath) throws Exception{
        ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
        CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("UTF-8"));    //一般用这编码读就可以了
//        reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。
        while(reader.readRecord()){ //逐行读入除表头的数据
            csvList.add(reader.getValues());
        }
        reader.close();
        return csvList;
    }

    /**
     * 写入CSV文件
     */
    public static String writeCsv(String fileName, String filePath,List<String[]> datas) throws Exception {
        File csvFile = new File(filePath + fileName);
        File parent = csvFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        csvFile.createNewFile();

        String csvFilePath = filePath + fileName;
        CsvWriter wr =new CsvWriter(csvFilePath,',', Charset.forName("UTF-8"));
        datas.forEach(data -> {
            try {
                wr.writeRecord(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        wr.close();

        return csvFilePath;
    }

}
