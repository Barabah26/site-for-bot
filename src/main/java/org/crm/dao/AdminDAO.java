package org.crm.dao;

import org.crm.Admin;

import java.util.Optional;

public interface AdminDAO {
    Optional<Admin> getAdminById(long id);
    Optional<Admin> getAdminByLogin(String login, String password);
    boolean saveAdmin(Admin admin);
}
