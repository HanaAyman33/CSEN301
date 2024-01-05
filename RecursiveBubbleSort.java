package Assignment2;
public class RecursiveBubbleSort {
	public static String BubbleSort(int[] a,int i,int k) {
		if(k==0)
			return"";
		else {
			for(int j = 0;j<a.length-1;j++) {
				if(a[j]>a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
			return BubbleSort(a,++i,--k)+" "+a[k];
		}
	}
	public static void bubble2(int[] a,int i) {
		if(i==a.length)
			return;
		for(int j =-0;j<a.length-1;j++) {
			if(a[i]<a[i+1]) {
				int tmp = a[i];
				a[i] = a[i+1];
				a[i+1] = tmp;
			}
		}
		bubble2(a,++i);
	}
	public static void main(String[] args) {
		int[] a = {11,5,14,10,2};
		System.out.println(BubbleSort(a,0,a.length));
	}
}