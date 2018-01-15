package test.spEL;

import org.aspectj.weaver.ast.Expr;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import javax.script.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

public class ScriptSample {

    private final static int[] targerIdsofMoney = {3,4,5,6};

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
//        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
//        String scriptText = "function sum(a,b){ return a + b; }";
//        scriptEngine.eval(scriptText);
//        Invocable invocable = (Invocable)scriptEngine;
//        System.out.println(invocable.invokeFunction("sum",10 + "",20));
//
//        ExpressionParser expressionParser = new SpelExpressionParser();
//        Expression expression = expressionParser.parseExpression("1 + 2");
//        Integer message = (Integer)expression.getValue();
//        System.out.println(message);

//        NumberFormat numberFormat = NumberFormat.getNumberInstance();
//        numberFormat.setMaximumFractionDigits(2);
//
//        System.out.println(100.0/20);
//        System.out.println(numberFormat.format(100.0/3));
//
//        System.out.println(Arrays.binarySearch(targerIdsofMoney,Integer.valueOf(4)));


//        long time1 = System.currentTimeMillis();
//        IntStream.rangeClosed(1,100).boxed().flatMap(a ->
//                IntStream.rangeClosed(a,100)
//                        .mapToObj(b ->new double[]{a,b,Math.sqrt(a*a+b*b)})
//                        .filter(t -> t[2] % 2 == 0));
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);
//
//        long time11 = System.currentTimeMillis();
//        IntStream.rangeClosed(1,100).boxed().flatMap(a ->
//                IntStream.rangeClosed(a,100)
//                        .filter(b -> Math.sqrt(b*b + a*a ) % 1 == 0)
//                        .mapToObj(b ->new double[]{a,b,Math.sqrt(a*a+b*b)})
//                        .filter(t -> t[2] % 2 == 0));
//        long time21 = System.currentTimeMillis();
//        System.out.println(time21-time11);
//
//        Arrays.stream(new String[]{"1","2"});
//        stream.of(new String[]{"1","2"});
//        Arrays.asList(new String[]{"1","2"}).stream().forEach(b -> System.out.format("[%s,%s]",b[0],b[1]));

        System.out.println(Stream.iterate(1 ,b -> 1 + b).limit(10).map(b -> b + "").collect(counting()));
        System.out.println(Stream.iterate(1 ,b -> 1 + b).limit(10).map(b -> b + "").collect(reducing((a,b)-> a+b)).orElse("0"));
        System.out.println(Stream.iterate(1 ,b -> 1 + b).limit(10).collect(reducing("",a -> a + "",(a,b)-> a + b)));
        System.out.println(Stream.iterate(1 ,b -> 1 + b).limit(10).map(b -> b + "").collect(joining(",","[","]")));



    }

    class User{

    }
}
