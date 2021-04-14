import java.util.ArrayList;
import java.util.List;

public class InputLogic {

	public InputLogic() {
		
	}
	
	public boolean correctInput(List<Integer> uInput,int correct) {
		boolean rez=false;
		int checkCounter=0;
		List<Integer> correctL = intToList(correct);
		for(int i=0;i<=uInput.size()-correctL.size();i++) {
			checkCounter=0;
			for(int j=0;j<correctL.size();j++) {
				if(uInput.get(i+j)==correctL.get(j)) {
					checkCounter++;
					if(checkCounter==correctL.size()) {
						rez=true;
					}
				}
			}
		}

		return rez;
	}
	
	static public String toString(List<Integer> a) {
		String s=a.toString();
		return s;
	}
	
	
	public List<Integer> intToList(int n) {
		List<Integer> list= new ArrayList<Integer>();
		String nS= ""+n;
		for(int i=0;i<nS.length();i++) {
			int power =(int)(Math.pow(10,nS.length()-i-1));
			list.add(n/power);
			n=n-(n/power)*power;
			
		}

		return list;
	}
	

}