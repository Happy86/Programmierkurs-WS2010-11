package rayTracer;

public class Material
{
    private String name;
    private Farbe farbe;
    private double k_diff;
    private double k_spec;
    private double k_spec_n;
    private double rf;
    
    public Material(String name, Farbe farbe, double k_diff, double k_spec, double k_spec_n, double rf)
    {
        this.name = name;
        this.farbe = farbe;
        this.k_diff = k_diff;
        this.k_spec = k_spec;
        this.k_spec_n = k_spec_n;
        this.rf = rf;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Farbe getFarbe()
    {
        return farbe;
    }
    
    public double getKDiff()
    {
        return k_diff;
    }

    public double getKSpec()
    {
        return k_spec;
    }

    public double getKSpecN()
    {
        return k_spec_n;
    }
    
    public double getRF()
    {
        return rf;
    }
    
    public String toString()
    {
        return "Material (" + name + ", " + farbe + ", " + k_diff + ", " + k_spec + ", " + k_spec_n + ", " + rf + ")";
    }
}
