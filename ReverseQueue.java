package Assignment5;
public class ReverseQueue {
	public static void main(String[] args) {
		QueueObj q = new QueueObj(4);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.printQueue();
		reverse(q).printQueue();
	}
	public static QueueObj reverse(QueueObj q) {
		StackObj s = new StackObj(q.size());
		while(!q.isEmpty())
			s.push(q.dequeue());
		while(!s.isEmpty())
			q.enqueue(s.pop());
		return q;
	}
}
