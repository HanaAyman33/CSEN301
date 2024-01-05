package Assignment6;
public class University implements Comparable{
	String name;
	int rank;
	public University(String n,int r) {
		name = n;
		rank = r;
	}
	public int compareTo(Object o) {
		University u = (University) o;
		if(rank<u.rank)
			return -1;
		if(rank>u.rank)
			return 1;
		return name.compareTo(u.name);
	}
	public String toString() {
		return "Name: "+name+"\n"+"rank: "+rank;
	}
	public static void main(String[] args) {
		PriorityQueue p = new PriorityQueue(3);
		p.insert(new University("GUC",1));
		p.insert(new University("AUC",10));
		p.insert(new University("BUE",8));
		for(int i = 0;i<3;i++) {
			System.out.println(p.remove().toString());
		}
	}
}
