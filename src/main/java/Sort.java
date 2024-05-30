//import jdk.internal.org.jline.terminal.TerminalBuilder;

import java.util.Arrays;

/**
 * This class implements multiple sort algorithms.
 *
 * @author (your name)
 * @version (CSSSKL 143)
 */

public class Sort {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        int[] bubbleArray = new int[SIZE];
        int[] selectionArray = new int[SIZE];
        int[] insertionArray = new int[SIZE];

        int[] optimizedSelectionArray = new int[SIZE];
        String[] stringArray = {"Arjun", "Lebron", "Doncic"};


        for (int i = 0; i < SIZE; i++) {
            bubbleArray[i] = (int) (Math.random() * 52);
            selectionArray[i] = (int) (Math.random() * 52);
            insertionArray[i] = (int) (Math.random() * 52);
        }

        System.out.println("Array before bubble sort:");
        System.out.println(Arrays.toString(bubbleArray));
        bubbleSort(bubbleArray);
        System.out.println("Array after bubble sort:");
        System.out.println(Arrays.toString(bubbleArray));
        System.out.println();

        System.out.println("Array before selection sort:");
        System.out.println(Arrays.toString(selectionArray));
        selectionSort(selectionArray);
        System.out.println("Array after selection sort:");
        System.out.println(Arrays.toString(selectionArray));
        System.out.println();

        optimizedSelectionSort(selectionArray);
        System.out.println("Array after optimized selection sort:");
        System.out.println(Arrays.toString(selectionArray));
        System.out.println();

        System.out.println("Array before insertion sort:");
        System.out.println(Arrays.toString(insertionArray));
        insertionSort(insertionArray);
        System.out.println("Array after insertion sort:");
        System.out.println(Arrays.toString(insertionArray));

        // TODO Test your string sort here
        System.out.println("String array before bubble sort.");
        System.out.println(Arrays.toString(stringArray));
        bubbleSort(stringArray);
        System.out.println("String array after bubble sort:");
        System.out.println(Arrays.toString(stringArray));
    }

    /**
     *
     * @param numbers
     */
    public static void bubbleSort(int[] numbers) {
        // Implement your sort, call a helper swap method
        for (int i = 0; i < numbers.length - 1; i++) {
            for(int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j , j + 1);
                }
            }
        }
    }

    public static void bubbleSort(String[] string) {
        for (int i = 0; i < string.length - 1; i++) {
            for (int j = 0; j < string.length - 1 - i; j++) {
                if (string[j].compareTo(string[j + 1]) > 0) {
                    swap(string, j, j + 1);
                }
            }
        }
    }

    public static void swap(String[] string, int indexA, int indexB) {
        String temp = string[indexA];
        string[indexA] = string[indexB];
        string[indexB] = temp;
    }

    /**
     *
     *
     * @param numbers
     * @param indexA
     * @param indexB
     */
    public static void swap(int[] numbers, int indexA, int indexB) {
        // swap the elements at indexA and indexB
        int temp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }

    // selection sort for ints
    public static void selectionSort(int[] numbers) {
        // Implement your sort, call swapSelection(int[] intList, int i, int nextMin)
        for (int i = 0; i < numbers.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            swap(numbers,i,smallestIndex);
        }
    }

    //My estimation for this Big O is O(n) instead of the usual o(n^2) for selection sort
    public static void optimizedSelectionSort(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int minIndex = findSmallest(numbers, left, right + 1);
            int maxIndex = findLargest(numbers, left, right + 1);

            swap(numbers, left, minIndex);

            if (maxIndex == left) {
                maxIndex = minIndex;
            }

            swap(numbers, right, maxIndex);

            left++;
            right--;
        }
    }

    public static int findSmallest(int[] arr, int begin, int end) {
        int minIndex = begin;
        int minValue = arr[begin];
        for (int i = begin + 1; i < end; i++) {
            if (arr[i] < minValue) {
                minIndex = i;
                minValue = arr[i];
            }
        }
        return minIndex;
    }

    public static int findLargest(int[] arr, int begin, int end) {
        int maxIndex = begin;
        for (int i = begin + 1; i < end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     *
     * @param numbers
     */
    public static void insertionSort(int[] numbers) {
        // Implement your insertion sort
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int hole = i - 1;
            while (hole >= 0 && numbers[hole] > key) {
                numbers[hole + 1] = numbers[hole];
                hole--;
            }
            numbers[hole + 1] = key;
        }
    }
}
