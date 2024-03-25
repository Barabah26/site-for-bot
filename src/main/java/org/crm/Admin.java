package org.crm;

public class Admin {
    private long id;
    private String login;
    private String password;

    public Admin(long id ,String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }
}
