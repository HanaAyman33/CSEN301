package Assignment2;
public class ShakerSort {
	public static void shaker(int[] a) {
		for(int k = 0;k<(a.length)/2;k++) {
			for(int i = 0;i<a.length-1;i++) {
				if(a[i]>a[i+1]) {
					int tmp1 = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp1;
				}
			}
			for(int i = a.length-1;i>1;i--) {
				if(a[i]<a[i-1]) {
					int tmp2 = a[i];
					a[i] = a[i-1];
					a[i-1] = tmp2;
				}
			}
		}
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args) {
		int[] a = {7,5,11,10,8};
		shaker(a);
	}
}
