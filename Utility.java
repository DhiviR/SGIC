import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    static void StringToDate(String strDate) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

        System.out.println(date);
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    static String removeLeadingZeros(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                String res = num.substring(i);
                return res;
            }
        }

        return "0";
    }

    static String removeLeadingZerosRegex(String num) {
        return num.replaceAll("^0+(?!$)", "");
    }

    static boolean isAlphaNumeric(String str) {
        return str.matches("^[a-zA-Z0-9]*$");
    }
}
