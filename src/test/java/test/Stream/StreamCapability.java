package test.stream;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCapability {

    public void testStreamCapability(Function<Long,Long> function,Long value){

        long second = Long.MAX_VALUE;

        for (int i = 0; i <10; i++) {
            long time1 = System.nanoTime();
            long sum = function.apply(value);
            System.out.println("sum: " + sum);
            long time2 = System.nanoTime();
            second = second < time2 - time1 ? second : time2 - time1;
        }
        System.out.println("time:" + second + "ms");
    }

    @Test
    public void testStreamCapability(){

        testStreamCapability(parallelStreams::sum,100l);
//        testStreamCapability(parallelStreams::sumi,100l);
        testStreamCapability(parallelStreams::sump,100l);

    }

}

class parallelStreams{

    public static long sum(long a){
        return Stream.iterate(1l, i -> i+1l).limit(a).parallel().reduce(0l,Long::sum);
    }

    public static long sump(long a){
        return LongStream.rangeClosed(1,a).parallel().reduce(0l,Long::sum);
    }

    public static long sumi(long a){
        long result = 0;
        for (int i = 0; i <= a; i++) {
            result += i;
        }
        return result;
    }
}
