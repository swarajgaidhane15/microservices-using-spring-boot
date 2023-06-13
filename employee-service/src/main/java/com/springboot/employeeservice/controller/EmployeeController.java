package com.springboot.employeeservice.controller;

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

import com.springboot.employeeservice.model.Employee;
import com.springboot.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping
  public List<Employee> getAllEmployees() {
    LOGGER.info("Employees findAll");
    return employeeRepository.findAll();
  }

  @PostMapping
  public Employee add(@RequestBody Employee employee) {
    LOGGER.info("Employee add: {}", employee);
    return employeeRepository.addEmployee(employee);
  }

  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable("id") Long id) {
    LOGGER.info("Employees find by id: {}", id);
    return employeeRepository.findById(id);
  }

  @GetMapping("/department/{departmentId}")
  public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
    LOGGER.info("Employees find by department: {}", departmentId);
    return employeeRepository.findByDepartment(departmentId);
  }
}
