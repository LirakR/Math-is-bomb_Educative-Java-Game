import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bombs {
    static Bomb b = new Bomb(10,10,100,100,'+');
	static List<Bomb> bArray= new ArrayList<Bomb>();
	Random r = new Random();
	
	Gui g;
	
	int maxPlus=20;
	int maxMinus=20;
	int maxProdhim=10;
	
	int nrA=0;
	int nrB =0;
	char operator = '+';
	
	public Bombs() {
		
	}
	
	public Bomb newAllBomb(int width) {
		int x=r.nextInt(width-200);
	
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
		
		Bomb b = new Bomb(x,-200,nrA,nrB,operator);
		return b;
	}
	
	public Bomb newPlusBomb(int width) {
		int x=r.nextInt(width-200);
	
		operator='+';nrA=r.nextInt(maxPlus-2)+2; nrB=r.nextInt(maxPlus-2)+2;
		if(nrA<nrB) {
			int nrT = nrB;
			nrB=nrA;
			nrA=nrT;
		}
		
		Bomb b = new Bomb(x,-100,nrA,nrB,operator);
		return b;
	}
	
	public Bomb newMinusBomb(int width) {
		int x=r.nextInt(width-200);

		 operator='-';nrA=r.nextInt(maxMinus-2)+2; nrB=r.nextInt(maxMinus-2)+2;
		 
		if(nrA<nrB) {
			int nrT = nrB;
			nrB=nrA;
			nrA=nrT;
		}
		
		
		Bomb b = new Bomb(x,-100,nrA,nrB,operator);
		return b;
	}
	
	public Bomb newProdhimBomb(int width) {
		int x=r.nextInt(width-200);
		
		operator='x';nrA=r.nextInt(maxProdhim-2)+2; nrB=r.nextInt(maxProdhim-2)+2;
		
		if(nrA<nrB) {
			int nrT = nrB;
			nrB=nrA;
			nrA=nrT;
		}
		
		Bomb b = new Bomb(x,-100,nrA,nrB,operator);
		return b;
	}
	
	
}
