/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unorderedlistmain;
import java.io.*;
import java.util.*;

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

class UnorderedList<T> {
    private Node<T> head;

    public UnorderedList() {
        head = null;
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }

    public boolean remove(T item) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(item)) {
            head = head.next;
            return true;
        }
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null && !current.data.equals(item)) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
            return true;
        }
        return false;
    }

    public boolean search(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void append(T item) {
        add(item); 
    }

    public int index(T item) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1; 
    }

    public void insert(int pos, T item) {
        if (pos == 0) {
            add(item);
            return;
        }
        Node<T> newNode = new Node<>(item);
        Node<T> current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            return; 
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public T pop() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data;
        if (head.next == null) {
            data = head.data;
            head = null;
        } else {
            Node<T> current = head;
            Node<T> prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            data = current.data;
            prev.next = null;
        }
        return data;
    }

    public T pop(int pos) {
        if (pos == 0) {
            return pop();
        }
        Node<T> current = head;
        Node<T> prev = null;
        for (int i = 0; i < pos && current != null; i++) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        T data = current.data;
        prev.next = current.next;
        return data;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            Node<T> current = head;
            while (current != null) {
                writer.println(current.data);
                current = current.next;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class UnorderedListMain {
    public static void main(String[] args) {
        UnorderedList<String> wordList = new UnorderedList<>();
        String filename = "word.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordList.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to search in the list: ");
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("exit")) {
            if (wordList.search(input)) {
                System.out.println("Word found. Removing from the list...");
                wordList.remove(input);
            } else {
                System.out.println("Word not found. Adding to the list...");
                wordList.add(input);
            }
            System.out.println("Updated List:");
            wordList.display();
            System.out.println("Enter a word to search in the list: ");
            input = scanner.nextLine();
        }

        System.out.println("Saving list to file...");
        wordList.saveToFile(filename);
        System.out.println("List saved to " + filename);
    }
}
