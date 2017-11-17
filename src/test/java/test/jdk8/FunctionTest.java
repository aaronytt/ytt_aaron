package test.jdk8;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

        Function<Integer,Integer> function1 = i -> i+1;
        Function<Integer,Integer> function2 = i -> {return i+1;};
        Function<Integer,Integer> function3 = i -> {int j = i+1; return j;};
        Function<Integer,Integer> function4 = Integer::valueOf;
        Function<Integer,Integer> function5 = Integer::new;

        System.out.println(function1.apply(1));
        System.out.println(function2.apply(1));
        System.out.println(function3.apply(1));
        System.out.println(function4.apply(3));
        System.out.println(function5.apply(4));


//        System.out.println(function1.compose(function2).andThen(function1).compose(function3).andThen(function1).apply(1));


//        BiFunction<Short,Integer,Integer> biFunction1 = (i,j) -> i*j;
//
//        System.out.println(biFunction1.apply((short) 1,5));
//        System.out.println(biFunction1.andThen(function3).apply((short) 1,5));

    }

}

