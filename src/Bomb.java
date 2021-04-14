import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bomb extends JLabel {
	
	private int xPos;
	private int yPos;
	private ImageIcon img;
	private int numberA;
	private int numberB;
	private char operator;
	
	private JPanel panel;
	
	int maxPlus=100;
	int maxMinus=100;
	int maxProdhim=10;
	Random r = new Random();
	
	
	public Bomb(int x,int y,int nrA,int nrB,char operator) {
		this.xPos=x;
		this.yPos=y;
		this.numberA=nrA;
		this.numberB=nrB;
		this.operator=operator;
		switch(this.getOperator()) {
		case '+':this.img=resizeImg(new ImageIcon("bomb0.png"),200); break;
		case '-':this.img=resizeImg(new ImageIcon("bomb1.png"),200); break;
		case 'x':this.img=resizeImg(new ImageIcon("bomb2.png"),200); break;
		}
		//this.img=resizeImg(new ImageIcon("bomb0.png"),200);
	
		setFont(new Font("Verdana", Font.PLAIN, 20));
		setForeground(Color.black);
		
		setHorizontalTextPosition(CENTER);
		setVerticalTextPosition(CENTER);
		
		setText(textOutput());

		
		setIconTextGap(0);
		setIcon(img);
		setBounds(xPos, yPos,200,200);
	}
	
	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setX(int newX) {
		xPos=newX;
	}

	public void setY(int newY) {
		yPos=newY;
	}
	

	public int getA() {
		return numberA;
	}
	
	public int getB() {
		return numberB;
	}
	
	public void setA(int newA) {
		this.numberA=newA;
	}
	public void setB(int newB) {
		this.numberB=newB;
	}
	
	public char getOperator() {
		return this.operator;
	}
	
	public void setOperator(char newOperator) {
		this.operator=newOperator;
	}
	
	public String textOutput() {
		return ""+getA()+ getOperator()+getB();
		
	}
	
	public int output() {
		 int rez=0;
			switch(getOperator()) {
			case '+': rez=getA()+getB(); break;
			case '-': rez=getA()-getB();  break;
			case 'x': rez=getA()*getB();  break;
			}
			return Math.abs(rez);
		 
		}

	public Bomb newBomb() {
		int x=r.nextInt(1200);
		int nrA=0;
		int nrB =0;
		
//		teksti(panel,x,100);
		
		
		char operator = '+';
		switch(r.nextInt(3)) {
		case 0: operator='+';nrA=r.nextInt(maxPlus-2)+2; nrB=r.nextInt(maxPlus-2)+2; break;
		case 1: operator='-'; nrA=r.nextInt(maxMinus-2)+2; nrB=r.nextInt(maxMinus-2)+2;  break;
		case 2: operator='x'; nrA=r.nextInt(maxProdhim-2)+2; nrB=r.nextInt(maxProdhim-2)+2;  break;
		}
		if(nrA<nrB) {
			int nrT = nrB;
			nrB=nrA;
			nrA=nrT;
		}
		
		Bomb b = new Bomb(x,100,nrA,nrB,operator);
		return b;
	}
	
	
	public char randomOperator() {
		char rez='+';
		switch(r.nextInt(2)) {
		case 0: rez='+'; break;
		case 1: rez='-'; break;
		case 2: rez='*'; break;
		default: rez='+'; break;
		}
		return rez;
	}
	
	
	public ImageIcon getImage() {
		return img;
	}
	public int getImageWidth() {
		return img.getIconWidth();
	}
	public void setImage(String newImg) {
		setIcon(new ImageIcon(newImg));
	}
	
	private ImageIcon resizeImg(ImageIcon image,int cWidth) {
		double k = image.getIconWidth()/cWidth;

		ImageIcon imageS = new ImageIcon(image.getImage().getScaledInstance(cWidth,(int)(image.getIconWidth()/k), Image.SCALE_DEFAULT));

		return imageS;
	}
	
	public int rezultati() {
		
		int rez=0;
		switch(this.operator) {
		case '+' : rez=this.numberA+this.numberB; break;
		case '-' : rez=this.numberA-this.numberB; break;
		case '*' : rez=this.numberA*this.numberB; break;
		default: System.out.println("Operatori i gabuar");
		}
		
		return rez;
	}

	public String toString(List<Bomb> a ) {
		String s=a.toString();
		return s;
	}
	
	
	public void move(int a){	
			this.setY(this.getY()+a);
	}
	
	
	public void destroy() {
		setImage("explosion.gif");
		//System.out.println("destroy");
	}

}
