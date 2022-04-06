package com.gl.AppMain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.gl.Entity.StudentModel;
import com.gl.Service.StudentService;
import com.gl.Service.StudentServiceImpl;

public class MainClass {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Configuration hibCfg = new Configuration().configure("hibernate.cfg.xml")
		  .addAnnotatedClass(StudentModel.class);
		  
		  SessionFactory sf = hibCfg.buildSessionFactory();
		  
		  StudentService stuSvc = new StudentServiceImpl(sf);
		  
		  
		  System.out.println("Printing all records");
		  
		  List<StudentModel> stuList = stuSvc.readAll();
		  
		  for (StudentModel s : stuList) { System.out.println(s.toString()); }
		 		
		
		
	}

}
