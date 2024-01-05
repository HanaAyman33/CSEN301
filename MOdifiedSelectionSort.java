package Assignment2;
public class MOdifiedSelectionSort {
	public static void SelectionSort(int[] a) {
		for(int i = 0;i<a.length/2;i++) {
			int minIndex = i;
			int min = a[minIndex];
			int maxIndex = i;
			int max = a[maxIndex];
			for(int j = i+1;j<a.length-i;j++) {
				if(a[j]<min) {
					minIndex = j;
					min = a[j];
				}
				if(a[j]>max) {
					maxIndex = j;
					max = a[j];
				}
			}
			a[minIndex] = a[i];
			a[i] = min;
			if(maxIndex==i)
				maxIndex = minIndex;
			a[maxIndex] = a[a.length-i-1];
			a[a.length-i-1] = max;
		}
	}
	public static void main(String[] args) {
		int[] a = {11,5,14,10,2};
		SelectionSort(a);
		for(int i = 0;i<a.length;i++)	
			System.out.print(a[i]+" ");
	}
}