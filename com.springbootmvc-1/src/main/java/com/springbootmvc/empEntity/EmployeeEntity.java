package com.springbootmvc.empEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empNumber;
	private int empId;
	private String empName;
	private int empDept;
	private String empCompany;
	private double empSalary;
    private double hraSalary;
    private double daSalary;
    private double finalSalary;
}
