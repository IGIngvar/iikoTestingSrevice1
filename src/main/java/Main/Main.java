package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String formate = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat sf = new SimpleDateFormat(formate);
        String date = sf.format(new Date());
        System.out.println(date);

    }
}
