package test.date_time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LocalDateTimeTest {

    @Test
    public void testLocalDate(){

        LocalDate date = LocalDate.now();

        System.out.println(date.getYear());
        System.out.println(date.getMonth().getValue());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());

        LocalTime time = LocalTime.now();

        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());

        LocalDate date1 = LocalDate.parse("2017:10:22", DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        System.out.println(date1.toString());

        LocalTime time1 = LocalTime.parse("12-03-01",DateTimeFormatter.ofPattern("HH-mm-ss"));
        System.out.println(time1.toString());

        LocalDateTime dateTime = LocalDateTime.of(date,time);
        System.out.println(dateTime);

        dateTime.with(ChronoField.MONTH_OF_YEAR,1);

        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy:MM:dd -> HH-mm-ss")));

    }

}
