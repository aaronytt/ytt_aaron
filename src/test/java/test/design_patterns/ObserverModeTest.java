package test.design_patterns;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObserverModeTest {

    @Test
    public void testObserverMode(){

        Subject subject = new Feed();
        //这他妈什么啊，太繁琐了，还得写观察者实体类实现
//        subject.regiterObserver(new NYTimes());
//        subject.regiterObserver(new Guardian());

        //可以不写 String 定义tweet，会自动推断类型的
        //函数式编程就是这么清爽
        subject.regiterObserver(tweet -> {
            if(Optional.ofNullable(tweet).isPresent() && tweet.contains("money")){
                System.out.println("Breaking news in NY !" + tweet);
            }
        });

        subject.regiterObserver(tweet -> {
            if(Optional.ofNullable(tweet).isPresent() && tweet.contains("queen")){
                System.out.println("Yet another news in London..." + tweet);
            }
        });

        subject.notifyObserver("money queen");
    }

}

interface Observer{
    void notify(String tweet);
}

//class NYTimes implements Observer{
//
//    @Override
//    public void notify(String tweet) {
//        if(Optional.ofNullable(tweet).isPresent() && tweet.contains("money")){
//            System.out.println("Breaking news in NY !" + tweet);
//        }
//    }
//}
//
//class Guardian implements Observer{
//
//    @Override
//    public void notify(String tweet) {
//        if(Optional.ofNullable(tweet).isPresent() && tweet.contains("queen")){
//            System.out.println("Yet another news in London..." + tweet);
//        }
//    }
//}

interface Subject{
    void regiterObserver(Observer o);
    void notifyObserver(String tweet);
}

class Feed implements Subject{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void regiterObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver(String tweet) {
        observers.forEach( o -> o.notify(tweet));
    }
}