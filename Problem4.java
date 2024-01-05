package Assignment7;
public class Problem4 {
	public static void main(String[] args) {
		LinkList a = new LinkList();
		a.insertFirst(1);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(3);
		a.insertLast(4);
		a.insertLast(4);
		a.insertLast(5);
		System.out.println(a.toString());
		removeDup(a);
		System.out.println(a.toString());
	}
	public static void removeDup(LinkList a) {
		LinkList tmp = new LinkList();
		tmp.insertFirst(a.removeFirst());
		while(!a.isEmpty()) {
			if(tmp.getLast()!=a.getFirst())
				tmp.insertLast(a.removeFirst());
			else
				a.removeFirst();
		}
		while(!tmp.isEmpty())
			a.insertLast(tmp.removeFirst());
	}
}
