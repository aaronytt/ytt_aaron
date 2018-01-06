package test.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 4.运行时常量池导致的内纯溢出异常
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用List保持着常量池引用，避免Full GC 回收常量池行为
        List<String> list = new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;

        while(true){
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }
    }

    /**
     * 4.1关于String.intern返回引用的测试
     * 在1.6中运行，是两个false
     * 在1.7以后，依次是true，false
     */
//        public static void main(String[] args) {
//
//            String str1 = new StringBuilder("我").append("和你").toString();
//            System.out.println(str1.intern() == str1);
//
//            String str2 = new StringBuilder("ja").append("va").toString();
//            System.out.println(str2.intern() == str2);
//
//        }

}
