package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> employees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", employees);

		return "list-employees";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee-from";
	}

	@GetMapping("/updateEmployee")
	public String showForUpdate(@RequestParam("id") int id, Model theModel) {
		var res = employeeService.findById(id);
		theModel.addAttribute("employee", res);
		return "employee-from";
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		// save the employee
		employeeService.save(theEmployee);

		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
}









