package test.jvm_lecture;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:51 2018/7/3
 * @Modiflid By:
 */
public class MyTest9 {

    static{
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }

}

class Parent{
    static int a = 1;

    static{
        System.out.println("Parent static block");
    }
}

class Child extends Parent{
    static int b = 2;

    static{
        System.out.println("Child static block");
    }
}
