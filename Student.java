package Assignment4;
public class Student {
	String name;
	double gpa;
	public Student(String name,double gpa) { 
		this.name = name;
		this.gpa = gpa;
	}
	public static double average(StackObj students) {
		double sum = 0;
		int Size = students.size();
		while(!students.isEmpty()) {
			Student s = (Student) students.pop();
			double d  =  s.gpa;
			sum+=d;
		}
		return sum/Size;
	}
	public static void main(String[] args) {
		StackObj students = new StackObj(4);
		students.push(new Student("Esraa",1.0));
		students.push(new Student("Hana",1.2));
		students.push(new Student("Mai",0.9));
		students.push(new Student("Yasmeen",1.78));
		System.out.println("Average: "+average(students));
	}
}