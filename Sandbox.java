import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sandbox {
    public static void main(String[] args) {
        String input3 = "2022-11-10T09:30:00+09:00";
        String input4 = "2022-11-16T09:33:00+09:00";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTime0 = LocalDateTime.parse(input3, formatter);
        LocalDateTime dateTime1 = LocalDateTime.parse(input4, formatter);
        System.out.println(dateTime0.compareTo(dateTime1));
//        System.out.println(date0.isBefore(date1));
    }
}
