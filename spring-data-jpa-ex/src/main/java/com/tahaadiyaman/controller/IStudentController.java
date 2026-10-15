package com.tahaadiyaman.controller;

import java.util.List;

import com.tahaadiyaman.dto.DtoStudent;
import com.tahaadiyaman.dto.DtoStudentIU;
import com.tahaadiyaman.entities.Student;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public boolean deleteStudentById(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);

}
