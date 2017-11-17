package test.future;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

public class DiscountTest{

    @Test
    public void testDiscount(){
        long time1 = System.nanoTime();

        List<String> p =  new Discount(
                new ArrayList<ShopModel>(){{
                    add(new ShopModel("ytt"));
                    add(new ShopModel("xxt"));
                    add(new ShopModel("nxzd"));
                }}
        ).findPrices("latiao");

        p.forEach(System.out::println);

        long time2 = System.nanoTime();

        System.out.println((time2 - time1)/1000000);

    }

}

class Discount {

    private List<ShopModel> shopModels;

    private final Executor executor;

    public Discount(List<ShopModel> shopModels) {
        this.shopModels = shopModels;

        executor = Executors.newFixedThreadPool(Math.min(shopModels.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return  thread;
            }
        });
    }

    public enum Code{
        NONE(0),SILVER(5),GOLD(10);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscout(Quote quote){
        return quote.getShopName() + " price :" + apply(quote.getPrice(),quote.getDiscount());
    }

    private static String apply(Double price, Code discount) {
        delay();
        return price * (100 - discount.percentage) / 100 + "";
    }

    private static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public List<String> findPrices(String product){
//        return shopModels
//                .stream()
//                .map(shopModel -> shopModel.getPrice(product))
//                .map(Quote::parse)
//                .map(Discount::applyDiscout)
//                .collect(toList());
//    }

//        public List<String> findPrices(String product){
//            return shopModels
//                    .stream()
//                    .parallel()
//                    .map(shopModel -> shopModel.getPrice(product))
//                    .map(Quote::parse)
//                    .map(Discount::applyDiscout)
//                    .collect(toList());
//        }

//    public List<String> findPrices(String product){
//        List<CompletableFuture<String>> futures =
//                shopModels.stream()
//                        .map(shopModel -> CompletableFuture.supplyAsync(() -> shopModel.getPrice(product), executor))
//                        .map(future -> future.thenApply(Quote::parse))
//                        .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscout(quote),executor)))
//                        .collect(toList());
//        return futures.stream().map(CompletableFuture::join).collect(toList());
//    }

    public List<String> findPrices(String product){
        CompletableFuture[] futures =
                shopModels.stream()
                        .map(shopModel -> CompletableFuture.supplyAsync(() -> shopModel.getPrice(product), executor))
                        .map(future -> future.thenApply(Quote::parse))
                        .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscout(quote),executor)))
                        .map(future -> future.thenAccept(System.out::println)).toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(futures).join();

        return new ArrayList<>();
    }

}

class Quote{
    private final String shopName;
    private final Double price;
    private final Discount.Code discount;

    public Quote(String shopName, Double price, Discount.Code discount) {
        this.shopName = shopName;
        this.price = price;
        this.discount = discount;
    }

    public static Quote parse(String str){
        String[] strs = str.split(":");
        return new Quote(strs[0],Double.parseDouble(strs[1]),Discount.Code.valueOf(strs[2]));
    }

    public String getShopName() {
        return shopName;
    }

    public Double getPrice() {
        return price;
    }

    public Discount.Code getDiscount() {
        return discount;
    }
}

class ShopModel{


    private static final Random random = new Random();

    private final String shopName;

    public ShopModel(String shopName) {
        this.shopName = shopName;
    }

    public String getPrice(String product){
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s",shopName,price,code);

    }

    private double calculatePrice(String product){
        delay();
        return 100;
    }

    private static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


