package Assignment11;

import java.util.HashSet;

public class Difference {
	public static void main(String[] args) {
		int[] a = {1,2,3,5,7,9,10};
		int[] b = {2,3,4,6,8,10};
		HashSet hashA = new HashSet();
		HashSet hashB = new HashSet();
		LinkList res = new LinkList();
		for(int i = 0;i<b.length;i++)//B-A
			hashB.add(b[i]);
		for(int i = 0;i<a.length;i++) {
			if(!hashB.contains(a[i]))
				res.insertLast(a[i]);
		}
		for(int i = 0;i<a.length;i++)//A-B
			hashA.add(a[i]);
		for(int i = 0;i<b.length;i++) {
			if(!hashA.contains(b[i]))
				res.insertLast(b[i]);
		}
		System.out.println(res.toString());
	}
}
