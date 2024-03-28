/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.palindromechecker;
import java.util.*;
/**
 *
 * @author nayan
 */


class Deque<T> {
    private LinkedList<T> items;

    public Deque() {
        items = new LinkedList<>();
    }

    public void addFront(T item) {
        items.addFirst(item);
    }

    public void addRear(T item) {
        items.addLast(item);
    }

    public T removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return items.removeFirst();
    }

    public T removeRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return items.removeLast();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new Deque<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            deque.addRear(ch);
        }
        while (deque.size() > 1) {
            char front = deque.removeFront();
            char rear = deque.removeRear();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        boolean palindrome = isPalindrome(input);
        if (palindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
