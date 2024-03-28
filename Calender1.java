/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calender1;
import java.util.*;
/**
 *
 * @author nayan
 */

class WeekDay {
    private String day;
    private String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}

class Week {
    private Queue<WeekDay> days;

    public Week() {
        days = new LinkedList<>();
    }

    public void addDay(WeekDay day) {
        days.offer(day);
    }

    public Queue<WeekDay> getDays() {
        return days;
    }
}

public class Calender1 {
    public static void main(String[] args) {
        Week week = new Week();
        week.addDay(new WeekDay("Sun", "1"));
        week.addDay(new WeekDay("Mon", "2"));
        week.addDay(new WeekDay("Tue", "3"));
        week.addDay(new WeekDay("Wed", "4"));
        week.addDay(new WeekDay("Thu", ""));
        week.addDay(new WeekDay("Fri", "6"));
        week.addDay(new WeekDay("Sat", "7"));

        displayCalendar(week);
    }

    public static void displayCalendar(Week week) {
        Queue<WeekDay> days = week.getDays();

        System.out.println("Day\tDate");

        for (WeekDay day : days) {
            System.out.println(day.getDay() + "\t" + (day.getDate().equals("") ? " " : day.getDate()));
        }
    }
}

