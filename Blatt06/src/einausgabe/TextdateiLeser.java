package einausgabe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import mathe.Matrix;
import mathe.Vektor;
import rayTracer.Farbe;
import rayTracer.Material;

public class TextdateiLeser {

	private BufferedReader reader;
	private int zeile;
	
	public void fehler(String msg)
	{
		System.out.println(zeile + ": " + msg);
	}

	public TextdateiLeser(String dateiName)
	{
		zeile = 0;
		try 
		{
			reader = new BufferedReader(new FileReader(dateiName));
		} 
		catch (IOException e) 
		{
			System.out.println("Datei konnte nicht geˆffnet werden! ("
					+ e.getMessage() + ")");
			reader = null;
		}
	}

	public String leseZeile() {
		if (reader == null)
			return null;


		String s = "";

		try {

			if (!reader.ready())
				return null;

			while (s.compareTo("") == 0) {
				s = reader.readLine().trim();
				zeile ++;
				if (s.startsWith("#"))
				{
					s = "";
				}

				if (!reader.ready())
				{
					break;
				}

			}

			if (s.compareTo("") == 0)
				return null;
			
		} catch (IOException e) {
			return null;
		}

		return s;
	}
	
	public Integer leseInteger()
	{	
		String s = leseZeile();
		Integer i;
		
		try
		{
			i = Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Fehler in Zeile " + zeile + " : Integer erwartet!");
			i = null;
		}
		return i;
	}
	
	public Double leseDouble()
	{	
		String s = leseZeile();
		Double d;
		
		try
		{
			d = Double.parseDouble(s);
		}
		catch(NumberFormatException e)
		{
			fehler(" : Double erwartet!");
			d = null;
		}
		return d;
	}
	
	public int getZeilennummer()
	{
		return zeile;
	}
	
	public boolean weiterLesen()
	{
		if(reader == null)
			return false;
		try
		{
			if(reader.ready())
				return true;
			else
				return false;
		}
		catch(IOException e)
		{
			return false;
		}
	}
	
	
	   public String[] leseStringArray()
	    {
	        String s = leseZeile();
	        if(s == null)
	        {
	            fehler("Array erwartet!");
	            return null;
	        }
	        String[] strings = s.split(",");
	        
	        String[] toRet = new String[strings.length];
	        for(int i=0;i<strings.length;i++)
	            toRet[i] = strings[i].trim();
	        return toRet;
	    }
	
	
	public String[] leseStringArray(int anzahl)
	{
		String s = leseZeile();
		if(s == null)
		{
			fehler("Array erwartet!");
			return null;
		}
		String[] strings = s.split(",");
		
		if(strings.length != anzahl)
		{
			fehler("Inkorrekte Anzahl an Elementen.");
			return null;
		}
		String[] toRet = new String[strings.length];
		for(int i=0;i<strings.length;i++)
			toRet[i] = strings[i].trim();
		return toRet;
	}
	
	
	public double[] leseDoubleArray(int anzahl)
	{
		double[] erg;
		String[] strings = leseStringArray(anzahl);
		if(strings == null)
		{
			fehler("Double-Array erwartet!");
			return null;
		}
		try
		{
			erg = new double[anzahl];
			for(int i=0;i<anzahl;i++)
				erg[i] = Double.parseDouble(strings[i]);
		}
		catch(NumberFormatException e)
		{
			fehler("Double-Array erwartet!");
			erg = null;
		}
		return erg;
	}

	public int[] leseIntArray(int anzahl)
	{
		int[] erg;
		String[] strings = leseStringArray(anzahl);
		if(strings == null)
		{
			return null;
		}
		try
		{
			erg = new int[anzahl];
			for(int i=0;i<anzahl;i++)
				erg[i] = Integer.parseInt(strings[i]);
		}
		catch(NumberFormatException e)
		{
			fehler("Int-Array erwartet!");
			erg = null;
		}
		return erg;
	}

	public Vektor leseVektor()
	{
		double[] a = leseDoubleArray(3);
		
		if(a == null)
		{
			fehler("Vektor erwartet!");
			return null;
		}
		
		return new Vektor(a[0], a[1], a[2]);
	}
	
	
	public Matrix leseMatrix()
	{
		int[] dim = leseIntArray(2);
		if(dim == null)
		{
			fehler("Matrix erwartet!");
			return null;
		}
		
		Matrix m = new Matrix(dim[0], dim[1]);
		
		for(int i=0;i<dim[0];i++)
		{
			double[] z = leseDoubleArray(dim[1]);
			if(z==null)
			{
				fehler("Matrix erwartet!");
				return null;
			}
			
			m.setzeZeile(i, z);
			
		}
		return m;
	}


	   public Matrix leseMatrix(int zeilen, int spalten)
	    {
	        int[] dim = {zeilen, spalten};
	        
	        Matrix m = new Matrix(dim[0], dim[1]);
	        
	        for(int i=0;i<dim[0];i++)
	        {
	            double[] z = leseDoubleArray(dim[1]);
	            if(z==null)
	            {
	                fehler("Matrix erwartet!");
	                return null;
	            }
	            
	            m.setzeZeile(i, z);
	            
	        }
	        return m;
	    }

	
    public Farbe leseFarbe()
    {
        double[] a = leseDoubleArray(3);
        
        if(a == null)
        {
            fehler("Farbe erwartet!");
            return null;
        }
        
        return new Farbe(a[0], a[1], a[2]);
    }
    
    public Material leseMaterial()
    {
        boolean f = false;
        String name = leseZeile();
        if(name == null)
            f = true;
        
        Farbe farbe = leseFarbe();
        if(farbe == null)
            f = true;
        Double d1 = leseDouble();
        if(d1 == null)
            f = true;
        
        Double d2 = leseDouble();
        if(d2 == null)
            f = true;
        
        Double d3 = leseDouble();
        if(d3 == null)
            f = true;
        
        Double d4 = leseDouble();
        if(d4 == null)
            f = true;
        if(f)
        {
            fehler("Material erwaretet!");
            return null;
        }
        return new Material(name, farbe, d1, d2, d3, d4);
    }
	
}