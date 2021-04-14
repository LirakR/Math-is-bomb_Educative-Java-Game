import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ControllKeys extends KeyAdapter {

	List<Integer> inputs=new ArrayList<Integer>(4);
	
	InputLogic il = new InputLogic();
	public ControllKeys() {
		initArray();
	}
	
	public void initArray() {
		inputs.clear();
		for(int i=0;i<4;i++) {
			inputs.add(i,(int)Double.POSITIVE_INFINITY);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_0) {
			
			inputs.add(0);
			inputs.remove(0);
			System.out.println("0");
		}
		if(e.getKeyCode()==KeyEvent.VK_1) {
			
			inputs.add(1);
			inputs.remove(0);
			System.out.println("1");
		}
		if(e.getKeyCode()==KeyEvent.VK_2) {

			inputs.add(2);
			inputs.remove(0);
			System.out.println("2");
		}
		if(e.getKeyCode()==KeyEvent.VK_3) {
			inputs.add(3);
			inputs.remove(0);
			System.out.println("3");
		}
		if(e.getKeyCode()==KeyEvent.VK_4) {

			inputs.add(4);
			inputs.remove(0);
			System.out.println("4");
		}
		if(e.getKeyCode()==KeyEvent.VK_5) {

			inputs.add(5);
			inputs.remove(0);
			System.out.println("5");
		}
		if(e.getKeyCode()==KeyEvent.VK_6) {

			inputs.add(6);
			inputs.remove(0);
			System.out.println("6");
		}
		if(e.getKeyCode()==KeyEvent.VK_7) {

			inputs.add(7);
			inputs.remove(0);
			System.out.println("7");
		}
		if(e.getKeyCode()==KeyEvent.VK_8) {
			inputs.add(8);
			inputs.remove(0);
			System.out.println("8");
		}
		if(e.getKeyCode()==KeyEvent.VK_9) {

			inputs.add(9);
			inputs.remove(0);
			System.out.println("9");
		}
		if(e.getKeyCode()==KeyEvent.VK_P) {
			System.out.print("P: ");
			System.out.println(toString());
		}
	}
	
	public void KeyPressed(KeyEvent e) {



	}
	
	public String toString() {
		String s=inputs.toString();
		return s;
	}
	
	public List<Integer> getArray() {
		return this.inputs;
	}
	
}
