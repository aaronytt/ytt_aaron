package test.spring.bean.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import test.spring.bean.model.Person;
import test.spring.bean.util.GetBean;

public class BeanFactoryTest {

    private static final String GET_BEAN = "getBean";

    private static final BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean\\beanfactory.xml"));

    @Test
    public void testBeanFactory(){
        System.out.println(beanFactory.getBean("person"));
    }

    @Test
    public void testLookup(){
        GetBean getBean = (GetBean) beanFactory.getBean(GET_BEAN);
        getBean.getBean().isShow();
    }

    @Test
    public void testReplacer(){
        Person person = (Person) beanFactory.getBean("person");
        person.isShow();
    }

}
