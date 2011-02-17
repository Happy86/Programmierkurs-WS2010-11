package rayTracer;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.LinkedList;

import einausgabe.TextdateiLeser;

import mathe.Vektor;
import objekte3D.Gerade;
import objekte3D.Licht;
import objekte3D.Objekt;
import anzeige.ZeichenBereich;

public class Szene
{
    private int                       breite, hoehe;

    private Vektor                    kamera_pos;
    private Vektor                    kamera_rechts;
    private Vektor		      		  kamera_hoch;
    private Vektor		  			  kamera_richtung;

    private Farbe                     ambient;

    private HashMap<String, Material> materialien;
    private HashMap<String, Objekt>   objekte;
    private LinkedList<Licht>         lichter;
    private Farbe 					  schwarz;

    public Szene(String dateiName) throws SzeneDateiFehler
    {
        materialien = new HashMap<String, Material>();
        objekte = new HashMap<String, Objekt>();
        lichter = new LinkedList<Licht>();
        schwarz = new Farbe(0,0,0);
	// Szenen-Datei einlesen!
        TextdateiLeser Datei = new TextdateiLeser("szene.dat");
        {
	        // aufloesung
	        int[] aufl = new int[2];
	        aufl = Datei.leseIntArray(2);
	        breite = aufl[0];
	        hoehe = aufl[1];
        }
    	// ambient licht
    	ambient = Datei.leseFarbe();
    	kamera_pos = Datei.leseVektor();
    	kamera_rechts = Datei.leseVektor();
    	kamera_hoch = Datei.leseVektor();
    	kamera_richtung = Datei.leseVektor();
    	
   		
    	// freier Dateibereich
		while (Datei.weiterLesen())
		{
			String buffer = "";
	    	buffer = Datei.leseZeile();
	    	if (buffer.compareTo("material") == 0)
	    	{
	    		String name;
	    		Farbe farbe;
	    		double kdiff, kspec, nspec, rf;
	    		name = Datei.leseZeile();
	    		farbe = Datei.leseFarbe();
	    		kdiff = Datei.leseDouble();
	    		kspec = Datei.leseDouble();
	    		nspec = Datei.leseDouble();
	    		rf = Datei.leseDouble();
	    		Material hilf = new Material (name, farbe, kdiff, kspec, nspec, rf);
	    		materialien.put(name, hilf);
	    	}
	    	else if (buffer.compareTo("objekt") == 0)
	    	{
	    		String typ, name;
	    	}
	    	else if (buffer.compareTo("licht") == 0)
	    	{
	    		//String typ;
	    		Vektor position;
	    		Farbe farbe;
	    		//typ = Datei.leseZeile();
	    		position = Datei.leseVektor();
	    		farbe = Datei.leseFarbe();
	    		Licht hilf = new Licht (position, farbe);
	    		lichter.add (hilf);
	    	}
	    	else
	    	{
	    		throw new NullPointerException(";;");
	    	}
    	
    	}

    }

    public Dimension getAufloesung()
    {
        return new Dimension(breite, hoehe);
    }

    public void erzeugeBild(ZeichenBereich zB)
    {
        for (int y = 0; y < hoehe; y++)
        {
            for (int x = 0; x < breite; x++)
            {
                Gerade g = new Gerade(kamera_pos, kamera_richtung);

                zB.setzePixel(x, y, sendeStrahl(g,0));
            }
        }
    }

    

    public Farbe sendeStrahl(Gerade g, int tiefe)
    {
        if(tiefe > 15)			// Reflektionstiefe (Schritte)
            return schwarz;
        
        return schwarz;
    }

    public String toString()
    {
        String s = "";
        s += "Aufl�sung : " + breite + " , " + hoehe + "\n";
        s += "Kamera-Pos      : " + kamera_pos + "\n";
        s += "Kamera-Rechts   : " + kamera_rechts + "\n";
        s += "Kamera-Hoch     : " + kamera_hoch + "\n";
        s += "Kamera-Richtung : " + kamera_richtung + "\n";
        s += "Materialien : \n";
        for (Material m : materialien.values())
            s += m + "\n";
        for (Objekt o : objekte.values())
            s += o + "\n";
        for (Licht l : lichter)
            s += l + "\n";

        return s;
    }

}
