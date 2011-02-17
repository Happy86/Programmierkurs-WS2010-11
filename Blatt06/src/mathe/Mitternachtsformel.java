package mathe;

public class Mitternachtsformel {
	
	double a,b,c;
	
	public Mitternachtsformel(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String toString()
	{
		return a + "x^2 + " + b + "x + " + c;
	}
	
	public double []berechneNullstellen()
	{
		double[] ergebnisse;
		
		double D = b*b - 4.0*a*c;
		if(D<0)
			return null;

		ergebnisse = new double[2];
		ergebnisse[0] = (-b + Math.sqrt(D)) / (2.0 * a);
		ergebnisse[1] = (-b - Math.sqrt(D)) / (2.0 * a);
		
		return ergebnisse;
	}
	
}
