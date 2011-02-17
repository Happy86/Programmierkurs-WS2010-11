package rayTracer;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.LinkedList;

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
        s += "Auflösung : " + breite + " , " + hoehe + "\n";
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
