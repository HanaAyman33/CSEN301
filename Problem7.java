package Assignment7;
public class Problem7{
	public static void main(String[] args) {
		LinkList a = new LinkList();
		a.insertLast(1);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(4);
		a.insertLast(5);
		a.insertLast(6);
		a.insertLast(7);
		System.out.println(a.toString());
		add(a);
		System.out.println(a.toString());
	}
	public static void add(LinkList a) {
		LinkList tmp = new LinkList();
		while(!a.isEmpty()) {
			int x = (Integer)a.removeFirst() + 1;
			tmp.insertLast(x);
		}
		while(!tmp.isEmpty())
			a.insertLast(tmp.removeFirst());
	}
}
