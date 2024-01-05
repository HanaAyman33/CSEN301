package Assignment11;
import java.util.Arrays;
import java.util.HashSet;
public class RemoveDups {
	public static void main(String[] args) {
		int[] a = {1,2,3,56,4,2,5,8,1};
		System.out.println(Arrays.toString(remove(a)));
	}
	public static int[] remove(int[] a) {
		HashSet hs = new HashSet();
		int[] tmp = new int[a.length];
		int cnt = 0;
		for(int i = 0;i<a.length;i++) {
			if(!hs.contains(a[i]))
				tmp[cnt++] = a[i];
			hs.add(a[i]);
		}
		int[] res = new int[cnt];
		for(int i = 0;i<cnt;i++)
			res[i] = tmp[i];
		return res;
	}
}
