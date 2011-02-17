package mathe;

public class Vektor {
	private double a1,a2,a3;
	
	public Vektor(double a1, double a2, double a3)
	{
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}
	
	public Vektor addiere(Vektor v)
	{
		return new Vektor(this.a1 + v.a1,
						  this.a2 + v.a2,
						  this.a3 + v.a3);
	}
	
	public Vektor skaliere(double r)
	{
		return new Vektor(this.a1 * r,
						  this.a2 * r,
						  this.a3 * r);
	}
	
	public double multipliziere(Vektor v)
	{
		return this.a1 * v.a1 + 
			   this.a2 * v.a2 +
			   this.a3 * v.a3;
	}
	
	public double betrag()
	{
		return Math.sqrt(this.a1 * this.a1 + 
				         this.a2 * this.a2 + 
				         this.a3 * this.a3);
	}
	
	
	public Vektor normalisiere()
	{
		double r = 1.0 / betrag();
		return skaliere(r);
	}
	
	public void setzeWerte(double... werte)
	{
		this.a1 = werte[0];
		this.a2 = werte[1];
		this.a3 = werte[2];
	}
	
    public double getX1()
    {
        return a1;
    }
    
    public double getX2()
    {
        return a2;
    }
    
    public double getX3()
    {
        return a3;
    }
    
	public String toString()
	{
		return "(" + a1 + "," + a2 + "," + a3 + ")";
	}
	
}
