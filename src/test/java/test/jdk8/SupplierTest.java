package test.jdk8;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Person> supplier = Person::new;

        System.out.println(supplier.get());
        System.out.println(supplier.get());

        System.out.println(supplier.get() == supplier.get());

    }

}

class Person{

}
