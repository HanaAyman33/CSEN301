package Assignment3;
public class ReverseStack {
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(4);
		s.push(2);
		s.push(6);
		s.push(3);
		s.push(4);
		reverse2(s).printStack();
	}
	public static ArrayStack reverse2(ArrayStack s) {
		int Size = s.size();
		ArrayStack x = new ArrayStack(Size);
		ArrayStack tmp = new ArrayStack(Size);
		while(!s.isEmpty()) {
			x.push(s.top());
			tmp.push(s.pop());
		}
		while(!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		return x;
	}
	
}