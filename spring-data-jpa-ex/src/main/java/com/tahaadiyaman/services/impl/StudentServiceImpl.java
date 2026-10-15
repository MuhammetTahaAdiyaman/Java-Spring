package com.tahaadiyaman.services.impl;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tahaadiyaman.dto.DtoStudent;
import com.tahaadiyaman.dto.DtoStudentIU;
import com.tahaadiyaman.entities.Student;
import com.tahaadiyaman.repository.StudentRepository;
import com.tahaadiyaman.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent dtoStudent = new DtoStudent();
		Student student = new Student();

		BeanUtils.copyProperties(dtoStudentIU, student);

		Student dbStudent = studentRepository.save(student);

		BeanUtils.copyProperties(dbStudent, dtoStudent);

		return dtoStudent;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();
		List<Student> studentList = studentRepository.findAll();
		for (Student student : studentList) {
			DtoStudent dto = new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> studentOpt = studentRepository.findById(id);
		Student student = null;
		if (studentOpt.isPresent()) {
			student = studentOpt.get();

		}
		BeanUtils.copyProperties(student, dtoStudent);
		return dtoStudent;
	}

	@Override
	public boolean deleteStudentById(Integer id) {
		Optional<Student> studentOpt = studentRepository.findById(id);
		Student student = null;
		if (studentOpt.isPresent()) {
			student = studentOpt.get();
		}
		studentRepository.delete(student);
		return true;
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> studentOpt = studentRepository.findById(id);
		Student student = null;
		if (studentOpt.isPresent()) {
			student = studentOpt.get();

			student.setFirstName(dtoStudentIU.getFirstName());
			student.setLastName(dtoStudentIU.getLastName());
			student.setBirthOfDate(dtoStudentIU.getBirthOfDate());

			Student updateStudent = studentRepository.save(student);

			BeanUtils.copyProperties(updateStudent, dtoStudent);
			
			return dtoStudent;
			
		}
		return null;
	}

}
