package kea.varekatalog_group.data;

import kea.varekatalog_group.domain.Product;

import java.io.FileNotFoundException;
import java.sql.*;

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
//          ps.setString(1, product_name);
//          ps.setInt(2, product_price);

          ResultSet rs = ps.executeQuery();
          if (rs.next()) {
              int id = rs.getInt("id");
              Product product = new Product(id, product_name, product_price);
              return product;
          }

      }catch (SQLException | FileNotFoundException ex) {
        ex.printStackTrace();
      }
      return null;
    }
}
