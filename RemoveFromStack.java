package Assignment3;
public class RemoveFromStack {
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(4);
		s.push(3);
		s.push(90);
		s.push(24);
		s.push(77);
		remove(s,2);
		s.printStack();
	}
	public static void remove(ArrayStack s,int x) {
		ArrayStack tmp = new ArrayStack(s.size());
		int pos = s.size()-1;
		while(!s.isEmpty()) {
			if(x==pos+1) {
				s.pop();
				break;
			}
			else
				tmp.push(s.pop());
			pos--;
		}
		while(!tmp.isEmpty())
			s.push(tmp.pop());
	}
}
