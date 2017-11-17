package test.spring.bean.model;

public class Teacher extends Person{

    private Person person;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Person person) {
        super(name, age);
        this.person = person;
    }

    public void isShow(){
        System.out.println("I am teacher!");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
