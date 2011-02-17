package rayTracer;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import anzeige.ZeichenBereich;

public class RayTracer
{

    public static void main(String[] args)
    {

        Szene szene = null;
        
        try
        {
            szene = new Szene("./szene.dat");
        }
        catch(SzeneDateiFehler e)
        {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println(szene.getAufloesung());
/*
        System.out.println(szene);

        
        JFrame frame = new JFrame("Prokurs Raytracer");
        ZeichenBereich zB = new ZeichenBereich(szene.getAufloesung());
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(zB);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        
        szene.erzeugeBild(zB);
        */
    }

}
