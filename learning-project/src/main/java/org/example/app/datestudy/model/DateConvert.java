package org.example.app.datestudy.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateConvert {
    private LocalTime time;
    private LocalDate date;
    private LocalDateTime localDateTime;

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setLocalDateTime(LocalDate date, LocalTime time){
        this.localDateTime = LocalDateTime.of(date, time);
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public DateConvert(String input){
        convertFromString(input);
    }

    public void convertFromString(String input){
        int year, month, day;
        if(input.contains(" ") && input.contains(":")){
            int hour, minute, second;
            String[] dateAndTime = input.split(" ");
            for(String strValue : dateAndTime){
                if(strValue.contains(":")){
                    String[] times = strValue.split(":");
                    hour = Integer.parseInt(times[0]);
                    minute = Integer.parseInt(times[1]);
                    if(times.length < 3) {
                        LocalTime localTime = LocalTime.of(hour, minute);
                        setTime(localTime);
                    }
                    else{
                        second = Integer.parseInt(times[2]);
                        LocalTime localTime = LocalTime.of(hour, minute, second);
                        setTime(localTime);
                    }
                }
                else{
                    String yearString = strValue.substring(0, 3);
                    String monthString = strValue.substring(4, 5);
                    String dayString = strValue.substring(6,7);

                    year = Integer.parseInt(yearString);
                    month = Integer.parseInt(monthString);
                    day = Integer.parseInt(dayString);
                    LocalDate localDate = LocalDate.of(year, month, day);
                    setDate(localDate);
                }
            }
            setLocalDateTime(date, time);
        }
        else{
            String yearString = input.substring(0, 3);
            String monthString = input.substring(4, 5);
            String dayString = input.substring(6,7);

            System.out.println(yearString +" " +monthString+" "+dayString);

            year = Integer.parseInt(yearString);
            month = Integer.parseInt(monthString);
            day = Integer.parseInt(dayString);
            LocalDate localDate = LocalDate.of(year, month, day);
            setDate(localDate);
        }
    }
}
