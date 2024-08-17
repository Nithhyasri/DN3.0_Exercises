package com.example.EmployeeManagementSystem.projection;

public class DepartmentDTO {

    private Long id;
    private String name;

    // Constructor for projection
    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
