package Assignment2;
public class IndexSort {
	public static void IndexSort(int[] a) {
		int index = 0;
		int[] b = new int[a.length];
		for(int i = 0;i<a.length;i++) {
			for(int j = 0;j<a.length;j++) {
				if(a[i]>a[j])
					index++;
				if(b[j]==a[i] && j<a.length-1) {
					index = j+1;
					break;
				}
			}
			b[index] = a[i];
			index = 0;
		}
		for(int i = 0;i<b.length;i++)
			System.out.print(b[i]+" ");
	}
	public static void main(String[] args) {
		int[] a = {4,3,8,4};
		IndexSort(a);
	}
}
