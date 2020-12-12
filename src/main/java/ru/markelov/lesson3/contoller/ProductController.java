package ru.markelov.lesson3.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.markelov.lesson3.model.Product;
import ru.markelov.lesson3.servis.ProductRepository;
import ru.markelov.lesson3.servis.ProductServis;

@Controller
@ComponentScan("ru.markelov.lesson3.")
@RequestMapping("/product")
public class ProductController {

    private ProductServis productServis;

    @Autowired
    public ProductController(ProductServis productServis) {
        this.productServis = productServis;
    }

    @GetMapping("/showall")
    public String show(Model model){
        model.addAttribute("productList",productServis.getList());
        return "show_all";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id" ) Integer id, @RequestParam("title" ) String title, @RequestParam("cost" ) Integer cost){
        Product product = new Product(id, title, cost);
        productServis.addProduct(product);
        return "redirect:/product/showall";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productServis.remove(id);
        return "redirect:/product/showall";
    }
}
