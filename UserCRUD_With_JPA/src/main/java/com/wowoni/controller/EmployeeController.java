package com.wowoni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wowoni.entity.Employee;
import com.wowoni.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employee) {
		return service.saveEmployees(employee);
	}

	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return service.getEmployees();
	}

	@GetMapping("/emp/{id}") // used path variable to avoid the 404 error
	public String findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}

	@GetMapping("/employee/{name}")
	public String findEmployeeByName(@PathVariable String name) {
		return service.getEmployeeByName(name);
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}

}
