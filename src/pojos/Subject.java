package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="subject_table")
public class Subject {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="subject_id")
private int Id;
@Column(name="subject_name")
private String subjectName;

@ManyToOne
private Class className;


public Subject() {

}


public Subject(int id, String subjectName, Class className) {
	super();
	Id = id;
	this.subjectName = subjectName;
	this.className = className;
}


public int getId() {
	return Id;
}


public void setId(int id) {
	Id = id;
}


public String getSubjectName() {
	return subjectName;
}


public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}


public Class getClassName() {
	return className;
}


public void setClassName(Class className) {
	this.className = className;
}


@Override
public String toString() {
	return "Subjects [Id=" + Id + ", subjectName=" + subjectName + ", className=" + className + "]";
}



}
