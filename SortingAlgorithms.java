package Assignment2;
import java.util.*;
public class SortingAlgorithms {
	public static void BubbleSort(int[] a){
		for(int i = 0;i<a.length-1;i++) {
			for(int j = 0;j<a.length-1;j++) {
				if(a[j+1]<a[j]) {
					int tmp = a[j+1];
					a[j+1] = a[j];
					a[j] = tmp;
				}
			}
		}
	}
	public static void SelectionSort(int[] a) {
		for(int i = 0;i<a.length-1;i++) {
			int minIndex = i;
			int min = a[minIndex];
			for(int j = i+1;j<a.length;j++) {
				if(a[j]<min) {
					minIndex = j;
					min = a[j];
				}
			}
			int tmp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = tmp;
		}
	}
	public static void InsertionSort(int[] a) {
		/*for(int i = 0;i<a.length-1;i++) {
			if(a[i]>a[i+1]) {
				for(int j = i+1;j>0;j--) {
					if(a[j]<a[j-1]) {
						int tmp = a[j];
						a[j] = a[j-1];
						a[j-1] = tmp;
					}	
				}
			}
		}*/
		for(int i = 1;i<a.length;i++) {
			int tmp = a[i];
			int j = i-1;
			while(j>=0 && a[j]>tmp) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = tmp;
		}
	}
	public static void main(String[] args) {
		int[] a = {11,5,14,10,2};
		//BubbleSort(a);
		//SelectionSort(a);
		InsertionSort(a);
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
