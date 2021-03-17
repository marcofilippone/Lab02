package it.polito.tdp.alien.model;

public class TestDizionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dizionario d = new Dizionario();
		d.add("bubu", "ciao");
		d.add("bubu", "cane");
		d.add("bubu", "collo");
		d.add("baba", "come");
		d.add("baba", "stai");
		d.add("cunu", "oggi");
		
		String s = d.traduci("bub?");
		System.out.println(s);

	}

}
