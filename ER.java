package Assignment6;
public class ER{
	PriorityQueue patients;
	public ER(int size) {
		patients = new PriorityQueue(size);
	}
	public void newPatient(String n,int p) {
		patients.insert(new Patient(n,p));
	}
	public Patient nexPatient() {
		return (Patient)patients.remove();
	}
	public void display() {
		int s = patients.size();
		for(int i = 0;i<s;i++) {
			System.out.println(patients.remove().toString());
		}
	}
	public static void main(String[] args){
		ER m = new ER(3);
		m.newPatient("O",60);
		m.newPatient("L",20);
		m.newPatient("K",40);
		m.display();
		//System.out.println(m.nexPatient().toString());
		//System.out.println();
		//m.display();
	}
}
