package org.crm.services;

import org.crm.Admin;
import org.crm.dao.CollectionAdminDAO;
import java.util.List;
import java.util.Optional;

public class AdminService {
    CollectionAdminDAO collectionAdminDAO;

    public AdminService(CollectionAdminDAO collectionAdminDAO) {
        this.collectionAdminDAO = collectionAdminDAO;
    }

    public List<Admin> getAdminByLoginAndPasswordFromDB(String login, String password){
        return collectionAdminDAO.getAdminByLoginAndPasswordFromDB(login, password);

    }

    public Optional<Admin> getAdminById(long id) {
        return collectionAdminDAO.getAdminById(id);
    }

    public Optional<Admin> getAdminByLoginAndPassword(String login, String password) {
        return collectionAdminDAO.getAdminByLoginAndPassword(login, password);
    }

    public boolean saveAdmin(Admin admin) {
        return collectionAdminDAO.saveAdmin(admin);
    }
}
