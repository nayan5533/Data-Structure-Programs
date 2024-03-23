/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankingcashcounter;
import java.util.*;
/**
 *
 * @author nayan
 */

class Queue<T> {
    private List<T> items;

    public Queue() {
        items = new ArrayList<>();
    }

    public void enqueue(T item) {
        items.add(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return items.remove(0);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}

public class BankingCashCounter {
    private static int cashBalance = 10000; 
    public static void deposit(int amount) {
        cashBalance += amount;
        System.out.println("Deposited $" + amount + ". Current balance: $" + cashBalance);
    }

    public static void withdraw(int amount) {
        if (amount > cashBalance) {
            System.out.println("Insufficient funds. Current balance: $" + cashBalance);
        } else {
            cashBalance -= amount;
            System.out.println("Withdrawn $" + amount + ". Current balance: $" + cashBalance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new Queue<>();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add person to queue");
            System.out.println("2. Process next person");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.println("Enter person name:");
                    String person = scanner.nextLine();
                    queue.enqueue(person);
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        String nextPerson = queue.dequeue();
                        System.out.println("Processing " + nextPerson);
                        System.out.println("Choose transaction type:");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        int transactionType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        switch (transactionType) {
                            case 1:
                                System.out.println("Enter deposit amount:");
                                int depositAmount = scanner.nextInt();
                                deposit(depositAmount);
                                break;
                            case 2:
                                System.out.println("Enter withdrawal amount:");
                                int withdrawAmount = scanner.nextInt();
                                withdraw(withdrawAmount);
                                break;
                            default:
                                System.out.println("Invalid transaction type");
                        }
                    } else {
                        System.out.println("No person in queue");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
