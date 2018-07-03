package test.jvm_lecture;

/**
 * @Author: aaron
 * @Descriotion:
 *  常量在编译阶段会存入到调用这个常量的常量池里
 *  本质上，调用类并没有直接引用到定义常量的类，
 *  因此不会触发定义常量的类的初始化
 *  注意：这是指的是将常量放到JVMConstantTest的常量池中，
 *  之后JVMConstantTest和MyParent2并没有什么关系了，
 *  甚至，我们可以将MyParent2的class文件删除
 *
 *  助记符：
 *  ldc表示将int， float或是String类型的常量从常量池中推送至栈顶
 *  bipush表示将单字节（-128~127）的常量值推送至栈顶
 *  sipush表示将一个短整型常量值（-32768~32767）推送至栈顶
 *  iconst_1表示将int类型1推送至栈顶（iconst_1~iconst_5）
 *
 * @Date: 21:36 2018/5/10
 * @Modiflid By:
 */
public class JVMConstantTest {

    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }

}

class MyParent2{

    public static final String str = "hello word";

    static {
        System.out.println("MyParent2 static block");
    }

}
