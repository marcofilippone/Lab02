package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dizionario {
	
	private Map<String, String> mappa;
	private List<ParolaPiu> lista;
	
	public Dizionario() {
		//mappa = new HashMap<>();
		lista = new LinkedList<>();
	}
	
	
	public void add(String ali, String ita) {
			//mappa.put(ali, ita); //funziona solo per l'esercizio 1, sovrascrive
		ParolaPiu p = new ParolaPiu(ali, ita);
		for(ParolaPiu pi : lista) {
			if(p.equals(pi)) {
				return;
			}
		}
		lista.add(p); // consente traduzioni multiple, es2
	}
	
	/**
	 * restituisce null se non esiste (mappa)
	 * @param ali
	 * @return
	 */
	public String traduci(String ali) {
		//return mappa.get(ali);
		String s = "";
		if(ali.contains("?")) {
			int indice = ali.indexOf('?');
			String[] divisa = ali.split("?");
			String prima = divisa[0];
			String dopo = divisa[1];
			String primaLista;
			String dopoLista;
			for(ParolaPiu pi : lista) {
				primaLista = pi.getAli().substring(0, indice);
				dopoLista = pi.getAli().substring(indice+1);
				if(prima.equals(primaLista) && dopo.equals(dopoLista)) {
					s += pi.getIta()+"\n";
				}
			}
		}
		else {
			for(ParolaPiu pi : lista) {
				if(ali.equals(pi.getAli())) {
					s += pi.getIta()+"\n";
				}
			}
		}
		return s;
	}
}
	

