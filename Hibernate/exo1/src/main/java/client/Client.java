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
		// Instanciation de l'objet de type Student
		Student student = new Student(1, "Loisel", "Christopher");
		// Insertion de l'objet dans la DB
		session.save(student);
		// Commit
		transaction.commit();
	}
}
