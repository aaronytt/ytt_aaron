package test.jdk8;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        Optional<Integer> optional = Optional.of(1);

        System.out.println(optional.isPresent());




    }

}
