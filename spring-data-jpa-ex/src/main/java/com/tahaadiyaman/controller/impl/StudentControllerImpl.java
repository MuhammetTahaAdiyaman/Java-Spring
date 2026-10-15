package com.tahaadiyaman.controller.impl;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tahaadiyaman.controller.IStudentController;
import com.tahaadiyaman.dto.DtoStudent;
import com.tahaadiyaman.dto.DtoStudentIU;
import com.tahaadiyaman.entities.Student;
import com.tahaadiyaman.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{
	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
		return studentService.saveStudent(dtoStudentIU);
	}

	@GetMapping("/list")
	@Override
	public List<DtoStudent> getAllStudents() {
		// TODO Auto-generated method stub
		return studentService.getAllStudents();
	}

	@GetMapping("/list/{id}")
	public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@Override
	public boolean deleteStudentById(@PathVariable(name = "id")Integer id) {
		 studentService.deleteStudentById(id);
		 return true;
	}

	@PutMapping("/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
		return studentService.updateStudent(id, dtoStudentIU);
	}

}
