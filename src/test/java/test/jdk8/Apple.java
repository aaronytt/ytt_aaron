package test.jdk8;

import java.util.stream.Stream;

public class Apple{

    private String name;

    public Apple() {
    }

    public Apple(String name) {
        this.name = name;
        System.out.println(name);
    }

    public static void addAppleType(String name){
        System.out.println(name);
    }

    public void addAppleName(String name){
        System.out.println(name);
    }

    public int addApple(Apple apple){
        return this.getName().compareToIgnoreCase(apple.getName());
    }

    @Override
    public String toString() {
        return super.toString()+"/"+ getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Stream stream;

    }

}
