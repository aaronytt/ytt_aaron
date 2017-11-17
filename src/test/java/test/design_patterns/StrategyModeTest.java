package test.design_patterns;

import org.junit.Test;

public class StrategyModeTest {

    @Test
    public void testValidationStrategy(){
        String string = "12356AC";

        //换成Lambada表达式,这个太啰嗦，还得写实体类，去他妈的吧
//        Validator validator1 = new Validator(new IsAllLowerCase());
//        System.out.println(validator1.validate(string));
//
//        Validator validator2 = new Validator(new IsNumeric());
//        System.out.println(validator2.validate(string));

        //牛逼吧，连实现类都不用写了，体会到函数式编程的魅力了吧
        Validator validator1 = new Validator((String s) ->s.matches("[a-z]+"));
        Validator validator2 = new Validator((String s) ->s.matches("\\d+"));

        System.out.println(validator1.validate(string));
        System.out.println(validator2.validate(string));

    }


}

class Validator{
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public  boolean validate(String s){
        return  strategy.execute(s);
    }
}

interface ValidationStrategy{
    boolean execute(String s);
}

//class IsAllLowerCase implements ValidationStrategy{
//    @Override
//    public boolean execute(String s) {
//        return s.matches("[a-z]+");
//    }
//}
//
//class IsNumeric implements ValidationStrategy{
//    @Override
//    public boolean execute(String s) {
//        return s.matches("\\d+");
//    }
//}