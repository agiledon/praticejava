package xyz.zhangyi.practicejava.design.patterns.templatemethod.composemethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartDB {
    private static final String DRIVER_CLASS = "";
    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private List<Part> partList = new ArrayList<Part>();

    public void populate() throws Exception {
        Connection c = null;
        try {
            Class.forName(DRIVER_CLASS);
            c = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from part");
            while (rs.next()) {
                Part p = new Part();
                p.setName(rs.getString("name"));
                p.setBrand(rs.getString("brand"));
                p.setRetailPrice(rs.getDouble("retail_price"));
                partList.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }
}