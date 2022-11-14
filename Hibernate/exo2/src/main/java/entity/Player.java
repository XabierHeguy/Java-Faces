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

	public void persist() {

		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.persist(this);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de l'insertion du player : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}

	public static Player get(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Player p = session.get(Player.class, id);
			transaction.commit();
			session.close();
			return p;
		} catch (Exception e) {
			System.out.println("Echec de la récupération du player : " + e.getMessage());
			transaction.rollback();
			session.close();
			return null;
		}

	}

	public static void update(Player player) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(player); // p devient persistant
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de l'insertion du player : " + e.getMessage());
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
			System.out.println("Echec de la mise à jour ou insertion du player : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}

	public void delete() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Player p = session.get(Player.class, this.id);
			session.delete(p);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Echec de la suppression du player : " + e.getMessage());
			transaction.rollback();
		}
		session.close();
	}

	public void deleteAll() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 1; i < 50; i++) {
			try {
				Player p = session.get(Player.class, i);
				session.delete(p);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
			}
		}
		session.close();
	}

	public void attack(Player p) {
		if (this.getMana() >= 15) {
			System.out.printf("Le player %s attaque le player %s", this.getUsername(), p.getUsername());
			this.setMana(this.getMana() - 15);
			update(this);
			if (p.getHp() <= 20) {
				System.out.printf("Le player %s est mort", p.getUsername());
				p.setHp(0);
				update(p);
			} else {
				System.out.printf("Le player %s a mal", p.getUsername());
				p.setHp(p.getHp() - 20);
				update(p);
			}
		} else {
			System.out.printf("Le player %s n'a pas assez de mana pour attaquer", p.getUsername());
		}
	}

	public void heal(Player p, int hp) {
		p.setHp(p.getHp() + hp);
		update(p);
	}
}
