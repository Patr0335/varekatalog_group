package kea.varekatalog_group.Controller;

import kea.varekatalog_group.data.DBManager;
import kea.varekatalog_group.data.ProductMapper;
import kea.varekatalog_group.domain.Product;

import java.sql.Connection;
import java.util.ArrayList;

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

//    public ArrayList<Product> getSubtaskList(int project_id){
//        ArrayList<Subtask> subtasks = this.subtaskMapper.getSubtaskList(project_id);
//        for (int subtasksIndex = 0; subtasksIndex < subtasks.size(); subtasksIndex++) {
//            Subtask subtask = subtasks.get(subtasksIndex);
//            int subtaskId = subtask.getId();
//            ArrayList<SubTaskRoleViewModel> subtaskRoles = subtaskRoleMapper.getRolesFromSubtask(subtaskId);
//            subtask.setSubtaskRoleList(subtaskRoles);
//            subtasks.set(subtasksIndex,subtask);
//        }
//        return subtasks;
    }



