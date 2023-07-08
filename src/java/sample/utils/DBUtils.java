/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class DBUtils {

    private static final String USER_NAME = "sa";
    private static final String PASSSWORD = "12345";
    private static final String DB = "UserManagement";

    public static Connection getConnectionV1() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        //load thu vien jdbc
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost;databaseName=" + DB;
        conn = DriverManager.getConnection(url, USER_NAME, PASSSWORD);
        return conn;
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        Connection conn = null;
        Context context = new InitialContext();
        Context end = (Context) context.lookupLink("java:comp/env");
        DataSource ds = (DataSource) end.lookup("DBCon");
        conn = ds.getConnection();
        return conn;
    }
}
