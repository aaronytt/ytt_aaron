package test.cvs;

import com.ytt.Util.CSVUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CsvTest {

    private final String[] eppHeader = {"商品编码*","门店编码","ERP价格*（价格不能为0）"};

    @Test
    public void testCsv() throws Exception {
        String csvFilePath = "D:/erp_price_setting.csv";
        List<String[]> csvData = CSVUtil.readCSVUtil(csvFilePath);
        String[] header = csvData.get(0);
        csvData.remove(0);
        csvData.forEach(data -> {
            System.out.println(">>>1: " + data);
            data[2] = "10.00";
            System.out.println(">>>2: " + data);
        });
        List<String[]> result = new ArrayList<>();
        result.add(header);
        result.addAll(csvData);
        CSVUtil.writeCsv("erp_price_setting_test.csv","D:/" ,result);
    }

    protected <T> boolean arrayEquals(T[] array1,T[] array2){
        if(array1 == null || array2 == null) return false;
        boolean flag = false;
        flag = array1.length == array2.length;
        if(!flag) return flag;
        for(int i=0; i<array1.length; i++){
            flag = flag && array1[i].toString().trim().equals(array2[i].toString().trim());
        }
        return flag;
    }

}
