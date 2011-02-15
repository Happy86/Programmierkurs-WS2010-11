/*
 *	FILE:			coords.java
 *	AUTHOR:			Andreas Boesen 
 * 	DESCRIPTION: 	Koordinaten vergleichen.
 */

import java.util.Vector;

public class coords {
	public static void main(String args[]){
		Vector<Koordinate> datensaetze = new Vector<Koordinate>();
		datensaetze.add(new Koordinate(5,2));
		datensaetze.add(new Koordinate(2,2));
		datensaetze.add(new Koordinate(3,2));
		datensaetze.add(new Koordinate(2,2));
		datensaetze.add(new Koordinate(1,2));
		
		if(datensaetze.get(1).istKleinerAls(datensaetze.get(0))){
			System.out.println("[0] ist groesser als [1]\n" 
					+ datensaetze.get(0) + " > " + datensaetze.get(1) + "\n"
					+ datensaetze.get(0).print() + " > " + datensaetze.get(1).print());
		}
	}
}

class Koordinate{
	private int x;
	private int y;
	
	public Koordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public boolean istKleinerAls(Koordinate c){
		if(this.x*this.y < c.getX()*this.getY()){
			return true;
		}
		return false;
	}
	
	public String print(){
		return "(" + this.x + "|" + this.y + ")";
	}
}