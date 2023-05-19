package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.academy.HibernateUtil;

import pojos.Student;

public class StudentDao {

	public Student getStudent(int id){
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
	}
	
	 public List < Student > getAllStudent() {

	        Transaction transaction = null;
	        List < Student > listOfStudent= null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfStudent= session.createQuery("from Student").list();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfStudent;
	    }
}
