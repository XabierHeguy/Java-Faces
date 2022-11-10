package client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Student;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		// Création de la session
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Création de la transaction
		Transaction transaction = session.beginTransaction();

		try {// Instanciation de l'objet de type Student
			Student student = new Student(3, "Bessas", "Dylan");
			// Insertion de l'objet dans la DB
			session.save(student);
			// Commit
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
}
