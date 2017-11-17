package test.spring.bean.model;

public class Student extends Person{

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void isShow(){
        System.out.println("I am student!");
    }

}
