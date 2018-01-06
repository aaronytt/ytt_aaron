package test.memory;


import javafx.beans.binding.When;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于测试OutOfMemoryError
 * 运行时数据区通常包括这几个部分：程序计数器(Program Counter Register)、Java栈(VM Stack)、本地方法栈(Native Method Stack)、方法区(Method Area)、堆(Heap)
 * Xss：每个线程的stack大小（栈）
 * Xmx：JAVA HEAP的最大值、默认为物理内存的1/4
 * Xms：JAVA HEAP的初始值，server端最好Xms与Xmx一样
 * Xmn：JAVA HEAP young区的大小
 * XX:PermSize：设定内存的永久保存区域
 * XX:MaxPermSize：设定最大内存的永久保存区域
 */
public class OutOfMemoryErrorTest {


    /**
     * 1. java 堆溢出
     * 在 "VM arguments"后加参数
     * -verbise:ge -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */

    public static class HeapOOM {

        static class OOMObject{}

        public static void main(String[] args) {

            List<OOMObject> list= new ArrayList<OOMObject>();

            while (true){
                list.add(new OOMObject());
            }
        }
    }

    /**
     * 2.虚拟机栈和本地方法栈OOM测试
     *  VM Args:-Xss128k
     */
    public static class JavaVMStackSOF {

        private int stackLength = 1;

        public void stackLeak(){
            stackLength++;
            stackLeak();
        }

        public int getStackLength() {
            return stackLength;
        }

        public void setStackLength(int stackLength) {
            this.stackLength = stackLength;
        }

        public static void main(String[] args) {

            JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();

            try {
                javaVMStackSOF.stackLeak();
            } catch (Exception e) {
                System.out.println("stack length:" + javaVMStackSOF.getStackLength());
                throw e;
            }

        }

    }

    /**
     * 3.创建线程导致的内存溢出的异常
     * windos下容易造成系统假死，不要轻易尝试
     * VM Args:-Xss2M(这时候不妨设置大点)
     */
    public static class JavaVMStackOOM {

//        private void dontStop(){
//            while (true){
//
//            }
//        }
//
//        public void statckLeakByThread() {
//            while(true){
//                new Thread(new Runnable() {
//                    @Override
//                    public void run(){
//                        dontStop();
//                    }
//                }).start();
//            }
//        }
//
//        public static void main(String[] args) {
//
//            JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
//
//            javaVMStackOOM.statckLeakByThread();
//
//        }

    }

    /**
     * 4.运行时常量池导致的内纯溢出异常
     * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
     *
     * 在JDK1.8中，取消了PermGen，取而代之的是Metaspace，所以PermSize和MaxPermSize参数失效，取而代之的是 -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m
     *参考：http://blog.csdn.net/lk7688535/article/details/51767333 http://caoyaojun1988-163-com.iteye.com/blog/1969853
     *
     */
    public static class RuntimeConstantPoolOOM {

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






}
