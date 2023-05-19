package pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="teacher_table")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
private int Id;
	@Column(name="teacher_name")
private String teacherName;
	
private List<Class>teacherClasses;



public Teacher() {
	super();
}
public Teacher(int id, String teacherName, List<Class> teacherClasses) {
	super();
	Id = id;
	this.teacherName = teacherName;
	this.teacherClasses = teacherClasses;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public List<Class> getTeacherClasses() {
	return teacherClasses;
}
public void setTeacherClasses(List<Class> teacherClasses) {
	this.teacherClasses = teacherClasses;
}
@Override
public String toString() {
	return "Teacher [Id=" + Id + ", teacherName=" + teacherName + ", teacherClasses=" + teacherClasses + "]";
}


}
