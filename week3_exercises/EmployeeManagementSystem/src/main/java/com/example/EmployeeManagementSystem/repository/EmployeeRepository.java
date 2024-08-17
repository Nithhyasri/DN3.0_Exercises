package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeFullNameProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeNameAndDepartmentProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Sort;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(name = "Employee.findByEmailNamed")
    Employee findByEmail(@Param("email") String email);
    
    // Method to paginate employees
    Page<Employee> findAll1(Pageable pageable);
    
    // Method to sort employees by a given field
    List<Employee> findAll(Sort sort);
    
    // Method to paginate and sort employees
    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT e.name AS name, d.name AS departmentName FROM Employee e JOIN e.department d")
    List<EmployeeNameAndDepartmentProjection> findEmployeeNamesAndDepartments();
    

    List<EmployeeFullNameProjection> findBy(); // Fetches all employees with full name

}