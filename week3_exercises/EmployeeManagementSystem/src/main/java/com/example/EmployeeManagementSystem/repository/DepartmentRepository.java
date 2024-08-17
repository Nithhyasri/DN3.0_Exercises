package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Department;
import com.example.EmployeeManagementSystem.projection.DepartmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT new com.example.EmployeeManagementSystem.projection.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findDepartmentDTOs();
    }
