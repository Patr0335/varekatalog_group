package kea.varekatalog_group.data;

import kea.varekatalog_group.domain.Product;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

public class ProductMapper {

    public void createProduct(Product product) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO product (product_name,product_price) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getProduct_name());
            ps.setInt(2, product.getProduct_price());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();

            int id = ids.getInt(1);
            product.setId(id);

        } catch (SQLException | FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }


    public Product getProduct(String product_name, int product_price) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT product_name, product_price FROM product";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                Product product = new Product(id, product_name, product_price);
                return product;
            }

        } catch (SQLException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Product> getProjectList(int id) {
        ArrayList<Product> products = new ArrayList();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT * FROM product WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
//                String task_name = rs.getString("task_name");
//                subtasks.add(new Product(, task_name));
            }
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return products;

    }
}
