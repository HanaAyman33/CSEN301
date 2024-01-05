package Assignment5;
public class MirrorQueue {
	public static void main(String[] args) {
		QueueObj q = new QueueObj(3);
		q.enqueue('d');
		q.enqueue('a');
		q.enqueue('d');
		//q.printQueue();
		//mirror(q).printQueue();
		
	}
	public static QueueObj mirror(QueueObj q) {
		QueueObj tmp = new QueueObj(q.size()*2);
		for(int i = 0;i<q.size();i++) {
			for(int j = 0;j<q.size()-1;j++)
				q.enqueue(q.dequeue());
			tmp.enqueue(q.peek());
		}
		int size = q.size();
		for(int i = 0;i<size;i++)
			tmp.enqueue(q.dequeue());
		return tmp;
	}
}
