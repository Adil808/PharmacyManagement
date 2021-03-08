package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Bind;
import com.company.repositories.interfaces.IBindRepo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BindRepo implements IBindRepo {
    private final IDB db;
    public BindRepo(IDB db){this.db = db;};

    @Override
    public boolean createBind(Bind bind) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO bind(order_id,med_id) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, bind.getOrder_id());
            st.setInt(2, bind.getMed_id());



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
