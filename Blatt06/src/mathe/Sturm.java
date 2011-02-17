package mathe;

public class Sturm {
	
	private Polynom[] sturm;
	
	public Sturm(Polynom polynom)
	{
		Polynom p = new Polynom(polynom);
		Polynom p_s = p.ableiten();
		Polynom ggTP = Polynom.ggT(p, p_s);
/*		if(ggTP!=null)
		{
			p = p.dividiere(ggTP);
			p_s = p.ableiten();
		}*/
		sturm = new Polynom[p.length()];
		sturm[0] = new Polynom(p);
		sturm[1] = new Polynom(p_s);
		
		for(int i=2;i<p.length();i++)
		{
			sturm[i] = sturm[i-2].mod(sturm[i-1]);
			if(sturm[i] != null)
			    sturm[i] = sturm[i].durchmultiplizieren(-1.0,0);
			else
			    sturm[i] = new Polynom(0.0);
		}
	}

	
	public int vzw(double a)
	{
		int vzw = 0;
		
		int altVz = 1;
		double d;
		
		d = sturm[0].wert(a);
		
		if(d < 0.0)
			altVz = -1;
		
		for(int i=1;i<sturm.length;i++)
		{
			d = sturm[i].wert(a);
			int vz = 1;
			if(d < 0.0)
				vz = -1;
			if(vz != altVz)
				vzw++;
			altVz = vz;
		}
		
		return vzw;
		
	}
	
	
	public double erstNullStelle(double a, double b)
	{
		int vzw_a, vzw_c;
		
		double c;
		
		vzw_a = vzw(a);
		if(vzw(b) == vzw_a)
			return a - Polynom.getFastNull();
		
		while(b - a > Polynom.getFastNull())
		{
			c = (a + b) / 2.0;
			vzw_c = vzw(c);
			if(vzw_c != vzw_a)
			{
				b = c;
			}
			else
			{
				a = c;
				vzw_a = vzw_c;
			}
		}
		
		
		return (a + b) / 2.0;
	}
	
}
