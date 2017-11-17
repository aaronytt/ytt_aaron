package test.design_patterns;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

public class FactoryModeTest {

    @Test
    public void testFactoryMode(){
        System.out.println(new ProductFactory().getProduct("fish").getClass());
    }

}

class ProductFactory{

    protected static final Map<String,Supplier<Product>> productFactory = new HashMap<String,Supplier<Product>>();

    static {
        productFactory.put("fish",FishProduct::new);
        productFactory.put("beef",BeefProduct::new);
    };

//还要判断，太繁琐
//    public Product getProduct(String name){
//
//        switch (name){
//            case "fish" : new FishProduct();
//            case "beef" : new BeefProduct();
//            default: throw new NoSuchElementException(name);
//        }
//
//    }

    //用方法引用多么好理解，多牛逼
    public Product getProduct(String name){
        Supplier<Product> p = productFactory.get(name);

        if(Optional.ofNullable(p.get()).isPresent()){
            return p.get();
        }

        return null;
    }

}

class Product{

}

class FishProduct extends Product{

}

class BeefProduct extends Product{

}
