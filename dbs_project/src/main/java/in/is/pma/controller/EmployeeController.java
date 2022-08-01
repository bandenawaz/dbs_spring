package in.is.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.is.pma.model.Employee;
import in.is.pma.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/") // Listing all Employyes
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();
	}

	@PostMapping("/") // adding employees
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@DeleteMapping("/")
	public String deleteEmployee(@RequestBody Employee employee) {
		employeeRepository.delete(employee);
		return "Deleted";
	}
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@RequestParam Long empId) {
		Employee emp=employeeRepository.findById(empId).get();
		employeeRepository.delete(emp);
		return "Deleted";
	}
}
