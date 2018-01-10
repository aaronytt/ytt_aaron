package com.ytt.core;

import java.util.Objects;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:19 2018/1/10
 * @Modiflid By:
 */
public class EqualsExample {

    private String name;
    private int num;

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        //组合散列值
        return Objects.hash(name,num);
        //可以手动
//        return 7 * Objects.hashCode(name)
//           + 11 * Integer.hashCode(num);
//           + 13 * (x)
//           ....
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        //1.检测this是否obj是一个对象
        if(this == obj) return true;
        //2.检测obj是否null
        if(obj == null) return false;
        //3.比较this和obj是否属于一个类
        if(getClass() != obj.getClass()) return  false;
        //4.将obj转化成相应的类类型变量
        EqualsExample other = (EqualsExample) obj;
        //5.开始对所需要比较的域进行比较
        return num == other.num && name.equals(other.getName());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
