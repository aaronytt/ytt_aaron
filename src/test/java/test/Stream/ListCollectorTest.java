package test.Stream;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ListCollectorTest {

    @Test
    public void testListCollector(){
        String[] strs = {"1","2","3","4"};

        List<String> stringList = Arrays.stream(strs).parallel().collect(new ListCollector<String>());

        System.out.println(stringList.getClass());
        System.out.println(stringList);
    }

}

class ListCollector<T> implements Collector<T,List<T>,List<T>> {
    @Override
    public Supplier<List<T>> supplier() {
        System.out.println("supplier=>>> 创建一个容器");
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        System.out.println("accumulator=>>> 创建一个累加器");
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        System.out.println("combiner=>>> 创建一个组合器");
        return (l1,l2) -> {
            l1.addAll(l2);
            System.out.println("combiner=>>> 执行组合");
            return l1;
        };
//        return null;
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        System.out.println("finisher=>>> 创建一个最终结果转换器");
        return (list) -> {
            System.out.println("finisher=>>> 执行最终结果转换器");
            return (List<T>)list;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT,Characteristics.IDENTITY_FINISH));
    }
}


