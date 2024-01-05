package Assignment6;
public class Patient implements Comparable{
	String name;
	int degree;
	public Patient(String n,int d) {
		name = n;
		degree = d;
	}
	public int compareTo(Object o) {
		Patient p = (Patient) o;
		if(degree<p.degree)
			return -1;
		if(degree>p.degree)
			return 1;
		return 0;
	}
	public String toString() {
		return "Name: "+name+"\n"+"Severity Degree: "+degree;
	}
}
