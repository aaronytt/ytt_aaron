package test;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PartitioningByTest {

    public boolean isPrime(int value){
        int valueSqrt = (int)Math.sqrt(value);
        return IntStream.range(2,value).noneMatch(i -> valueSqrt % i == 0);
    }

    public Map<Boolean,List<Integer>> partitioningPrime(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(partitioningBy(val -> isPrime(val)));
    }

    @Test
    public void testPartitioningBy(){
        System.out.println(partitioningPrime(100).get(true));
    }

}
