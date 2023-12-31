package com.whernandez.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.whernandez.cruddemo.dao.StudentDAO;
import com.whernandez.cruddemo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner -> {
//			createStudent(studentDAO);
			
			createMultipleStudent(studentDAO);
			
//			readStudentById(studentDAO);
			
//			getStudentsUsingQuery(studentDAO);
			
//			getStudentByLastNameUsingQuery(studentDAO);
			
//			updateStudent(studentDAO);
			
//			deleteStudentById(studentDAO);
			
//			deleteAllStudents(studentDAO);
		};
		
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		
		int studentId = 8;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		// change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");
		
		// update the student
		studentDAO.update(myStudent);
		
		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void getStudentByLastNameUsingQuery(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void getStudentsUsingQuery(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		
		// display list of students
		for(Student tempStudent : theStudents ) {
			System.out.println(tempStudent);
		}
	}

	private void readStudentById(StudentDAO studentDAO) {
		// create a student object
		Student tempStudentTemp = new Student("Test", "Doe", "test@correo.com");
		
		// save the student
		studentDAO.save(tempStudentTemp);
		
		// display id of the saved student
		int theId = tempStudentTemp.getId();
		System.out.println("Saved student. Generated id: " + theId);
		
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		
		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent1 = new Student("Mary", "Doe", "paul@correo.com");
		Student tempStudent2 = new Student("Jonh", "Doe", "john@correo.com");
		Student tempStudent3 = new Student("Spyke", "Doe", "spyke@correo.com");
		
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@correo.com");
		
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		
		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
