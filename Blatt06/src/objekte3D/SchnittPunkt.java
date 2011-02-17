package objekte3D;

import mathe.Vektor;

public class SchnittPunkt
{
    private Vektor position;
    private Vektor normale;
    private Vektor betrachter;
    
    private Objekt obj;
    
    private double t;
    
    public SchnittPunkt(Vektor position, Vektor normale, Vektor betrachter, double t, Objekt obj)
    {
        this.position = position;
        this.normale = normale;
        this.betrachter = betrachter;
        this.t = t;
        this.obj = obj;
    }
    
    public Vektor getPosition()
    {
        return position;
    }
    
    public Vektor getNormale()
    {
        return normale;
    }
    
    public double getT()
    {
        return t;
    }
    
    public Objekt getObjekt()
    {
        return obj;
    }
    
    public Vektor getBetrachter()
    {
        return betrachter;
    }
    
    
}

