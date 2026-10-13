package com.tahaadiyaman.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tahaadiyaman.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public List<Employee> employeeList(){
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1","taha","ADIYAMAN"));
		employeeList.add(new Employee("2","ahmet","goktas"));
		employeeList.add(new Employee("3","hasan","nakbant"));
		employeeList.add(new Employee("4","fikret","yolmaz"));
		employeeList.add(new Employee("5","rifat","durmaz"));
		employeeList.add(new Employee("6","mesut","oymaz"));

		return employeeList;
	}
	
	
}
