/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calendar2;

/**
 *
 * @author nayan
 */
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

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
    private Stack<WeekDay> stack1;
    private Stack<WeekDay> stack2;

    public Week() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void addDay(WeekDay day) {
        stack1.push(day);
    }

    public void moveStack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public void moveStack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void displayCalendar() {
        moveStack1ToStack2();

        System.out.println("Day\tDate");

        while (!stack2.isEmpty()) {
            WeekDay day = stack2.peek();
            System.out.println(day.getDay() + "\t" + (day.getDate().equals("") ? " " : day.getDate()));
            stack1.push(stack2.pop());
        }

        moveStack2ToStack1();
    }
}

public class Calendar2 {
    public static void main(String[] args) {
        Week week = new Week();

        week.addDay(new WeekDay("Sun", "1"));
        week.addDay(new WeekDay("Mon", "2"));
        week.addDay(new WeekDay("Tue", "3"));
        week.addDay(new WeekDay("Wed", "4"));
        week.addDay(new WeekDay("Thu", ""));
        week.addDay(new WeekDay("Fri", "6"));
        week.addDay(new WeekDay("Sat", "7"));

        week.displayCalendar();
    }
}

