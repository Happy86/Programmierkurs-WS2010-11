package anzeige;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import rayTracer.Farbe;

public class ZeichenBereich extends JComponent 
{
    Dimension aufloesung;
    BufferedImage bImg;
    
    public ZeichenBereich(Dimension dim)
    {
        aufloesung = dim;
        bImg = new BufferedImage(dim.width, dim.height , BufferedImage.TYPE_INT_RGB);
        
        setSize(dim);
        setPreferredSize(dim);
        
        Farbe f = new Farbe(0.5,0.0,1.0);
        
        System.out.println(f.RGB());
        
        for(int x=0;x<dim.width;x++)
            for(int y=0;y<dim.height;y++)
                bImg.setRGB(x, y, 0);
        
        repaint();
    }
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(bImg, 0, 0, this);
    }
    
    public void setzePixel(int x, int y, Farbe f)
    {
        bImg.setRGB(x,y, f.RGB_exposure(-0.3));
        repaint();
    }

}
