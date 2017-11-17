package test.Stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberCollectorTest {

    public static void main(String[] args) {

        System.out.println(IntStream.rangeClosed(2,100).boxed().collect(new PrimeNumberCollector()).toString());

    }

}

class PrimeNumberCollector implements Collector<Integer,Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>>{

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        System.out.println("supplier=>>> 创建一个容器");
        return () -> {
            return new HashMap<Boolean,List<Integer>>(){{
                put(true,new ArrayList<Integer>());
                put(false,new ArrayList<Integer>());
            }};
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        System.out.println("accumulator=>>> 创建一个累加器");
        return (haspMap,num) -> {
            haspMap.get(isPrime(haspMap.get(true),num)).add(num);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        System.out.println("combiner=>>> 创建一个组合器");
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>>map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            System.out.println("combiner=>>> 执行组合");
            return map1;
        } ;
    }

//    @Override
//    public Function<Map<Boolean, List<Integer>>, Map<Integer, List<Integer>>> finisher() {
//        return (Map<Boolean, List<Integer>> map) -> new HashMap<Integer, List<Integer>>(){{
//            put(1,map.get(true));
//            put(0,map.get(false));
//            System.out.println("finisher=>>> 执行最终结果转换器");
//        }};
//    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {

//        return (Map<Boolean, List<Integer>> p) ->{
//            System.out.println("finisher=>>> 执行最终结果转换器");
//            return p;
//        };
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public boolean isPrime(List<Integer> primeList,Integer value){
        int valueSqrt = (int)Math.sqrt(value);
        return taskWhile(primeList,i -> i <= valueSqrt).stream().noneMatch(p -> value % p == 0);
    }

    public <A> List<A> taskWhile(List<A> list, Predicate<A> test){

        int i = 0;

        for (A a: list) {
            if(test.test(a)){
                list.subList(0,i);
            }
            i++;
        }
        return  list;
    }
}