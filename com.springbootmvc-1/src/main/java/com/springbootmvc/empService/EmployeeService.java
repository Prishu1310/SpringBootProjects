package com.springbootmvc.empService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmvc.empEntity.EmployeeEntity;
import com.springbootmvc.empModel.EmployeeModel;
import com.springbootmvc.empRepository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	public void saveEmployeeDetails(EmployeeModel employeeModel) {  
		double daSalary;
		daSalary = employeeModel.getEmpSalary()*0.38;
		
		double hraSalary;
		hraSalary=employeeModel.getEmpSalary()*0.45;
		
		double finalSalary;
		finalSalary = employeeModel.getEmpSalary()+hraSalary+daSalary;
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmpId(employeeModel.getEmpId());
		employeeEntity.setEmpName(employeeModel.getEmpName());
		employeeEntity.setEmpDept(employeeModel.getEmpDept());
		employeeEntity.setEmpCompany(employeeModel.getEmpCompany());
		employeeEntity.setEmpSalary(employeeModel.getEmpSalary());
		employeeEntity.setDaSalary(daSalary);
		employeeEntity.setHraSalary(hraSalary);
		employeeEntity.setFinalSalary(finalSalary);
		
		employeeRepository.save(employeeEntity);
	}
}
