/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calender;

/**
 *
 * @author nayan
 */
public class Calender {
    public static void main(String[] args) {
        if (args.length != 2) {
            //System.out.println("Usage: java Calendar <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        printCalendar(month, year);
    }

    public static void printCalendar(int month, int year) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, 1);

        int numDaysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        int firstDayOfMonth = cal.get(java.util.Calendar.DAY_OF_WEEK);

        System.out.println(getMonthName(month) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int[][] calendar = new int[6][7];
        int row = 0;
        int col = firstDayOfMonth - 1;

        for (int day = 1; day <= numDaysInMonth; day++) {
            calendar[row][col] = day;
            col++;

            if (col == 7) {
                col = 0;
                row++;
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (calendar[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.printf("%2d ", calendar[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static String getMonthName(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "";
        }
    }
}

