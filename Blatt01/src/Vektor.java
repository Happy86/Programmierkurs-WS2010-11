
public class Vektor {
	private double x1,x2,x3;
	
	public Vektor (double a, double b, double c){
		this.x1 = a;
		this.x2 = b;
		this.x3 = c;
	}
	
	public String toString(){
		return "{" + this.x1 + "/" + this.x2 + "/" + this.x3 + "}";
	}
	
	public Vektor addiere(Vektor zweiterVektor){
		Vektor erg = new Vektor(this.getA() + zweiterVektor.getA(), this.getB() + zweiterVektor.getB(), this.getC() + zweiterVektor.getC());
		return erg; 
	}

	public Vektor skaliere(double r){
		Vektor erg = new Vektor(r*this.getA(), r*this.getB(), r*this.getC());
		return erg;
	}
	
	public double multipliziere(Vektor V42){
		double erg = this.getA() * V42.getA() + this.getB() * V42.getB() + this.getC() * V42.getC();
		return erg;
	}
	
	public double betrag(){
		return Math.sqrt(Math.pow(this.x1, 2) + Math.pow(this.x2, 2) + Math.pow(this.x3, 2));
	}
	
	public Vektor normalisiere(){
		return this.skaliere(1/this.betrag()); 
	}
	
	public double getA() {
		return x1;
	}

	public void setA(double a) {
		this.x1 = a;
	}

	public double getB() {
		return x2;
	}

	public void setVektor(double[] input) throws Exception{
		if(input.length != 3){
			throw new Exception("YOU FAIL!!!");
		}
		this.x1 = input[0];
		this.x2 = input[1];
		this.x3 = input[2];
	}
	
	public void setB(double b) {
		this.x2 = b;
	}

	public double getC() {
		return x3;
	}

	public void setC(double c) {
		this.x3 = c;
	}
}
