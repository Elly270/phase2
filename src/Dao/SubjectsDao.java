package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.academy.HibernateUtil;

import pojos.Subject;

public class SubjectsDao {

	public Subject getSubject(int id){
		Transaction transaction = null;
		Subject subject = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            subject = session.get(Subject.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return subject;
	}
	
	 public List < Subject > getAllSubject() {

	        Transaction transaction = null;
	        List < Subject > listOfSubject= null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfSubject= session.createQuery("from Subject").list();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfSubject;
	    }
}
