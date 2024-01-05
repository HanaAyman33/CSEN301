package Assignment2;
public class StudentsSort {
	String name;
	int id;
	double gpa;
	public StudentsSort(String n,int id,double gpa) {
		name = n;
		this.id = id;
		this.gpa = gpa;
	}
	public String toString() {
		return "Name: "+this.name+"\n"
				+" ID: "+this.id+"\n"
				+"  GPA: "+this.gpa;
	}
	public static StudentsSort[] sort(StudentsSort[] s) {
		StudentsSort tmp;
		for(int i = 0;i<s.length-1;i++) {
			for(int j = 0;j<s.length-1;j++) {
				if(s[i].name.compareToIgnoreCase(s[j].name)<0) {
					tmp = s[i];
					s[i] = s[j];
					s[j] = tmp;
				}
			}
		}
		return s;
	}
	public static void main(String[] args) {
		StudentsSort[] a = new StudentsSort[4];
		a[0] = new StudentsSort("Hana",4971,1.27);
		a[1] = new StudentsSort("Ahmed",8923,1.45);
		a[2] = new StudentsSort("Mai",22416,0.8);
		a[3] = new StudentsSort("Malak",4701,1.0);
		/*for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(a[i+1].name.charAt(0)<a[i].name.charAt(0)){
					StudentsSort tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
			}
		}*/
		sort(a);
		for(int i = 0;i<4;i++)
			System.out.println(a[i]);
	}
}