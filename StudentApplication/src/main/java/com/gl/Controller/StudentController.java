package com.gl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.Entity.StudentModel;
import com.gl.Service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	// Dependency injection
	@Autowired
	private StudentService st;

	private StudentModel stu = new StudentModel();

	// Get Mapping for list
	@GetMapping("/list")
	public String listStudents(Model m) {

		System.out.println("Reading database");

		// calling service readAll() to fetch the records
		List<StudentModel> s = st.readAll();

		m.addAttribute("student", s);

		// return view name to dispatcher Servlet
		return "StudentList";
	}

	// Mapping for adding student

	@RequestMapping("/addForm")
	public String addStudent(Model m) {
		
		StudentModel sm = new StudentModel();

		m.addAttribute("s", sm);

		return "StudentForm";
	}
	
	@RequestMapping("/formForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get the Book from the service
		StudentModel theStudent = st.readById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("s", theStudent);

		// send over to our form
		return "StudentForm";
	}
	
	@PostMapping("/save")
	public String saveStudentDetails(@RequestParam("id") int id, @RequestParam("name") String Name,
			@RequestParam("department") String Department, @RequestParam("country") String Country,Model m) {
		
		StudentModel theStudent;
		

		// Create the record if null is found
		
		if (id != 0) {
			theStudent = st.readById(id);
			theStudent.setName(Name);
			theStudent.setDeptt(Department);
			theStudent.setCountry(Country);
		}
		
		else 
		{
			theStudent = new StudentModel(Name,Department,Country);
		}
			
		st.createOrUpdate(theStudent);

		return "redirect:/student/list";

	}
	
	@RequestMapping(value ="/delete",method={ RequestMethod.GET, RequestMethod.POST ,RequestMethod.DELETE})
	public String deleteStudent(@RequestParam("id") int id)
	{
		st.deleteById(id);
		
		return "redirect:/student/list";
		
	}

}
