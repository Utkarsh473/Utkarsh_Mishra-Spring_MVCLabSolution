package com.gl.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.Entity.StudentModel;

@Service
public interface StudentService {
	
	public void createOrUpdate(StudentModel sm);
	
	public List<StudentModel> readAll();
	
	public StudentModel readById(int id);
	
	public void deleteById(int id);	
	

}
