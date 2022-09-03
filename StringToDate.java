import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

	public static void main(String[] args) throws Exception {
		String strDate = "14/06/2010";
		
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

		System.out.println(date.toString());

	}

}
