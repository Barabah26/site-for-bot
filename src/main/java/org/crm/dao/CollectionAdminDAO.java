package org.crm.dao;

import org.crm.Admin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionAdminDAO implements AdminDAO{

    private static final String GET_ALL_ADMINS = """
            SELECT id, login, password
                    FROM admins
                    WHERE login = ? AND password = ?""";

    private final Connection conn;
    private List<Admin> adminList;

    public CollectionAdminDAO(Connection conn) {
        this.conn = conn;
        this.adminList = new ArrayList<>();
    }

    public List<Admin> getAdminByLoginAndPasswordFromDB(String login, String password){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(GET_ALL_ADMINS);

            ps.setString(1, login);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next()){
                Admin admin = new Admin(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("password")
                );
                saveAdmin(admin);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Closing resources in finally block to ensure they are released properly
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return adminList;

    }

    @Override
    public Optional<Admin> getAdminById(long id) {
        return adminList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Admin> getAdminByLoginAndPassword(String login, String password) {
        return adminList.stream()
                .filter(c -> c.getLogin().equals(login) && c.getPassword().equals(password))
                .findFirst();
    }

    @Override
    public boolean saveAdmin(Admin admin) {
        int indexOfAdmin =adminList.indexOf(admin);

        if (indexOfAdmin != -1){
            adminList.set(indexOfAdmin, admin);
        } else {
            adminList.add(admin);
        }
        return true;
    }
}
