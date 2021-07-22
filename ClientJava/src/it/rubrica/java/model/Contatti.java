package it.rubrica.java.model;
import java.util.ArrayList;

public class Contatti {

	public ArrayList<Contatto> contatti;
	
	public ArrayList<Contatto> getContatti(){
		return this.contatti;
	}
	
	public void addContatto(Contatto c) {
		this.contatti.add(c);
	}
	
}
