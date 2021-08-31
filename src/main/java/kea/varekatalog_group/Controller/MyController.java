package kea.varekatalog_group.Controller;

import kea.varekatalog_group.data.ProductMapper;
import kea.varekatalog_group.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller

public class MyController {

  private ProductMapper productMapper;

    public MyController() {
        this.productMapper = new ProductMapper();
    }

    @GetMapping("/")
    public String getHome() {
        return "index";
    }


    @PostMapping("/createProduct")
    public String createProduct(WebRequest request) {
        String product_name = request.getParameter("product_name");
        String product_price = request.getParameter("product_price");
        Product product = new Product(product_name,Integer.valueOf(product_price));
        productMapper.createProduct(product);
        return "index";

    }

//    @GetMapping("/getProduct")
//    public String getProduct(WebRequest webRequest) {
//
//    }

}
