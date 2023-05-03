package com.example.entitymapping.oneToOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    @Id
    private int id;
    private String password;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Employee employee;

    public Account(int id, String password, Employee employee) {
	super();
	this.id = id;
	this.password = password;
	this.employee = employee;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Employee getEmployee() {
	return employee;
    }

    public void setEmployee(Employee employee) {
	this.employee = employee;
    }

}
