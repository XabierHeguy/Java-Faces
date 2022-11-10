package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Player;
import util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionfactory().openSession();

		Player player1 = new Player("Jean", 4, 8, 2.0, 14.0, "src/img/image2.jpg");
		Transaction transaction = session.beginTransaction();
		try {
			player1.persistPlayer();
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de l'insertion du player : " + e.getMessage());
			transaction.rollback();
		}
		
	//	Player player2 = new Player("Jon", 14, 7, 21.0, 4.0, "src/img/image3.jpg");
		Player player = session.get(Player.class, 1);
		player.setUsername("Philippe");
		Player.updatePlayer(player);

	}

}
