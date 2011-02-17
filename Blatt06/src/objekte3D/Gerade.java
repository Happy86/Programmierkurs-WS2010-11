package objekte3D;

import mathe.Vektor;

public class Gerade
{
    private Vektor aufpunkt;
    private Vektor richtung;
    
    public Gerade(Vektor aufpunkt, Vektor richtung)
    {
        this.aufpunkt = aufpunkt;
        this.richtung = richtung; 
    }
    
    public Vektor punkt(double t)
    {
        return this.aufpunkt.addiere(this.richtung.skaliere(t));
    }
    
    public Vektor getRichtung()
    {
        return richtung;
    }
    
    public Vektor getAufpunkt()
    {
        return aufpunkt;
    }
    
    public String toString()
    {
        return "Gerade : " + aufpunkt + " + t * " + richtung;
    }

}
