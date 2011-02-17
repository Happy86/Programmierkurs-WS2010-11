package rayTracer;

public class Farbe
{
    private double r,g,b;
    
    public Farbe(int r, int g, int b)
    {
        this.r = ((double)r) / 255.0;
        this.g = ((double)g) / 255.0;
        this.b = ((double)b) / 255.0;
    }

    public Farbe(double r, double g, double b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Farbe addiere(Farbe f)
    {
        return new Farbe(this.r + f.r,
                         this.g + f.g,
                         this.b + f.b);
    }
    
    public Farbe filtere(Farbe f)
    {
        return new Farbe(Math.min(this.r, f.r),
                         Math.min(this.g, f.g),
                         Math.min(this.b, f.b));
    }

    public Farbe multipliziere(Farbe f)
    {
        return new Farbe(this.r * f.r,
                         this.g * f.g,
                         this.b * f.b);
    }

    public int RGB()
    {
        double exp_max = 1.0;
        double exposure = -1.5;
        double rd = exp_max - Math.exp(this.r * exposure);
        double gd = exp_max - Math.exp(this.g * exposure);
        double bd = exp_max - Math.exp(this.b * exposure);
        
        int r = (int)(255.0 * rd);
        r = Math.min(255, r);
        
        int g = (int)(255.0 * gd);
        g = Math.min(255, g);
        
        int b = (int)(255.0 * bd);
        b = Math.min(255, b);
        
        return (r << 16) + (g << 8) + b;
        
    }

    public int RGB_exposure(double exposure)
    {
    	// exposure muss < 0.0 sein (gute Werte -0.5 bis -1.5)
        double rd = 1.0 - Math.exp(this.r * exposure);
        double gd = 1.0 - Math.exp(this.g * exposure);
        double bd = 1.0 - Math.exp(this.b * exposure);
        
        int r = (int)(255.0 * rd);
        
        int g = (int)(255.0 * gd);

        int b = (int)(255.0 * bd);
        
        return (r << 16) + (g << 8) + b;
        
    }
    
    public Farbe skaliere(double r)
    {
        return new Farbe(r*this.r, r*this.g, r*this.b);
    }
    
    public String toString()
    {
        return "Farbe (R = " + this.r + ", G = " + this.g + ", B = " + this.b + ")";
    }
    

}
