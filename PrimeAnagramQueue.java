/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primeanagramqueue;
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

class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class PrimeAnagramQueue {
    public static void main(String[] args) {
        Queue<Integer> anagramQueue = findAndStorePrimeAnagramsInRange(0, 1000);
        printAnagramsFromQueue(anagramQueue);
    }

    public static Queue<Integer> findAndStorePrimeAnagramsInRange(int start, int end) {
        Queue<Integer> anagramQueue = new Queue<>();
        for (int num = start; num <= end; num++) {
            if (isPrime(num) && isAnagram(start, num)) {
                anagramQueue.enqueue(num);
            }
        }
        return anagramQueue;
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

    public static void printAnagramsFromQueue(Queue<Integer> queue) {
        System.out.println("Prime Anagrams from the Queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }
}

