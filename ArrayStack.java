package Assignment3;
public class ArrayStack {
	private int[] theStack;
	private int maxSize;
	private int top;

	public ArrayStack(int s) {
		maxSize = s;
		theStack = new int[maxSize];
		top = -1;
	}

	public void push(int elem) {
		top++;
		theStack[top] = elem;
	}

	public int pop() {
		int result = theStack[top];
		top--;
		return result;
	}

	public int top() {
		return theStack[top];
	}

	public boolean isFull() {
		return (top == (maxSize - 1));
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return (top + 1);
	}
	public ArrayStack reverse1() {
		ArrayStack x = new ArrayStack(4);
		for(int i = top;i>=0;i--)
			x.push(theStack[i]);
		return x;
	}
	public void printStack() {
		if (top == -1)
			System.out.println("Stack is empty!!\n");
		else {
			System.out.println(theStack[top] + " <- top");
			for (int i = top - 1; i >= 0; i--)
				System.out.println(theStack[i]);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(4);
		s.push(2);
		s.push(6);
		s.push(3);
		s.push(4);
		s.reverse1().printStack();
	}

}