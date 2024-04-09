package org.crm;

public class Student {
    private long id;
    private String full_name;
    private String groupe;
    private String phone_number;
    private String statement;
    private boolean status;
    private Long telegramId;
    private String year_entry;


    public Student(long id, String full_name, String groupe, String phone_number, String statement, String year_entry) {
        this.id = id;
        this.full_name = full_name;
        this.groupe = groupe;
        this.phone_number = phone_number;
        this.statement = statement;
        this.year_entry = year_entry;
    }

    public long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getStatement() {
        return statement;
    }

    public boolean isStatus() {
        return status;
    }

    public Long getTelegramId() {
        return telegramId;
    }

    public String getYear_entry() {
        return year_entry;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
