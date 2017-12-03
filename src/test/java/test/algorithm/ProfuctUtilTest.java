package test.algorithm;

import com.ytt.algorithm.ProductUtil;
import org.junit.Test;

public class ProfuctUtilTest {

    @Test
    public void testproductForMax(){

        int[] result = ProductUtil.productForMax("2000","500");

        for (int a:result) {
            System.out.print(a);
        }
        System.out.println();

    }

}
