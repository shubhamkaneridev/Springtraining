package com.commons.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.commons.entity.StudentMarks;
import com.commons.entity.StudentMarksMapper;


public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private PlatformTransactionManager transactionManager;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void create(String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplateObject.update(SQL1, name, age);

			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			// int sid = jdbcTemplateObject.queryForInt( SQL2 );
			Number number = jdbcTemplateObject.queryForObject(SQL2, null, Integer.class);

			String SQL3 = "insert into Marks(sid, marks, year) " + "values (?, ?, ?)";
			jdbcTemplateObject.update(SQL3, number, marks, year);

			// to simulate the exception.
		// jdbcTemplateObject.update( SQL3, "", marks, year);

			System.out.println("Created Name = " + name + ", Age = " + age);
			transactionManager.commit(status);
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		}
		return;
	}

	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student, Marks where Student.id=Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL, new StudentMarksMapper());

		return studentMarks;
	}

	@Override
	public void delete(Integer id) {

		String SQL1 = "delete from student where id = ?";
		String SQL2 = "delete from marks where sid = ?";

		jdbcTemplateObject.update(SQL2, id);
		jdbcTemplateObject.update(SQL1, id);
		System.out.println("Deleted Record with ID = " + id);
		return;

	}

	@Override
	public void update(Integer id, String studentName, int marks, int year, int age) {

		String SQL = "update student,marks set student.name = ?,student.age = ?, marks.marks= ? ,marks.YEAR= ? where student.id=marks.SID and student.id=?";

		jdbcTemplateObject.update(SQL, studentName, age, marks, year, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

	@Override
	public StudentMarks getStudent(int id) {

		String SQL = "select  NAME, AGE,  MARKS, YEAR from Student, Marks where Student.id=Marks.sid and Student.id=?";

		StudentMarks student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMarksMapper());

		return student;

	}

}