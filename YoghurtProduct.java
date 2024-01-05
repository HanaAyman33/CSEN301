package Assignment6;
import java.time.LocalDate;
public class YoghurtProduct implements Comparable{
	int id;
	double price;
	LocalDate date;
	public YoghurtProduct(int i,double p,LocalDate d) {
		id = i;
		price = p;
		date = d;
	}
	public int compareTo(Object o) {
		YoghurtProduct y = (YoghurtProduct) o;
		if(id>y.id)
			return 1;
		if(id<y.id)
			return -1;
		return 0;
		//return date.compareTo(y.date);
	}
}
