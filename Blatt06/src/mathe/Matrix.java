package mathe;

public class Matrix {
	private double[][] a;
	
	public Matrix(int n, int m)
	{
		a = new double[n][m];
	}
	
	public Matrix(int n, int m, double... werte)
	{
		if(n*m != werte.length)
		{
			System.out.println("ungültige Anzahl an Parametern!");
			System.exit(-1);
		}
		
		a = new double[n][m];
		
		int i = 0;
		
		for(int zeile = 0; zeile < n; zeile ++)
			for(int spalte = 0; spalte < m; spalte ++)
			{
				a[zeile][spalte] = werte[i];
				i++;
			}
	}
	
	public Matrix(double [][]a)
	{
		this.a = a.clone();
	}
	
	
	public String toString()
	{
		String s = "";
		

		for(int zeile = 0; zeile < a.length; zeile ++)
		{
			s += "(";
			for(int spalte = 0; spalte < a[0].length ; spalte ++)
			{
				s += a[zeile][spalte] + " ";
			}
			s += ")\n";
		}
		return s;
	}
	
	public Matrix erweitere(double r)
	{
		double[][] erg_a = new double[a.length][a[0].length];
		for(int zeile = 0; zeile < a.length; zeile ++)
		{
			for(int spalte = 0; spalte < a[0].length ; spalte ++)
			{
				erg_a[zeile][spalte] = a[zeile][spalte] * r;
			}
		}
		
		return new Matrix(erg_a);
		
	}

	public Matrix addiere(Matrix m)
	{
		if((a.length == m.a.length) &&  
			(a[0].length == m.a[0].length))
		{
			double[][] erg_a = this.a.clone();
			
			for(int zeile = 0; zeile < a.length; zeile ++)
			{
				for(int spalte = 0; spalte < a[0].length ; spalte ++)
				{
					erg_a[zeile][spalte] += m.a[zeile][spalte];
				}
			}
			return new Matrix(erg_a);
			
		}
		else
			return null;
	}
	
	
	public Matrix multipliziere(Matrix m)
	{
		if(this.a[0].length == m.a.length)
		{
			double[][] erg_a = new double[a.length][m.a[0].length];
			for(int zeile = 0; zeile < erg_a.length; zeile ++)
			{
				for(int spalte = 0; spalte < erg_a[0].length ; spalte ++)
				{
					double summe = 0.0;
					for(int k=0; k < a.length; k++)
					{
						summe += this.a[zeile][k] * m.a[k][spalte];
					}
					erg_a[zeile][spalte] = summe;
					
				}
			}
			return new Matrix(erg_a);
			
		}
		else
		{
			return null;
		}
	}
	
	
	public void setzeWerte(double[][] werte)
	{
		if((werte.length == a.length) &&
				(werte[0].length == a[0].length))
		{
			for(int i=0;i<a.length;i++)
				for(int j=0;j<a[0].length;j++)
				{
					a[i][j] = werte[i][j];
				}
		}
		else
			System.out.println("Die Matrix und die von Ihnen angegebenen Werte sind nicht kompatibel, die Dimensionen stimmen leider nicht völlig überein!");
	}

	public void setzeZeile(int zeile, double[] werte)
	{
		if((werte.length == a[0].length) &&
				(zeile >= 0) && (zeile < a.length))
		{
			for(int j=0;j<a[zeile].length;j++)
			{
				a[zeile][j] = werte[j];
			}
		}
		else
		{
			System.out.println("Fehler!");
		}
	}
	
	public Matrix streiche(int zeile, int spalte)
	{
		double[][] erg_a = new double[a.length-1][a[0].length-1];
		
		int z_add = 0;
		int s_add = 0;
		
		for(int i=0;i<erg_a.length;i++)
		{
			s_add = 0;
			if(i == zeile)
				z_add = 1;
			for(int j=0;j<erg_a[0].length;j++)
			{
				if(j == spalte)
					s_add = 1;
				erg_a[i][j] = this.a[i + z_add][j + s_add];
			}
		}
		
		return new Matrix(erg_a);
	}
	
	
	private double sub_det(Matrix m)
	{
		if(m.a.length==1)
			return m.a[0][0];
		double vorz = 1.0;
		int i = 0;
		double summe = 0.0;
		for(int j=0;j<m.a.length;j++)
		{
			summe += vorz * m.a[i][j] * sub_det(m.streiche(i,j));		
			vorz = -vorz;
		}
		return summe;
	}
	
	public double det()
	{
		if(this.a.length != this.a[0].length)
			return 0.0;
		return sub_det(this);
	}

	public Matrix transponiere()
	{
		double[][] erg_a = new double[this.a[0].length][this.a.length];
		for(int i=0;i<erg_a.length;i++)
			for(int j=0;j<erg_a[0].length;j++)
				erg_a[i][j] = this.a[j][i];
		return new Matrix(erg_a);
	}
	
	public Matrix adj()
	{
		double[][] erg_a = new double[this.a.length][this.a[0].length];
		
		double vorz = 1.0;
		for(int i=0;i<erg_a.length;i++)
			for(int j=0;j<erg_a[0].length;j++)
			{
				vorz = Math.pow(-1, i + j);
				erg_a[i][j] = vorz * sub_det(this.streiche(i,j));
			}
		Matrix m = new Matrix(erg_a);
		return m.transponiere();
	}
	
	public Matrix inverse()
	{
		Matrix a = adj();
		double r = 1.0 / det();
		return a.erweitere(r);
	}


	public Vektor multipliziere(Vektor v)
	{
	    Matrix v_m = new Matrix(3, 1, v.getX1(), v.getX2(), v.getX3());
	    Matrix erg = this.multipliziere(v_m);
	    return new Vektor(erg.a[0][0], erg.a[1][0], erg.a[2][0]);
	}
	
}

