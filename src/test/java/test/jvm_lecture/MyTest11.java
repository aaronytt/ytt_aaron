package test.jvm_lecture;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:51 2018/7/3
 * @Modiflid By:
 */
public class MyTest11 {

    static{
        System.out.println("MyTest11 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child2.a);
        System.out.println("----------------");
        Child2.doSomeThing();
    }

}

class Parent2{
    static int a = 1;

    static{
        System.out.println("Parent static block");
    }

    static void doSomeThing() {
        System.out.println("do something");
    }
}

class Child2 extends Parent2{
    static int b = 2;

    static{
        System.out.println("Child static block");
    }
}
