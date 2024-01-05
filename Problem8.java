package Assignment7;
public class Problem8 {
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
		System.out.println(cut(a).toString());
	}
	public static LinkList cut(LinkList a) {
		LinkList res = new LinkList();
		while(!a.isEmpty()) {
			res.insertLast(a.removeFirst());
			if(a.isEmpty())
				break;
			res.insertFirst(a.removeLast());
		}
		return res;
	}
}
