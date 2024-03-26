package org.crm;

public class Student {
    private long id;
    private String pip;
    private String group_name;
    private String year_entry;
    private String phone_number;
    private String statement;
    private boolean status;

    public Student(long id, String pip, String group, String year_entry, String phoneNumber, String statement) {
        this.id = id;
        this.pip = pip;
        this.group_name = group;
        this.year_entry = year_entry;
        this.phone_number = phoneNumber;
        this.statement = statement;
    }

    public long getId() {
        return id;
    }

    public String getPip() {
        return pip;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getYear_entry() {
        return year_entry;
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

    public void setStatus(boolean status) {
        this.status = status;
    }
}
