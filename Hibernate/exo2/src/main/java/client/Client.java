package client;

import entity.Player;

public class Client {
	public static void main(String[] args) {

		Player p = new Player("Franck", 100, 80, 2.0, 14.0, "src/img/image2.jpg");
		
		p.persist();
		p.saveOrUpdate();
		p.setImage("src/img/image2.png");
		p.saveOrUpdate();
		p.delete();
	}

}
