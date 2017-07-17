package com.jdbc;

public class Employee {
    private int eid;
    private String name;
    private String mailID;
    private int salary;

    public Employee(int eid, String name, String mailID, int salary) {
        this.eid = eid;
        this.name = name;
        this.mailID = mailID;
        this.salary = salary;
    }

    public int getEid() {

        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
