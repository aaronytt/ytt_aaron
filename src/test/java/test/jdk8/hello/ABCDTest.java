package test.jdk8.hello;

public class ABCDTest {

    public static void main(String[] args) {
        E d = new D();

        d.hello();
    }

}

interface A {
    default void hello(){
        System.out.println(">>>>>>>>>>>  A");
    }
}

interface B extends A{
    default void hello(){
        System.out.println(">>>>>>>>>>>  B");
    }
}

abstract class C implements A{
    @Override
    public void hello(){
        System.out.println(">>>>>>>>>>>  C");
    }
}

interface E extends A {
    default void hello(){
        System.out.println(">>>>>>>>>>>  E");
    }
}

class D extends C implements B,E{
    @Override
    public void hello(){
        System.out.println(">>>>>>>>>>  D");
    }
}


