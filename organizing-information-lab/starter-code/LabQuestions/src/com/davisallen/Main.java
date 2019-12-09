package com.davisallen;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Nothing in the main method will be tested
        System.out.println(Arrays.toString(findLargestAndSmallest(new int[] {3,6,2,9,7})));
        System.out.println(Arrays.toString(removeDuplicatesFromArray(new int[] {1,4,3,2,1})));
        System.out.println(sumOfTwoLargest(new int[] {1,4,3,2,1}));

        int[] arr1 = {1,2,3,7,0,0,0};
        int[] arr2 = {4,5,6,};
        int[] arrFinal = mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(arrFinal));
    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     *
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the largest and smallest.
     *
     * You MAY ONLY use arrays, not other collections types (ie Lists).
     *
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int[] array){
        int smallest = array[0];
        int largest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) smallest = array[i];
            if (array[i] > largest) largest = array[i];
        }
        return new int[] {smallest, largest};
    }


    /**
     * Question 2: Remove duplicates from an array
     *
     * You are given an array of ints that might have duplicates. You must remove any duplicates from the array,
     * and return an array that doesn't contain duplicates. The order of the elements in the original array
     * does not need to be kept the same.
     *
     * You MAY use any collections types you wish, but the method must return an array.
     *
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param array An array of ints that may or may not include duplicates
     * @return An array of ints that doesn't contain duplicates.
     */
    public static Object[] removeDuplicatesFromArray(int[] array){
        HashMap<Integer, Integer> counts = new HashMap<>();
        List<Integer> noDups = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!counts.containsKey(array[i])) {
                noDups.add(array[i]);
                counts.put(array[i], 1);
            }
        }
        return noDups.toArray();
    }

    /**
     * Given an array of integers, return the sum of the two largest values.
     *
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     *
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers of any size.
     * @return Sum of the two largest values
     */
    public static int sumOfTwoLargest(int[] array){
        if (array.length >= 2) {
            List<Integer> largest = new ArrayList<>();
            largest.add(array[0]);
            largest.add((array[1] > largest.get(0) ? 1 : 0), array[1]);
            for (int i = 2; i < array.length; i++) {
                int j = -1;
                if (array[i] > largest.get(0)) j = 0;
                if (array[i] > largest.get(1)) j = 1;
                if (j >= 0) largest.set(j, array[i]);
            }
            return largest.get(0) + largest.get(1);
        } else {
            return (array.length > 0) ? array[0] : 0;
        }
    }

    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     *
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     *
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     *
     * For example:
     *      array1 = [1,4,7,9,0,0,0]
     *      array2 = [1,5,11]
     *      returned array = [1,1,4,5,7,9,11]
     *
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */
    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        int len1 = array1.length;
        int len2 = array2.length;
        int[] merged = new int[len1];
        int j = 0;
        int k = 0;
        for (int i = 0; i < len1; i++) {
            if (array1[j] > 0 && j < len1) {
                if (k >= len2 || array1[j] < array2[k]) {
                    merged[i] = array1[j];
                    j++;
                }
            } else if (k < len2) {
                merged[i] = array2[k];
                k++;
            }
        }
        return merged;
//        int len = array1.length;
//        int[] array = new int[len];
//        int validLength = 0;
//        for (int i = 0; i < array1.length; i++) {
//            if (array1[i] == 0) {
//                validLength = i;
//                break;
//            }
//        }
//        int i = 0;
//        int j = 0;
//        for (int k = 0; k < len; k++) {
//            if (i >= validLength && j >= array2.length) {
//                break;
//            } else if (i >= validLength && j < array2.length) {
//                array[k] = array2[j];
//                j++;
//            } else if (i < validLength && j >= array2.length) {
//                array[k] = array1[i];
//            } else {
//                if (array1[i] < array2[j]) {
//                    array[k] = array1[i];
//                    i++;
//                } else {
//                    array[k] = array2[j];
//                    j++;
//                }
//            }
//        }
//        return array;
    }
}
