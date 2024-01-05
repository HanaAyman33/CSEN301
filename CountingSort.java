package Assignment2;
public class CountingSort {
	public static void BooleanSort(int[] a) {
		int max = 0;
		for(int i = 0;i<a.length;i++)
			max = Math.max(max, a[i]);
		boolean[] flag = new boolean[max+1];
		for(int i = 0;i<a.length;i++)
			flag[a[i]] = true;
		for(int i = 0;i<flag.length;i++) {
			if(flag[i])
				System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		int[] a = {8,5,1};
		//BooleanSort(a);
		countingSort(a);
	}
	public static void countingSort(int[] a) {
		int max = 0;
		for(int i = 0;i<a.length;i++)
			max = Math.max(max, a[i]);
		int[] flag = new int[max+1];
		for(int i = 0;i<a.length;i++)
			flag[a[i]]++;
		int index = 0;
		int[] result = new int[a.length];
		for(int i = 0;i<flag.length;i++) {
			while(flag[i]>0) {
				result[index] = i;
				index++;
				flag[i]--;
			}
		}
		for(int i =0 ;i<a.length;i++)
			System.out.print(result[i]+" ");
	}
}
