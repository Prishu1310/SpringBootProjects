package com.springbootmvc.empcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootmvc.empModel.EmployeeModel;
import com.springbootmvc.empService.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/employeeform")
	public String getDetails() {
		return "employee";
	}
	@PostMapping("/save")
	public String saveDetails(EmployeeModel employeeModel) {
		employeeService.saveEmployeeDetails(employeeModel);
		return "submit";
	}

}
