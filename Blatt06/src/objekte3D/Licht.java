package objekte3D;

import mathe.Vektor;
import rayTracer.Farbe;

public class Licht
{
    protected Vektor position;
    protected Farbe farbe;
    
    public Licht(Vektor position, Farbe farbe)
    {
        this.position = position;
        this.farbe = farbe;
    }
    
    public Farbe beleuchte(SchnittPunkt sp)
    {       
    	// Beleuchtungsverfahren einfügen!
        return new Farbe(0.0, 0.0, 0.0);
    }
    
    public Vektor getPosition()
    {
        return position;
    }
    
    public String toString()
    {
        return "Licht (" + position + ", " + farbe + ")"; 
    }

}
