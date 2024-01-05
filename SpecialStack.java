package Assignment3;
public class SpecialStack {
	ArrayStack origin;
	ArrayStack min;
	public SpecialStack(int s) {
		origin = new ArrayStack(s);
		min = new ArrayStack(s);
	}
	public void push(int x) {
		origin.push(x);
		if(!min.isEmpty()) {
			int minSoFar = min.top();
			if(x<minSoFar)
				min.push(x);
			else
				min.push(minSoFar);
		}
		else 
			min.push(x);
	}
	public int top() {
		return origin.top();
	}
	public int pop() {
		int num = origin.top();
		origin.pop();
		return num;
	}
	public int getMin() {
		return min.top();
	}
	public boolean isEmpty() {
		return origin.isEmpty();
	}
	public boolean isFull() {
		return origin.isFull();
	}
	public void printStack() {
		origin.printStack();
	}
	public static void main(String[] args) {
		SpecialStack s = new SpecialStack(4);
		s.push(9);
		s.push(-1);
		s.push(500);
		s.push(21);
		s.printStack();
		System.out.println("Minimum is: "+ s.getMin());
	}
}
