package mathe;

public class Polynom {
	
	static double fastNull = 0.00000000001;
	
	public static double getFastNull()
	{
		return fastNull;
	}
	
	public static void setFastNull(double wert)
	{
		fastNull = wert;
	}
	
	double[] koeff;
	
	public Polynom(double... koeff)
	{
		this.koeff = new double[koeff.length];
		
		for(int i=0;i<koeff.length;i++)
		{
			this.koeff[i] = koeff[i];
		}
	}

	public Polynom(Polynom p)
	{
		this.koeff = new double[p.koeff.length];
		for(int i=0;i<p.koeff.length;i++)
			this.koeff[i] = p.koeff[i];
	}
	
	private String erzeugeElement(int i, double wert, boolean plus)
	{
		String s = "";
		if(plus)
			s = " + ";
		switch(i)
		{
		case 0:
			s += "" + wert;
			break;
		case 1:
			s += wert + "x";
			break;
		default:
			s += wert + "x^" + i;
			break;
		}
		
		return s;
	}
	
	public String toString()
	{
		String s="";
		
		if(koeff.length == 0)
			return "0.0";
		
		s = erzeugeElement(koeff.length-1, koeff[koeff.length-1], false);
		
		for(int i=koeff.length-2;i>=0;i--)
		{
			s+= erzeugeElement(i, koeff[i], true);
		}
		return s;
			
	}
	
	public double wert(double x)
	{
		double summe = 0;
		for(int i=0;i<koeff.length;i++)
			summe += koeff[i] * Math.pow(x,(double)i);
		return summe;
	}
	
	
	public Polynom ableiten()
	{
		double[] n_koeff;
		n_koeff = new double[koeff.length-1];
		
		for(int i=0;i<n_koeff.length; i++)
			n_koeff[i] = koeff[i+1] * (i+1);
	
		return new Polynom(n_koeff);
	}
	
	public Polynom durchmultiplizieren(double a, int grad_m)
	{
		double[] n_koeff;
		
		n_koeff = new double[koeff.length + grad_m];
		
		for(int i=0; i < koeff.length; i++)
			n_koeff[i + grad_m] = a * koeff[i];
		
		return new Polynom(n_koeff);
	}
	
	public Polynom addiere(Polynom p)
	{
		Polynom kl, gr;
		if(p.koeff.length > koeff.length)
		{
			gr = new Polynom(p);
			kl = new Polynom(this);
		}
		else
		{
			kl = new Polynom(p);
			gr = new Polynom(this);
		}

		for(int i=0;i<kl.koeff.length;i++)
			gr.koeff[i] += kl.koeff[i];
			
		return gr;
		
	}
	
	public Polynom dividiere(Polynom q)
	{
		double[] n_koeff;
		
		
		if(q.koeff.length > this.koeff.length)
			return new Polynom(0.0);

		Polynom p = new Polynom(this);

		n_koeff = new double[p.koeff.length - q.koeff.length + 1];
		
		int i = n_koeff.length - 1;
		
		while(p.koeff.length >= q.koeff.length)
		{
			n_koeff[i] = p.koeff[p.koeff.length - 1] / q.koeff[q.koeff.length - 1];
			Polynom r = q.durchmultiplizieren(-1.0 * n_koeff[i],
							p.koeff.length - q.koeff.length );
			
			Polynom s = p.addiere(r);
			double[] p_s_koeff = new double[s.koeff.length - 1];
			for(int j=0;j<p_s_koeff.length;j++)
			    p_s_koeff[j] = s.koeff[j];
			p = new Polynom(p_s_koeff);
			i--;
		}
		
		return new Polynom(n_koeff);
	}
	


	public Polynom mod(Polynom q)
	{
		double[] n_koeff;
		
		
		if(q.koeff.length > this.koeff.length)
			return new Polynom(this);

		Polynom p = new Polynom(this);

		n_koeff = new double[p.koeff.length - q.koeff.length + 1];
		
		int i = n_koeff.length - 1;
		
		while(p.koeff.length >= q.koeff.length)
		{
			n_koeff[i] = p.koeff[p.koeff.length - 1] / q.koeff[q.koeff.length - 1];
			Polynom r = q.durchmultiplizieren(-1.0 * n_koeff[i],
							p.koeff.length - q.koeff.length );
			
			Polynom s = p.addiere(r);
			double[] p_s_koeff = new double[s.koeff.length - 1];
			for(int j=0;j<p_s_koeff.length;j++)
			    p_s_koeff[j] = s.koeff[j];
			p = new Polynom(p_s_koeff);
			i--;
		}
		
		int maxNichtNull = -1;
		
		for(int j=0;j<p.koeff.length;j++)
			if(Math.abs(p.koeff[j]) > fastNull)
				maxNichtNull = j;
		
		if(maxNichtNull==-1)
			return null;
		
		n_koeff = new double[maxNichtNull + 1];
		for(int j=0;j<=maxNichtNull;j++)
			n_koeff[j] = p.koeff[j];
		return new Polynom(n_koeff);
	}

	
	static public Polynom ggT(Polynom a, Polynom b)
	{
		if(b == null)
		{
		    if(a == null)
		        return new Polynom(0.0);
		    else
		        return a;
		}
		else
			return ggT(b, a.mod(b));
	}
	
	public int length()
	{
		return koeff.length;
	}
	
	


}
