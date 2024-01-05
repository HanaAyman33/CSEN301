//Queue ADT implemented using stacks
package Assignment5;

public class Queue {
	StackObj s;
	int size;
	int nItems;
	public Queue(int size) {
		s = new StackObj(size);
		this.size = size;
		nItems = 0;
	}
	public void enqueue(int x) {
		StackObj tmp = new StackObj(size);
		if(nItems<size) {
			tmp.push(x);
			while(!tmp.isEmpty())
				s.push(tmp.pop());
			nItems++;
		}
	}
	public int dequeue() {
		return (Integer)s.pop();
	}
	public boolean isFull() {
		return nItems==size;
	}
	public boolean isEmpty() {
		return nItems==0;
	}
	public int size() {
		return size;
	}
}