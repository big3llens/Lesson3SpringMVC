package ru.markelov.lesson3.servis;

import org.springframework.stereotype.Component;
import ru.markelov.lesson3.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(1, "Apple", 40));
        productList.add(new Product(2, "Orange", 55));
        productList.add(new Product(3, "Pasta", 45));
        productList.add(new Product(4, "Milk", 60));
        productList.add(new Product(5, "Meat", 90));
    }

    public List<Product> getList(){
        return productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void remove(int id){
//        for (Product p: productList) {
//            if(id == p.getId()) productList.remove(p);
//        }
        productList.removeIf(b -> b.getId() == id);
    }
}
