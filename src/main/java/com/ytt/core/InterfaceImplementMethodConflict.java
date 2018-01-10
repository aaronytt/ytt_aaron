package com.ytt.core;

/**
 * @Author: aaron
 * @Descriotion:
 *  1.超类优先：
 *      本类实现 > 超类实现 > 接口默认实现和抽象方法（这哥俩会引起二义性）
 *  2.接口冲突:
 *      二义性，需要开发者处理，重新实现或者表明是抽象类
 * @Date: 22:06 2018/1/10
 * @Modiflid By:
 */
public class InterfaceImplementMethodConflict {

}

interface Person {

    String getName();

//    default String getName(){
//        return "person";
//    }

}

interface Names {

    String getName();

//    default String getName(){
//        return "person";
//    }
}

class Student implements Person,Names{

    @Override
    public String getName() {
        return null;
    }
}

//abstract class Student implements Person,Names{
//
//}
