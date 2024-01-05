package Assignment2;
public class BogoSort {
	public static void main(String[] args){
		int[] a = {33,22,11,44};
		bogoSort(a);
		for(int i = 0;i<4;i++)
			System.out.print(a[i]+" ");
		//System.out.println(isSorted(a));
	}
	public static boolean isSorted(int[] a) {
		for(int i = 0 ;i<a.length;i++){
			int min = 1000;
			for(int j = i;j<a.length;j++) {
				min = Math.min(a[j], min);
			}
			if(min!=a[i])
				return false;
		}
		return true;
	}
	public static void bogoSort(int[] a) {
		while(!isSorted(a)) {
			shuffle(a);
		}
	}
	public static void shuffle(int[] a) {
		int[] result = new int[a.length];
		boolean[] flag = new boolean[a.length];
		int index = (int) (Math.random()*a.length);
		for(int i = 0;i<a.length;i++) {
			 while(flag[index])
				index = (int)(Math.random()*a.length);
			flag[index] = true;
			result[i] = a[index];
		}
		for(int i = 0;i<result.length;i++)
			a[i] = result[i];
	}
}