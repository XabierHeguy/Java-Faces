package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Personne;
import util.HibernateUtil;

public class PersonneDao {
	public static void persist(Personne p) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.persist(p);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de l'insertion de la personne : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}
	
	public static Personne get(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			Personne p = session.get(Personne.class, id);
			transaction.commit();
			return p;
		}
		catch(Exception e) {
			System.out.println("Erreur d'obtention de la personne" + e.getMessage());
			transaction.rollback();
			return null;
		}
	}
	
	public static void update(Personne p) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(p);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de l'insertion de la personne : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}
	
	public void saveOrUpdate() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(this);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de la mise à jour ou insertion de la personne : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}
	
	public static void delete(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Personne p = session.get(Personne.class, id);
			session.delete(p);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de la suppression de la personne : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}
}
