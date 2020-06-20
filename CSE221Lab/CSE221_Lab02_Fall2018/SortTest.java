/*
 * Shoaib Ahmed Dipu
 * CSE221 Lab 02
 * Theory Section : 03
 * Lab Section : 06
 */

import java.util.Arrays;

public class SortTest{
    
    public static void main(String [] args){
        
        MyArray mA = new MyArray();
        
        // Insertion Sort
        
        int a1[] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        
        int insertionSortA [] = mA.insertionSort(a1, a1.length);
        System.out.println(mA.toString(insertionSortA));
        System.out.println(System.currentTimeMillis());
        
        int a2[] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        
        Arrays.sort(a2);
        System.out.println(mA.toString(a2));
        System.out.println(System.currentTimeMillis());
        
        
        // Merge Sort 
        
        int b1[] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        
        int mergerSortA [] = mA.mergeSort(b1);
        System.out.println(mA.toString(mergerSortA));
        System.out.println(System.currentTimeMillis());
        
        int b2[] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        Arrays.sort(b2);
        System.out.println(mA.toString(b2));
        System.out.println(System.currentTimeMillis());
        
        
        // Quick Sort
        
        int c1[] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        
        int quickSortA [] = mA.quickSort(c1, 0, c1.length-1);
        System.out.println(mA.toString(quickSortA));
        System.out.println(System.currentTimeMillis());
        
        int c2[] = {3, 5 , 10, 23, 25, 8, 7, 9, 50, 47};
        Arrays.sort(c2);
        System.out.println(mA.toString(c2));
        System.out.println(System.currentTimeMillis());
        
    }
}
