package test.future;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class FuntureTest {

    @Test
    public void testFuntureAsync(){

        Future<Double> priceFuture1 = Shop.createShop("1").getPriceAsync("1");
        Future<Double> priceFuture2 = Shop.createShop("2").getPriceAsync("2");
        Future<Double> priceFuture3 = Shop.createShop("3").getPriceAsync("3");

        try {
            Double price1 = priceFuture1.get();
            System.out.println("1最终的结果:" + price1);
            Double price2 = priceFuture2.get();
            System.out.println("2最终的结果:" + price2);

            Double price3 = priceFuture3.get();
            System.out.println("3最终的结果:" + price3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




    }

}


class Shop{

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public static Shop createShop(String name){
        return new Shop(name);
    }

//    public Future<Double> getPriceAsync(String goodName){
//
//        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
//
//        new Thread(() -> {
//
//            for (int i = 0; i < 5; i++) {
//
//                System.out.println(name + ",我在努力计算  " +  goodName +" 价格》》》" + System.currentTimeMillis());
//
//                try {
//                    Thread.sleep(((int)Math.random() * 10000)/100);
//                } catch (InterruptedException e) {
//
//                }
//
//            }
//
//            try {
//                completableFuture.complete(Integer.parseInt("jjjjj") * 1.1);
//            } catch (Exception e) {
//                completableFuture.completeExceptionally(e);
//            }
//
//        }).start();
//
//        return completableFuture;
//
//    }

    public Future<Double> getPriceAsync(String goodName){

        return CompletableFuture.supplyAsync(() -> {
                for (int i = 0; i < 5; i++) {

                    System.out.println(name + ",我在努力计算  " +  goodName +" 价格》》》" + System.currentTimeMillis());

                    try {
                        Thread.sleep(((int)Math.random() * 10000)/100);
                    } catch (InterruptedException e) {

                    }

                }


            return System.currentTimeMillis() / 1000000.0;
        });

    }

    public class good{

        private Double price;

        public good(Double price) {
            this.price = price;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
