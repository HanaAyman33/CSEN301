package Assignment7;
public class Problem11 {
	public static void main(String[] args) {
		LinkList a = new LinkList();
		a.insertLast(1);
		a.insertLast(2);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(4);
		System.out.println(a.toString());
		LinkList b = new LinkList();
		a.insertLast(1);
		a.insertLast(2);
		a.insertLast(3);
		a.insertLast(4);
		a.insertLast(5);
		System.out.println(b.toString());
		System.out.println(diff(a,b).toString());
		
		//System.out.println(a.toString());
		}
	public static LinkList merge(LinkList a) {//1st required
		LinkList rev = new LinkList();
		while(!a.isEmpty()) {
			rev.insertLast(a.removeFirst());
			if(a.isEmpty())
				break;
			rev.insertLast(a.removeLast());
		}
		return rev;
	}
	public static boolean equals(LinkList a,LinkList b){ //2nd required
		while(!a.isEmpty() && !b.isEmpty()) {
			if(a.getFirst()!=b.getFirst())
				return false;
			a.removeFirst();
			b.removeFirst();
		}
		return true;
	}
	public static LinkList intersect(LinkList a,LinkList b) {//3rd required
		LinkList res = new LinkList();
		int cnt = count(a);
		for(int i = 0;i<cnt;i++) {
			for(int j = i+1;j<cnt;j++) {
				if(b.getFirst()==a.getFirst()){
					res.insertLast(a.getFirst());
					break;
				}
				else {
					a.insertLast(a.removeFirst());
				}
			}
			b.removeFirst();
		}
		return res;
	}
	public static int count(LinkList a) {//continue 3rd
		int cnt = 0;
		while(!a.isEmpty()) {
			a.removeFirst();
			cnt++;
		}
		return cnt;
	}
	public static LinkList diff(LinkList a,LinkList b) {
		LinkList res = new LinkList();
		LinkList tmp = new LinkList();
		while(!a.isEmpty()) {
			Object k = a.removeFirst();
			boolean flag = true;
			while(!b.isEmpty()) {
				tmp.insertLast(b.getFirst());
				if(k.equals(b.removeFirst())) {
					flag = false;
					break;
				}
			}
			if(flag)
				res.insertLast(k);
			while(!tmp.isEmpty())
				b.insertLast(tmp.removeFirst());
		}
		return res;
	}
	public static LinkList union(LinkList a,LinkList b) {//5th required
		LinkList res = new LinkList();
		while(!a.isEmpty())
			res.insertLast(a.removeFirst());
		while(!b.isEmpty())
			res.insertLast(b.removeFirst());
		return res;
		//return merge(diff(LinkList a,LinkList b));
	}
}
