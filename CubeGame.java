package Assignment3;
public class CubeGame {
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(5);
		s.push(9);
		s.push(3);
		s.push(8);
		s.push(8);
		s.push(4);
		//s.printStack();
		System.out.println(check(s));
	}
	public static boolean check(ArrayStack s) {
		int Size = s.size();
		int sum1 = 0,sum2 = 0;
		ArrayStack x = new ArrayStack(Size);
		while(!s.isEmpty()) {
			if((s.size()-1)>(Size/2)) {
				sum1+=s.top();
				x.push(s.pop());
			}
			else if((s.size()-1)==Size/2)
				x.push(s.pop());
			else {
				sum2+=s.top();
				x.push(s.pop());
			}
		}
		while(!x.isEmpty())
			s.push(x.pop());
		return sum1==sum2;
	}
}
