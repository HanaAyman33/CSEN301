package Assignment4;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Link {
	String url;
	String date;
	int frequency;
	public Link(String url) {
		this.url = url;
		frequency = 0;
		Calendar cal = Calendar.getInstance();
		Date calDate = cal.getTime();
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM--dd");
		try {
			date = f1.format(calDate);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Link(String url,int frequency) {
		this(url);
		this.frequency = frequency;
	}
	public String toString() {
		return url+" "+date+" frequency: "+frequency;
	}
}
