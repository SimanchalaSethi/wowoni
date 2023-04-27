package com.wowoni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowoni.entity.Employee;
import com.wowoni.repository.EmployeeRepository;

@Service
public class EmployeeService {
	// we need to create a object of the repository for communicate between service
	// and repository
	@Autowired
	private EmployeeRepository repository;

	public String saveEmployee(Employee emp) {
		boolean result = repository.existsById(emp.getId());
		if (result) {
			return "ID is alread present";
		} else {

			repository.save(emp);
			return "Your data hasbeen Stored successfully!";
		}
	}

	public List<Employee> saveEmployees(List<Employee> emps) {
		return repository.saveAll(emps);
	}

	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	public String getEmployeeById(int id) {
		// if findById is not found then null will printed
		try {
			Employee result = repository.findById(id).orElse(null);
			return "Your ID is " + result.getId() + "\n your name is " + result.getName() + "\n your designation is "
					+ result.getDesg();

		} catch (Exception e) {
			return "Entered ID is not present in data base";
		}

	}

	public String getEmployeeByName(String name) {
		Employee result = repository.findByName(name);
		if (result != null) {
			return "Your ID is " + result.getId() + "\n your name is " + result.getName() + "\n your designation is "
					+ result.getDesg();
		} else {
			return "you entered name is not present in the database";
		}

	}

	public String deleteEmployee(int id) {
		boolean result = repository.existsById(id);
		if (result) {
			repository.deleteById(id);
			return "Delete successfully and the id:" + id;
		} else {
			return "You entered id is not present in database!";

		}
	}

	public String updateEmployee(Employee emp) {
		boolean result = repository.existsById(emp.getId());
		if (result) {
			Employee existingEmployee = repository.findById(emp.getId()).orElse(emp);
			existingEmployee.setName(emp.getName());
			existingEmployee.setSal(emp.getSal());
			existingEmployee.setDesg(emp.getDesg());
			repository.save(existingEmployee);

			return "Update successfully with ID: " + emp.getId();
		} else {
			return "you entered wrong id ";
		}
	}

}
