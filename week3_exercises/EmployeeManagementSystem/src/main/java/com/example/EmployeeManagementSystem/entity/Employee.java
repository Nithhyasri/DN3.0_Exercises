package com.example.EmployeeManagementSystem.entity;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.NaturalId;

import com.example.EmployeeManagementSystem.entity.base.Auditable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import org.hibernate.annotations.ParamDef;


@Entity
@DynamicUpdate
@DynamicInsert

@BatchSize(size = 10)
@FilterDef(name = "activeEmployeeFilter", parameters = @ParamDef(name = "isActive", type = Boolean.class))
@Filter(name = "activeEmployeeFilter", condition = "active = :isActive")

@NamedQuery(
    name = "Employee.findByEmailNamed",
    query = "SELECT e FROM Employee e WHERE e.email = :email"
)
public class Employee extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @NaturalId
    private String email;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

