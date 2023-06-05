package ait.arrays;

import ait.arrays.utils.ArraysTools;

public class ArraysAppl {
    public static void main(String[] args) {
        int[] arr = new int[10];
        ArraysTools.fillArray(arr, 10, 99);
        ArraysTools.printArray(arr);
        //ArraysTools.bubbling(arr);
        ArraysTools.bubbleSort1(arr);
        ArraysTools.printArray(arr);
        int index = ArraysTools.binarySearch(arr, 42);
        System.out.println("Index = " + index);
    }
}