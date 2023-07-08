/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class ProductDAO {
    private static final String PRODUCT_LIST = "SELECT ProductID, Name, Price from tblProducts";
    private static final String GET_PRODUCT = "SELECT Name, Price from tblProducts where ProductID = ?";
    
    public List<ProductDTO> getListProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(PRODUCT_LIST);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    ProductDTO pro = new ProductDTO();
                    pro.setProID(rs.getString("ProductID"));
                    pro.setName(rs.getString("Name"));
                    pro.setPrice(rs.getDouble("Price"));
                    list.add(pro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public ProductDTO getProduct(String productID) throws SQLException {
        ProductDTO pro = new ProductDTO();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCT);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    pro.setProID(productID);
                    pro.setName(rs.getString("Name"));
                    pro.setPrice(rs.getDouble("Price"));
                    pro.setQuantity(rs.getInt("Quantity"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pro;
    }
    
    
}
