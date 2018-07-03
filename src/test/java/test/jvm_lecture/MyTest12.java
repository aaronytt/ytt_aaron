package test.jvm_lecture;

/**
 * @Author: aaron
 * @Descriotion: 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 * @Date: 21:26 2018/7/3
 * @Modiflid By:
 */
public class MyTest12 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("test.jvm_lecture.CL");

        System.out.println(clazz);
        System.out.println("-------------");

        clazz = Class.forName("test.jvm_lecture.CL");
        System.out.println(clazz);
    }

}

class CL{
    static {
        System.out.println("CL invoke");
    }
}
