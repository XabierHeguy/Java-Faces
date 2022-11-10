package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

@Entity(name = "player")
@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nom")
	private String username;
	@Column(name = "hp")
	private int hp;
	@Column(name = "mana")
	private int mana;
	@Column(name = "posX")
	private double posX;
	@Column(name = "posY")
	private double posY;
	@Column(name = "image")
	private String image;

	public Player() {
	}

	public Player(String username, int hp, int mana, double posX, double posY, String image) {
		this.hp = hp;
		this.mana = mana;
		this.posX = posX;
		this.posY = posY;
		this.image = image;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", username=" + username + ", hp=" + hp + ", mana=" + mana + ", posX=" + posX
				+ ", posY=" + posY + ", image=" + image + "]";
	}

	public void persistPlayer() {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		Player player = new Player("Jolinom", 8, 5, 3.0, 4.0, "src/img/image.jpg");
		
		try {
			session.persist(player);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de l'insertion du player : " + e.getMessage());
			transaction.rollback();
		}
		session.close();

	}

	public static void updatePlayer(Player player) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(player);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de l'insertion du player : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}

}
