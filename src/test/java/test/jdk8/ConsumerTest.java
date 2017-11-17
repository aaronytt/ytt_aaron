package test.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {

        Consumer<String> consumer1 = inputString -> System.out.println(inputString);
        Consumer<String> consumer2 = System.out::println;
        Consumer<String> consumer3 = Apple::new;
        Consumer<String> consumer4 = Apple::addAppleType;
        Consumer<String> consumer5 = String::toString;
        Consumer<String> consumer6 = (new Apple())::addAppleName;

        consumer1.accept("zcc1");
        consumer2.accept("zcc2");
        consumer3.accept("zcc3");
        consumer4.accept("zcc4");
        consumer5.accept("zcc5");
        consumer6.accept("zcc6");

        Apple[] apples = {new Apple("zcc1"),new Apple("zcc2")};

        Comparator<Apple> comparator = Apple::addApple;

        Arrays.sort(apples, comparator);

        Arrays.asList(apples).forEach(System.out::println);

        System.out.println(Arrays.asList(1,2,3).toArray(new Integer[5])[0]);


    }

}
