package org.crm;

public class Admin {
    private long id;
    private String login;
    private String password;
    private String username;

    public Admin(long id ,String login, String password, String username) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
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

    public String getUsername() {
        return username;
    }
}
