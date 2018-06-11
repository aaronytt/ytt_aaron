package test.design_patterns;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityTest {

    @Test
    public void testChainOfResponsibility(){

        //这个责任链模式太繁琐了
//        ProcessingObjectInterface<String> p1 = new HeaderTextProcessing();
//        ProcessingObjectInterface<String> p2 = new SpellCheckerProcessing();
//
//        p1.setSuccesser(p2);
//
//        System.out.println(p1.handel("100"));

        //这个责任链模式很简略
        UnaryOperator<String> headerProcessing = str -> "Header " + str;
        UnaryOperator<String> spellProcessing = str -> "Spell " + str;

        Function<String,String> pipeline = headerProcessing.compose(spellProcessing);
        System.out.println(pipeline.apply("哈哈哈，这个责任链模式太简单了"));

    }

}

//interface ProcessingObjectInterface<T>{
//    T handel(T input);
//    T handelWork(T input);
//    void setSuccesser(ProcessingObjectInterface<T> successer);
//}
//
//abstract class ProcessingObject<T> implements ProcessingObjectInterface<T>{
//
//    protected ProcessingObjectInterface<T> successer;
//
//    @Override
//    public T handel(T input){
//        T r = handelWork(input);
//        if(Optional.ofNullable(successer).isPresent()){
//            return successer.handel(input);
//        }
//        return r;
//    }
//
//    @Override
//    public void setSuccesser(ProcessingObjectInterface<T> successer) {
//        this.successer = successer;
//    }
//}
//
//class HeaderTextProcessing extends ProcessingObject<String>{
//
//    @Override
//    public String handelWork(String input) {
//        return "Header " + input;
//    }
//}
//
//class SpellCheckerProcessing extends ProcessingObject<String>{
//
//    @Override
//    public String handelWork(String input) {
//        return input += "30";
//    }
//}
