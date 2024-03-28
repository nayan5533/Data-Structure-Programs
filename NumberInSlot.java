/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberinslot;
import java.util.*;
/**
 *
 * @author nayan
 */

class Slot {
    private Map<Integer, LinkedList<Integer>> slotMap;

    public Slot() {
        slotMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            slotMap.put(i, new LinkedList<>());
        }
    }

    public void addToSlot(int num) {
        int slotNumber = num % 11;
        LinkedList<Integer> chain = slotMap.get(slotNumber);
        chain.add(num);
    }

    public boolean search(int num) {
        int slotNumber = num % 11;
        LinkedList<Integer> chain = slotMap.get(slotNumber);
        if (chain.contains(num)) {
            chain.remove((Integer) num);
            return true;
        }
        return false;
    }
}

public class NumberInSlot {
    public static void main(String[] args) {
        Slot slot = new Slot();
        int[] numbers = {77, 26, 93, 17, 44, 55, 20, 31, 54};
        for (int num : numbers) {
            slot.addToSlot(num);
        }
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int searchNum = scanner.nextInt();
        boolean found = slot.search(searchNum);
        if (found) {
            System.out.println("Number found and removed from slot.");
        } else {
            System.out.println("Number not found in the slot.");
        }
        
       
    }
}
