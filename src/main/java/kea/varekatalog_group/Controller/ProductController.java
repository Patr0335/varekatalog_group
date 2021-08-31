package kea.varekatalog_group.Controller;

import kea.varekatalog_group.data.DBManager;
import kea.varekatalog_group.data.ProductMapper;
import kea.varekatalog_group.domain.Product;

import java.sql.Connection;

public class ProductController {

    private ProductMapper productMapper;

    public ProductController(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Product createProduct(String product_name, int product_price) {
        Product product = new Product(product_name, product_price);
        productMapper.createProduct(product);
        return product;
    }

    public Product getProduct(String product_name, int product_price) {
      return this.productMapper.getProduct(product_name, product_price);
    }

    }

