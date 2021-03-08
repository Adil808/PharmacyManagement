package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Medicament;
import com.company.repositories.interfaces.IMedicamentRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentRepo implements IMedicamentRepo {
    private final IDB db;
    public MedicamentRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createMedicament(Medicament medicament) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO medicament(name,cost,description) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, medicament.getName());
            st.setInt(2, medicament.getCost());
            st.setString(3, medicament.getDescription());


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

    @Override
    public Medicament getMedicamentById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT  id,name,cost,description FROM medicament WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicament medicament = new Medicament(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getString("description")
                );

                return medicament;
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
    public List<Medicament> getAllMedicaments() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,cost,description FROM medicament";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
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
}
