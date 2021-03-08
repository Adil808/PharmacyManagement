package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Medicament;
import com.company.entities.Order;
import com.company.repositories.interfaces.IOrderRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo implements IOrderRepo {
    private final IDB db;
    public OrderRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createOrder(Order order) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO order1(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, order.getName());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Order getOrderById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,cost FROM order1 WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order order = new Order(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost")
                );

                return order;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Medicament> getMedicamentsByOrder(int id) {
        Connection con = null;
        try {
            con = db.getConnection();


            String sql =  "SELECT medicament.id,medicament.name,medicament.cost,medicament.description FROM medicament join bind ON bind.med_id=medicament.id WHERE bind.order_id=?;" ;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Medicament> medicamentList = new ArrayList<>();
            while (rs.next()) {
                Medicament medicament = new Medicament(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getString("description")
                );

                medicamentList.add(medicament);
            }

            return medicamentList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,cost FROM order1";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost")
                );

                orders.add(order);
            }

            return orders;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean UpdateOrderById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "Update order1 set cost=(SELECT SUM (medicament.cost) FROM medicament join bind on bind.med_id=medicament.id WHERE  bind.order_id=?) from bind  WHERE  bind.order_id=? and order1.id=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, id);
            st.setInt(3, id);

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
