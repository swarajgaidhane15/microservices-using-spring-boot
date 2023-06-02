package com.springboot.departmentservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.departmentservice.model.Department;
import com.springboot.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

  @Autowired
  private DepartmentRepository departmentRepository;

  @GetMapping
  public List<Department> findAll() {
    LOGGER.info("Get departments");
    return departmentRepository.findAll();
  }

  @PostMapping
  public Department add(@RequestBody Department department) {
    LOGGER.info("Add department: {}", department);
    return departmentRepository.addDepartment(department);
  }

  @GetMapping("/{id}")
  public Department findById(@PathVariable Long id) {
    LOGGER.info("Get department by id: {}", id);
    return departmentRepository.findById(id);
  }
}
