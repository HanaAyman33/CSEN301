package Assignment5;
public class EveryThirdElement {
	public static void main(String[] args) {
		QueueObj q = new QueueObj(10);
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.enqueue('d');
		q.enqueue('e');
		q.enqueue('f');
		q.enqueue('g');
		q.enqueue('h');
		q.enqueue('i');
		q.enqueue('j');
		//q.printQueue();
		third(q).printQueue();
	}
	public static QueueObj third(QueueObj q) {
		QueueObj rev = new QueueObj(q.size()/2);
		StackObj s = new StackObj(q.size());
		while(!s.isFull()) {
			s.push(q.peek());
			q.enqueue(q.dequeue());
		}
		rev.enqueue(s.pop());
		int cnt = 0;
		while(!s.isEmpty()) {
			cnt++;
			if(cnt%3==0)
				rev.enqueue(s.pop());
			else
				s.pop();
		}
		return rev;
	}
}
