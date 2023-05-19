package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.academy.HibernateUtil;

public class ClassDao {

	public Class getClass(int id){
		Transaction transaction = null;
		Class className = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            className = session.get(Class.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return className;
	}
	
	 public List < Class > getAllClass() {

	        Transaction transaction = null;
	        List < Class > listOfClass= null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            listOfClass= session.createQuery("from Class").list();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfClass;
	    }
}
