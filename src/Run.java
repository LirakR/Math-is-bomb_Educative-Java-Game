import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Run {
	Bombs bs = new Bombs();
	InputLogic il = new InputLogic();
	ControllKeys ck = new ControllKeys();
	
	int width = 1280;
	int height=720;
	
	int score = 0;
	int lives=3;
	int counter =0;
	int sleep = 3;
	int module = 400;
	
	JLabel scoreL = new JLabel();
	JLabel livesL = new JLabel();
	JFrame f = new JFrame();
	
	
	List<Bomb> bArray= new ArrayList<Bomb>(4);
	
	public Run() {
		
		
		 String[] options = new String[] {"  +  ", "  -  ", "  x  ", " Te gjitha ","Dilni"};
		    int response = JOptionPane.showOptionDialog(null, "Shkruani rezultatin e bombes me te afert per te marr pike. Zgjidhni operacionin matematikor me te cilin deshironi te luani", "Math is BOMB",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[1]);
		    System.out.println(response);
		
		
		Gui g= new Gui(width,height,f);
		
		f.addKeyListener(ck);
		
		scoreL.setText("Score: "+score);
		scoreL.setForeground(Color.black);
		//scoreL.setBorder(BorderFactory.createLineBorder(Color.black));
		scoreL.setFont(new Font("Verdana", Font.PLAIN, 30));
		scoreL.setBounds(10,10,200,40);
		
		livesL.setText("Lives: "+lives);
		livesL.setForeground(Color.red);
		//scoreL.setBorder(BorderFactory.createLineBorder(Color.black));
		livesL.setFont(new Font("Verdana", Font.PLAIN, 30));
		livesL.setBounds(10,50,200,40);
		
		g.add(scoreL);
		g.add(livesL);
		
		while(true) {
			if(counter%module==0) {
				switch(response) {
				case 0:bArray.add(bs.newPlusBomb(width)); break;
				case 1:bArray.add(bs.newMinusBomb(width)); break;
				case 2:bArray.add(bs.newProdhimBomb(width)); break;
				case 3:bArray.add(bs.newAllBomb(width)); break;
				case 4: System.exit(0);
				}
				g.add(bArray.get(bArray.size()-1));
			}
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i=0;i<bArray.size();i++) {
				bArray.get(i).move(1);
				if(bArray.get(0).getY()>height-200) {
					ck.initArray();
					lives--;
					livesL.setText("Lives: "+lives);
					bArray.get(0).destroy();
					bArray.get(0).setFont(new Font("Verdana", Font.PLAIN, 50));
					bArray.get(0).setForeground(Color.black);
					bArray.get(0).setText(""+bArray.get(0).output());
					
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
						bArray.get(0).setVisible(false);
				
					bArray.remove(0);
					
					if(lives==0) {
							JOptionPane.showMessageDialog(null,"Ju humbet :( . Rezultati qe arritet eshte "+score+" pike");
						     response = JOptionPane.showOptionDialog(null, "Deshironi qe te luani perseri?", "Math is BOMB",
						        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						        null, options, options[1]);
						    
						    
						    System.out.println(response);
							for(int k=0;k<bArray.size();k++) {
							bArray.get(k).setVisible(false);
							g.remove(bArray.get(k));
						}
						bArray.clear();
						lives=3;
						score=0;
						scoreL.setText("Score: "+score);
						livesL.setText("Lives: "+lives);
						
						counter =0;
						sleep = 4;
						module = 300;
						break;
						
					}
					
				}
				
				
				if(il.correctInput(ck.getArray(), bArray.get(0).output())) {
					ck.initArray();
					
					score++;
					scoreL.setText("Score: "+score);
					bArray.get(0).destroy();
					bArray.get(0).setText(""+bArray.get(0).output());
					bArray.get(0).setFont(new Font("Verdana", Font.PLAIN, 50));
	
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					bArray.get(0).setVisible(false);
					bArray.remove(0);
					
				}
				if(score>=10 && score<20) {
					sleep=3;
					module=275;
				}
				else if(score>=20) {
					sleep=2;
					module=225;
				}
				
			}
			
		counter++;
	
		}
		
		
	}
	
	public static void main(String[] args) {
		new Run();
	}

}
