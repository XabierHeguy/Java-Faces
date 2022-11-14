package client;

import entity.Personne;
import dao.PersonneDao;
import dao.PersonneDao;

public class Client {
	public static void main(String[] args) {

		Personne p = new Personne("Garat", "Jon", 24);
		PersonneDao.persist(p);
		p.setAge(34);
		PersonneDao.update(p);
		PersonneDao.delete(2);;
	}
}
