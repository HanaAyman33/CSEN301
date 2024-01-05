package Assignment8;
public class Problem7 {
	public static void main(String[] args) {
		DoublyLinkedList a = new DoublyLinkedList();
		a.insertLast(1);
		a.insertLast(1);
		a.insertLast(1);
		a.insertLast(1);
		a.displayForward();
		System.out.println();
	}//Problem7 f
	public static DoublyLinkedList insertionSort(DoublyLinkedList a) {
		DoublyLinkedList res = new DoublyLinkedList();
		while(!a.isEmpty()) {
			if(res.isEmpty())
				res.insertFirst(a.removeFirst());
			else {
				Object tmpVal = a.removeFirst();
				DoublyLinkedList tmp = new DoublyLinkedList();
				boolean added = false;
				while(!added) {
					if(res.isEmpty()) {
						res.insertFirst(tmpVal);
						added = true;
						break;
					}
					else {
						Comparable remove = (Comparable) res.removeFirst();
						if(remove.compareTo(tmpVal)<0)
							tmp.insertLast(remove);
						else {
							res.insertFirst(remove);
							res.insertFirst(tmpVal);
							added = true;
						}
					}
				}
				while(!tmp.isEmpty())
					res.insertFirst(tmp.removeFirst());
			}
		}
		return res;
	}

	//Problem7 k
	public static int count(DoublyLinkedList a) {
		DoublyLinkedList tmp = new DoublyLinkedList();
		int cnt = 0;
		while(!a.isEmpty()) {
			cnt++;
			tmp.insertLast(a.removeFirst());
		}
		while(!tmp.isEmpty())
			a.insertLast(tmp.removeFirst());
		return cnt;
	}
}
