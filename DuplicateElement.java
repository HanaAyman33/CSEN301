package Assignment4;

public class DuplicateElement {
	public static void main(String[] args) {
		StackObj s = new StackObj(3);
		s.push("Hend");
		s.push("Milad");
		s.push("Slim");
		StackObj n = new StackObj(3);
		n.push(3);
		n.push(1);
		n.push(2);
		duplicate(s,n).printStack();
	}
	public static StackObj duplicate(StackObj s,StackObj n) {
		StackObj tmp = new StackObj(3);
		int sum = 0;
		while(!n.isEmpty()) {
			sum+=(Integer)(n.top());
			tmp.push(n.pop());
		}
		while(!tmp.isEmpty())
			n.push(tmp.pop());
		StackObj result = new StackObj(sum);
		while(!n.isEmpty()) {
			int num = (Integer)n.top();
			for(int i = 0;i<num;i++)
				result.push(s.top());
			n.pop();
			s.pop();
		}
		return result;
	}
}
