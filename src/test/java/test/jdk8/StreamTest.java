package test.jdk8;

public class StreamTest {

    final static String[] strings = {"1","3"};

    public static void main(String[] args) {

//        List<Apple> apples = new ArrayList<Apple>();
//
//        apples.add(new Apple());
//        apples.add(new Apple());
//        apples.add(new Apple());
//        apples.add(new Apple());
//
//        final AtomicInteger i = new AtomicInteger(0);
//
//        apples.parallelStream().forEach(apple -> {
//            apple.setName(i.addAndGet(1)+"");
//        });
//
//        for (Apple apple : apples) {
//            apple.setName(i.addAndGet(1)+"");
//        }
//
//        for (int j = 0; j < apples.size(); j++){
//
//            apples.get(j).setName(i.addAndGet(1)+"");
//
//        }

//        Apple[] apples = {new Apple(),new Apple(),new Apple(),new Apple()};
//
//        for (Apple apple : apples) {
//            apple.setName(i.addAndGet(1)+"");
//        }
//
//        for (Apple apple : apples) {
//            System.out.println(apple.getName());
//        }

        String[] strs;

        strs = strings;

        System.out.println(strs.length);

    }

}
