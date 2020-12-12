package ru.markelov.lesson3.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.markelov.lesson3.model.Product;

import java.util.List;

@Component
public class ProductServis {

    private ProductRepository productRepositoryt;

    @Autowired
    public ProductServis(ProductRepository productRepositoryt) {
        this.productRepositoryt = productRepositoryt;
    }

    public List<Product> getList(){
        return productRepositoryt.getList();
    }

    public void addProduct(Product product){
        productRepositoryt.addProduct(product);
    }

    public void remove(int id){
       productRepositoryt.remove(id);
    }
}
