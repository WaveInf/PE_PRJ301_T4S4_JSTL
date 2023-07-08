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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class OrderDAO {

    private static final String ORDER_LIST = "SELECT OrderID, Date, ProductID, Price, Quantity from tblOrders where UserID = ?";
    private static final String ALL_ORDER = "SELECT OrderID, UserID, Date, ProductID, Price, Quantity from tblOrders";
    private static final String INSERT = "INSERT INTO tblOrders (UserID, Date, ProductID, Price, Quantity, Total) VALUES(?,?,?,?,?,?)";
    private static final String DELETE = "DELETE tblOrders where OrderID = ?";

    public ProductDAO getDAO(){
        return new ProductDAO();
    }
    
    public List<OrderDTO> getListOrder(String userID) throws SQLException {
        List<OrderDTO> list = new ArrayList<OrderDTO>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;      
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ORDER_LIST);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    OrderDTO order = new OrderDTO();
                    order.setOrderID(rs.getString("OrderID"));;
                    order.setUserID(userID);
                    String date = rs.getString("Date");
                    order.setDate(date);
                    ProductDTO product = getDAO().getProduct(rs.getString("ProductID"));
                    order.setProductName(product.getName());
                    order.setPrice(rs.getDouble("Price"));
                    order.setQuantity(rs.getInt("Quantity"));
                    list.add(order);
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

    public List<OrderDTO> getAllOrder() throws SQLException {
        List<OrderDTO> list = new ArrayList<OrderDTO>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;      
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ALL_ORDER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    OrderDTO order = new OrderDTO();
                    order.setOrderID(rs.getString("OrderID"));;
                    order.setUserID(rs.getString("UserID"));
                    System.out.println(rs.getString("UserID"));
                    String date = rs.getString("Date");
                    order.setDate(date);
                    ProductDTO product = getDAO().getProduct(rs.getString("ProductID"));
                    order.setProductName(product.getName());
                    order.setPrice(rs.getDouble("Price"));
                    order.setQuantity(rs.getInt("Quantity"));
                    list.add(order);
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
    
    public boolean insert(String productID, String userID, int quantity) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, userID);
                ptm.setString(2, timeStamp);
                ptm.setString(3, productID);
                ProductDTO pro = getDAO().getProduct(productID);
                double price = pro.getPrice();
                ptm.setDouble(4, price);
                ptm.setInt(5, quantity);
                ptm.setDouble(6, price*quantity);
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
     public boolean delete(String orderID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {

                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, orderID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
