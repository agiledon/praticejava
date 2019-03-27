package xyz.zhangyi.practicejava.design.slap.service;


import xyz.zhangyi.practicejava.design.slap.entity.Customer;
import xyz.zhangyi.practicejava.design.slap.entity.Training;
import xyz.zhangyi.practicejava.design.slap.infrastructure.DatabasePool;

import java.sql.*;
import java.util.List;

public class TrainingService {
    private DatabasePool dbPool;

    public void subscribe(List<Training> trainings, Customer customer) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet rs = null;
        boolean transactionState = false;
        try {
            s = c.createStatement();
            transactionState = c.getAutoCommit();
            c.setAutoCommit(false);
            for (Training training : trainings) {
                addTrainingItem(customer, training);
            }
            addOrder(customer, trainings);
            c.commit();
        } catch (SQLException sqlx) {
            c.rollback();
            throw sqlx;
        } finally {
            try {
                c.setAutoCommit(transactionState);
                dbPool.release(c);
                if (s != null) s.close();
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (SQLException ignored) {
            }
        }
    }

    private void addOrder(Customer customer, List<Training> trainings) {


    }

    private void addTrainingItem(Customer customer, Training training) {


    }
}
