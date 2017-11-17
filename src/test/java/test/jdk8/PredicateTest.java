package test.jdk8;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        Predicate<Integer> predicate1 = i -> i==1 ;


        System.out.println(predicate1.and(i -> i==2).test(1));

        System.out.println(predicate1.or(i -> i==2).test(1));

        System.out.println(predicate1.or(i -> i==2).negate().test(1));

    }

}
