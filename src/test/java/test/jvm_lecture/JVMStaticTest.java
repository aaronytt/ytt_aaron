package test.jvm_lecture;

/**
 * @Author: aaron
 * @Descriotion:
 *  1.对于静态字段来说，只有直接定义了该字段的类才会被初始化
 *  2.当一个类在初始化时，要求其父类全部都已经被初始化完毕了
 *
 *  -XX:+TraceClassLoading
 *
 *  -XX:+<option>,表示开启option选项
 *  -XX:-<option>,表示关闭option选项
 *  -XX:<option>=<value>,表示将option选项的值设置为value
 *
 * @Date: 13:59 2018/5/6
 * @Modiflid By:
 */
public class JVMStaticTest {

    public static void main(String[] args) {
        System.out.println(MyChild.strp);
    }

}

class MyParent{

    public static String strp = "ytt";

    static{
        System.out.println("MyPerant sattic block");
    }

}

class MyChild extends MyParent{

    public static String strc = "aaron";

    static{
        System.out.println("MyChild sattic block");
    }

}
