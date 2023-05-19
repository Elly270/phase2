package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.academy.HibernateUtil;

import pojos.Teacher;

public class TeacherDao {

	public Teacher getTeacher(int id){
		Transaction transaction = null;
		Teacher teacher = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            teacher = session.get(Teacher.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return teacher;
	}
	 public List < Teacher > getAllTeacher() {

	        Transaction transaction = null;
	        List < Teacher > listOfTeacher= null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfTeacher= session.createQuery("from Teacher").list();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfTeacher;
	    }
}
