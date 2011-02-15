import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ZeichenFenster extends JFrame {
	private BufferedImage img;
	private int x = 1280;
	private int y = 780;

	public ZeichenFenster() {
		FensterBauen();
	}
	
	public void FensterBauen(){
		this.setVisible (false);
		this.setTitle("Tolles Fenster!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(150,50));
		this.setSize(new Dimension(this.x,this.y));
		
		this.setVisible (true);
		
		
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		img = new BufferedImage(this.x, this.y, BufferedImage.TYPE_INT_RGB);
		befuellePixel(img);
		g.drawImage(img, 0, 0, this);
		
	}
	
	public void befuellePixel(BufferedImage it) {
		Random rand;
		rand = new Random (Integer.MAX_VALUE);
		for (int k = 0; k < this.x; k++) {
			for (int l = 0; l < this.y; l++) {
				it.setRGB(k, l, rand.nextInt(Integer.MAX_VALUE));
			}
		}
		
	}
}
