package test.design_patterns;

import org.junit.Test;

import java.util.function.Consumer;

public class TemplateMethodTest {

    @Test
    public void testOnlineBanking(){


        //这个函数干什么了，不知道
//        new OnlineBanking(){}.processCustomer(10);

        //用Lambda表达式真方便，明白是什么动作
        new OnlineBanking(){
//            public void processCustomer(int id, Consumer<Person> makeCustomerHappy){
//                super.processCustomer(id + 1,makeCustomerHappy.andThen(p -> {p.setAge(p.getAge() + 2); makeCustomerHappy.accept(p);}));
//            }
        }.processCustomer(10,p -> System.out.println("name:" + p.getName() + ",age:" + p.getAge()));
    }

}

abstract class OnlineBanking{
    public void processCustomer(int id, Consumer<Person> makeCustomerHappy){
        Person p = new Person("三毛",id);

        makeCustomerHappy.accept(p);
    }
}

//abstract class OnlineBanking{
//    public void processCustomer(int id){
//        Person p = new Person("555",id);
//        makeCustomerHappy(p);
//    }
//
//    private void makeCustomerHappy(Person p) {
//        System.out.println("name:" + p.getName() + ",age:" + p.getAge()))
//    }
//}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}