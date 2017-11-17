package test.spring.bean.util;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class UserReplacer implements MethodReplacer{
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("我就是在替換！");
        return null;
    }
}
