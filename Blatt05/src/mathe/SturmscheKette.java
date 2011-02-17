package mathe;

public class SturmscheKette {
	private Polynom[] p;
	
	public SturmscheKette (Polynom q) {
		p = new Polynom[(q.grad() + 1)];
		{
			Polynom t, q_abl;
			q_abl = q.ableiten();
			t = q.ggT (q_abl);
			p[0] = q.div(t);
		}
		p[1] = p[0].ableiten();
		
		{
			Polynom hilf;
			boolean erstmals_null = true;
			boolean fertig = false;
			int i = 2;
			while (! fertig)
			{
				hilf=p[i - 2].mod(p[i - 1]);
				if (hilf.grad() == 0)
				{
					erstmals_null = false;
				}
				
				if (! erstmals_null)
				{
					fertig = true;
				}
				else
				{
					p[i] = hilf;
				}
			}
			//p[2]=p[0].mod(p[1]);
			
		}
		
	}
	
	public int s(double x) {
		int zaehler = 0;
		for (int i = 1; i < p.length; i++)
		{
			if (this.signum (p[i], x) != this.signum(p[i -1], x))
			{
				zaehler++;
			}
		}
		return zaehler;
	}
	
	private int signum(Polynom p, double x)
	{
		if (p.wert(x) < 0)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

}
