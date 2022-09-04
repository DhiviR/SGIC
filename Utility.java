package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public Date stringToDate(String strDate) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
        return date;
    }

    public boolean isNullOrEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String removeLeadingZeros(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                String res = num.substring(i);
                return res;
            }
        }

        return "0";
    }

    public String removeLeadingZerosRegex(String num) {
        return num.replaceAll("^0+(?!$)", "");
    }

    public boolean isAlphaNumeric(String str) {
        return str.matches("^[a-zA-Z0-9]*$");
    }
}
