package pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="student_table")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	
	@Column(name="f_name")
	private String fname;
	@Column(name="l_name")
	private String lname;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_fk_id")
    private Class studentClass;
	
	
	
	public Student() {
		
	}
	
	
	
	
	public Student(int id, String fname, String lname, Class studentClass) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.studentClass = studentClass;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Class getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(Class studentClass) {
		this.studentClass = studentClass;
	}
	
	
	
	
	

}