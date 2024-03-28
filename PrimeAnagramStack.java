/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primeanagramstack;
import java.util.Arrays;

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

public class PrimeAnagramStack {
    public static void main(String[] args) {
        Stack<Integer> anagramStack = findAndStorePrimeAnagramsInRange(0, 1000);
        printAnagramsInReverseOrder(anagramStack);
    }

    public static Stack<Integer> findAndStorePrimeAnagramsInRange(int start, int end) {
        Stack<Integer> anagramStack = new Stack<>();
        for (int num = start; num <= end; num++) {
            if (isPrime(num) && isAnagram(start, num)) {
                anagramStack.push(num);
            }
        }
        return anagramStack;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(int num1, int num2) {
        char[] num1Chars = String.valueOf(num1).toCharArray();
        char[] num2Chars = String.valueOf(num2).toCharArray();
        Arrays.sort(num1Chars);
        Arrays.sort(num2Chars);
        return Arrays.equals(num1Chars, num2Chars);
    }

    public static void printAnagramsInReverseOrder(Stack<Integer> stack) {
        System.out.println("Prime Anagrams in Reverse Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

