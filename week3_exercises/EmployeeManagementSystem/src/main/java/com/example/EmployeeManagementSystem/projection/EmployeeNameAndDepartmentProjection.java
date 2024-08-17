package com.example.EmployeeManagementSystem.projection;

public interface EmployeeNameAndDepartmentProjection {

    String getName();         // Fetch the employee's name

    String getDepartmentName(); // Fetch the department's name (via JOIN)
}
