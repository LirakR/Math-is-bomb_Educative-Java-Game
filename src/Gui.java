
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JPanel {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel bg = new JLabel();
	ControllKeys ck = new ControllKeys();
	Bomb b = new Bomb(10,10,10,10,'+');
	Bombs bs =new Bombs();

	
	
	public int WIDTH;
	public int HEIGHT;
	public Gui(int w, int h,JFrame f) {
	
        this.WIDTH=w;
        this.HEIGHT=h;
        frame=f;
		frame.getContentPane().add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
      frame.setTitle("Math is BOMB");
		//frame.addKeyListener(ck);
		setLayout(null);
		bg.setIcon(new ImageIcon("background.png"));
		bg.setBounds(0,0,WIDTH,HEIGHT);
	
		bg.setVisible(true);
		panel.add(bg);
		frame.add(b);
		frame.add(this);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	public void addMethod(JLabel l) {
		this.add(l);
	}
	
	public void paintComponent(Graphics g) {
		//g.setColor(Color.white);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
		Image bg1 = null;
		try {
			 bg1 = ImageIO.read(new File("background.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		g.drawImage(bg1,0,0,null);
		repaint();	
	
	}
}
	