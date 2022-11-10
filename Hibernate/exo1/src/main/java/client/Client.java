package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Chat;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		// Création de la session
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Création de la transaction
		Transaction transaction = session.beginTransaction();

		try {// Instanciation de l'objet de type Student
				// Student student = new Student(3, "Bessas", "Dylan");
			Chat chat = new Chat(5, "Mimi", false);
			// Insertion de l'objet dans la DB
			int i = 0;
			while (i < 10) {
				session.save(chat);
				i++;
			}
			// Commit
			transaction.commit();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			transaction.rollback();
		}
	}
}
