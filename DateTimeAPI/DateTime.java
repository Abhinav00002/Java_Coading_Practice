package DateTimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class DateTime {
    public static void main(String[] args) {
        //Today's Date
        LocalDate today= LocalDate.now();
        System.out.println("Todays Date: "+today);

        //Today's Time
        LocalTime  time=LocalTime.now();
        System.out.println("Today Time"+ time);
        System.out.println("Hours: "+time.getHour());
        System.out.println("Minutes: "+time.getMinute());
        System.out.println("Nano Second: "+ time.getNano());
        System.out.println("Nano of Day: "+ time.toNanoOfDay());


        //Todays Date Time
        LocalDateTime dateTimes=LocalDateTime.now();
        System.out.println("Todays Date Time: "+dateTimes);
        System.out.println("Today day's in Year: "+ dateTimes.getDayOfYear());
        System.out.println("Today year From 2019: "+ dateTimes.withYear(2019));


    }
}
