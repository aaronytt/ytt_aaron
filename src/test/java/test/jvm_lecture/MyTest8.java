package test.jvm_lecture;

import java.util.Random;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:40 2018/7/3
 * @Modiflid By:
 */
public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.y);
    }

}

class FinalTest{

    public static final int x = new Random().nextInt(3);
    public static final int y = 3;

    static {
        System.out.println("FinalTest static block");
    }

}
