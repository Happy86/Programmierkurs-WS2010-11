package objekte3D;

import mathe.Matrix;
import mathe.Vektor;
import rayTracer.Material;

public abstract class Objekt
{
    private Matrix m_s;
    private Matrix m_s_1 = null;
    private Matrix m_r;
    private Matrix m_r_1 = null;
    
    private Vektor position;
    private Material material;
    private String name;
    
    public Objekt(String name, Vektor position, Material material)
    {
        this.name = name;
        this.position = position;
        m_r = new Matrix(3,3, 1.0, 0.0, 0.0,
                              0.0, 1.0, 0.0,
                              0.0, 0.0, 1.0);

        m_s = new Matrix(3,3, 1.0, 0.0, 0.0,
                              0.0, 1.0, 0.0,
                              0.0, 0.0, 1.0);

        this.material = material;
    }
    
    public Material getMaterial()
    {
        return material;
    }
    
    public abstract SchnittPunkt schnitt(Gerade g);
        
    public void skaliere(double xs, double ys, double zs)
    {
    	// Skalieren mittels Matrix
    }
    
    public void rotiere(double xw, double yw, double zw)
    {
        // Rotieren mittels Matrix
    }
    
    
    public Gerade transformierteGerade(Gerade g)
    {
        Vektor g_a = g.getAufpunkt();
        Vektor g_r = g.getRichtung();
        
        g_a = g_a.addiere(position.skaliere(-1.0));
        
        if(m_s_1 == null)
            m_s_1 = m_s.inverse();
        if(m_r_1 == null)
            m_r_1 = m_r.inverse();
        
        g_a = m_r_1.multipliziere(g_a);
        g_r = m_r_1.multipliziere(g_r);

        g_a = m_s_1.multipliziere(g_a);
        g_r = m_s_1.multipliziere(g_r);
        
        Gerade g1 = new Gerade(g_a, g_r);
        
        return g1;
    }
    
    public Vektor transformierteNormale(Vektor n)
    {
        Vektor n_neu = m_s_1.multipliziere(n).normalisiere();
        n_neu = m_r.multipliziere(n_neu);
        return n_neu;
    }
    
    public Vektor getPosition()
    {
        return position;
    }
    
    public String getName()
    {
        return name;
    }
    
}
