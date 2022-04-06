package com.gl.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.Entity.StudentModel;

@Repository
public class StudentServiceImpl implements StudentService {


	private SessionFactory sf;
	
	private Session session;
	
	
	public StudentServiceImpl(SessionFactory sf) {
		this.sf = sf;
		this.session = this.sf.openSession();
	}

	
	@Transactional
	public void createOrUpdate(StudentModel sm)
	{
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(sm);
		tx.commit();
	}
	
	@Transactional
	public List<StudentModel> readAll()
	{
		String stmt = "from StudentModel";
		
		List<StudentModel> s = new ArrayList<StudentModel>();
		
		s = session.createQuery("from StudentModel", StudentModel.class).list();
		
		
		for (StudentModel st : s)
		{
			System.out.println(st.toString());
		}
		
		return s;
		
	}
	
	@Transactional
	public StudentModel readById(int id)
	{

		StudentModel s = session.get(StudentModel.class,id);
		
		return s;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		Transaction tx = session.beginTransaction();
		StudentModel sm = session.get(StudentModel.class, id);
		
		session.delete(sm);
		tx.commit();
	}
	
}
