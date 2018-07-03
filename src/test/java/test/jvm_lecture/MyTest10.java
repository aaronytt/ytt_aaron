package test.jvm_lecture;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:51 2018/7/3
 * @Modiflid By:
 */
public class MyTest10 {

    static{
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent1 parent1;
        System.out.println("------------");
        parent1 = new Parent1();
        System.out.println("------------");
        System.out.println(parent1.a);
        System.out.println("------------");
        System.out.println(Child1.b);
    }

}

class Parent1{
    static int a = 1;

    static{
        System.out.println("Parent static block");
    }
}

class Child1 extends Parent1{
    static int b = 2;

    static{
        System.out.println("Child static block");
    }
}
