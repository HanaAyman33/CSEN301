package Assignment3;

public class StackDecompose {
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(8);
		s.push(6);
		s.push(9);
		s.push(3);
		s.push(5);
		s.push(4);
		s.push(1);
		s.push(2);
		s.push(7);
		//s.display();
		decompose(s).printStack();;
	}
	public static ArrayStack decompose(ArrayStack s) {
		int maxSize = s.size();
		ArrayStack even = new ArrayStack(maxSize/2);
		ArrayStack odd = new ArrayStack(maxSize/2);
		while(!s.isEmpty()) {
			odd.push(s.pop());
			even.push(s.pop());
		}
		ArrayStack y = new ArrayStack(maxSize/2);
		while(!even.isEmpty())
			y.push(even.pop());
		return y;
	}
}
