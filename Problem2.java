package Assignment7;
public class Problem2 {
	public static void main(String[] args) {
		LinkList a = new LinkList();
		a.insertFirst(1);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(8);
		a.insertLast(10);
		a.insertLast(15);
		System.out.println(a.toString());
		reverse(a);
		System.out.println(a.toString());
	}
	public static void reverse(LinkList a) {
		LinkList A = new LinkList();
		while(!a.isEmpty())
			A.insertFirst(a.removeLast());
		while(!A.isEmpty())
			a.insertFirst(A.removeFirst());
	}
}
