package test.spring.bean.util;

import test.spring.bean.model.Person;

public abstract class GetBean {

    public void isShow(){
        this.getBean().isShow();
    }

    public abstract Person getBean();

}
