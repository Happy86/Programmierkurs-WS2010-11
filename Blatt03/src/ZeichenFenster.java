import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ZeichenFenster extends JFrame {
	private JPanel farbig;

	public ZeichenFenster() {
		FensterBauen();
	}
	
	public void FensterBauen(){
		this.setVisible (false);
		this.setTitle("Tolles Fenster!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(150,50));
		this.setSize(new Dimension(500,600));
		
		farbig = new JPanel();
		farbig.setSize(new Dimension(450,450));
		BefuellePixel(farbig);
		this.add(farbig);
		
		this.setVisible (true);
		
		
		
	}
	
	public JPanel BefuellePixel(JPanel it) {
		BufferedImage img = new BufferedImage(it.getWidth(), it.getHeight(), BufferedImage.TYPE_INT_RGB);
		Random rand;
		rand = new Random (Integer.MAX_VALUE);
		for (int k = 0; k < it.getWidth(); k++) {
			for (int l = 0; l < it.getHeight(); l++) {
				img.setRGB(k, l, rand.nextInt(Integer.MAX_VALUE));
			}
		}
		it.paint(new Color(123));
		JPanel Rueck;
		
	}
}
