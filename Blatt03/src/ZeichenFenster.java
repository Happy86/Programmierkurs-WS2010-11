import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ZeichenFenster extends JFrame {
	

	public ZeichenFenster() {
		FensterBauen();
	}
	
	public void FensterBauen(){
		this.setVisible (false);
		this.setTitle("Tolles Fenster!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.setPreferredSize(new Dimension(150,50));
		this.setSize(new Dimension(500,600));
		this.setVisible (true);
	}
}
