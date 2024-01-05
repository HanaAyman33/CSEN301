package Assignment3;

public class InsertionSortInStacks {
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(5);
		s.push(5);
		s.push(90);
		s.push(24);
		s.push(47);
		stackSort(s);
	}
	public static void stackSort(ArrayStack x){
		int Size = x.size();
		ArrayStack tmp1 = new ArrayStack(Size);
		ArrayStack tmp2 = new ArrayStack(Size);
		while(!x.isEmpty()) {
			int tmp = x.pop();
			if(tmp1.isEmpty())
				tmp1.push(tmp);
			else {
				while(!tmp1.isEmpty() && tmp1.top()>tmp)
					tmp2.push(tmp1.pop());
				tmp1.push(tmp);
				while(!tmp2.isEmpty())
					tmp1.push(tmp2.pop());
			}
		}
		while(!tmp1.isEmpty())
			tmp2.push(tmp1.pop());
		tmp2.printStack();
	}
}
