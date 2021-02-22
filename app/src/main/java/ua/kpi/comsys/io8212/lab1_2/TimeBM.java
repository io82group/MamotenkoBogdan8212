package ua.kpi.comsys.io8212.lab1_2;

import java.util.Calendar;
public class TimeBM {
    private int minutes;
    private int hours;
    private int seconds;

    public TimeBM(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public TimeBM(int hours, int minutes, int seconds){
        if (hours < 0 || hours > 23)
            throw new IllegalArgumentException("You input wrong hour`s value");
        else if (minutes < 0 || minutes > 59)
            throw new IllegalArgumentException("You input wrong minute's value");
        else if (seconds < 0 || seconds > 59)
            throw new IllegalArgumentException("You input wrong second's value");
        else{
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }}

    public TimeBM(Calendar calendar){
        this.hours = calendar.get(Calendar.HOUR);
        this.minutes = calendar.get(Calendar.MINUTE);
        this.seconds = calendar.get(Calendar.SECOND);
    }

    public String getTime(){
        if (hours < 12)
            return String.format("%02d:%02d:%02d", getHours(),getMinutes(),getSeconds()) + " AM";
        else
            return String.format("%02d:%02d:%02d", getHours() - 12,getMinutes(),getSeconds()) + " PM";
    }

    public int getSeconds(){
        return this.seconds;
    }

    public int getHours(){
        return this.hours;
    }

    public int getMinutes(){
        return this.minutes;
    }
    public TimeBM plus2Time(TimeBM obj) {
        int totalSecs = (this.hours + obj.getHours()) * 3600 + (this.minutes + obj.getMinutes()) * 60 + this.seconds + obj.getSeconds();
        int hours = totalSecs / 60 / 60 % 24;
        int minutes = totalSecs / 60 % 60;
        int seconds = totalSecs % 60;
        return new TimeBM(hours,minutes,seconds);
    }


    public static TimeBM plus2Time(TimeBM obj1, TimeBM obj2) {
        int totalSecs = (obj1.getHours() + obj2.getHours()) * 3600 + (obj1.getMinutes() + obj2.getMinutes()) * 60 + obj1.getSeconds() + obj2.getSeconds();
        int hours = totalSecs / 60 / 60 % 24;
        int minutes = totalSecs / 60 % 60;
        int seconds = totalSecs % 60;
        return new TimeBM(hours,minutes,seconds);
    }



    public TimeBM minus2Time(TimeBM obj) {
        int totalSecs = (this.hours - obj.getHours()) * 3600 + (this.minutes - obj.getMinutes()) * 60 + this.seconds - obj.getSeconds();
        if (totalSecs < 0){
            int newTotalSecs = 24 * 3600 + totalSecs;
            int hours = newTotalSecs / 60 / 60 % 24;
            int minutes = newTotalSecs / 60 % 60;
            int seconds = newTotalSecs % 60;
            return new TimeBM(hours, minutes, seconds);
        }
        else{
            int hours = totalSecs / 60 / 60 % 24;
            int minutes = totalSecs / 60 % 60;
            int seconds = totalSecs % 60;
            return new TimeBM(hours, minutes, seconds);
        }
    }

    public static TimeBM minus2Time(TimeBM obj1, TimeBM obj2) {
        int totalSecs = (obj1.getHours() - obj2.getHours()) * 3600 + (obj1.getMinutes() - obj2.getMinutes()) * 60 + obj1.getSeconds() - obj2.getSeconds();
        if (totalSecs < 0){
            int newTotalSecs = 24 * 3600 + totalSecs;
            int hours = newTotalSecs / 60 / 60 % 24;
            int minutes = newTotalSecs / 60 % 60;
            int seconds = newTotalSecs % 60;
            return new TimeBM(hours, minutes, seconds);
        }
        else{
            int hours = totalSecs / 60 / 60 % 24;
            int minutes = totalSecs / 60 % 60;
            int seconds = totalSecs % 60;
            return new TimeBM(hours, minutes, seconds);
        }
    }
}
