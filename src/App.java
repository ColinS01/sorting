import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Sort.Sort;

public class App {

    public static void print_array(int[] array) {
        for (int a: array) {
            System.out.print(a + " ");
        }

        System.out.println();
    }

    public static int[] createRandomArray(int arrayLength){
        int array [] = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++){
            array [i] = random.nextInt(100);
        }

        return array;
    }

    public static boolean isSorted(int[] array){
        for (int i = 0; i < array.length - 1; i ++){
            if (array[i] > array [i + 1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        long startTime;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("What is the desired length of your array: ");
            int arrayLength = scanner.nextInt();
            startTime = System.currentTimeMillis();
            int array [] = createRandomArray(arrayLength);
            System.out.printf("Time to create an integer array of length %d is %.2f s ", arrayLength, (System.currentTimeMillis()-startTime)/1000.0);
            int sortedArray [] = Sort.merge_sort(array);
            System.out.printf("\nMerge sort integer array of length %d is %.2f s ", arrayLength, (System.currentTimeMillis()-startTime)/1000.0);
            System.out.println("\nThe sorted array is in the correct order: " + isSorted(sortedArray));
            startTime = System.currentTimeMillis();
            Sort.bubble_sort(array);
            System.out.printf("Bubble sort an integer array of length %d is %.2f s ", arrayLength, (System.currentTimeMillis()-startTime)/1000.0);
            System.out.println("\nMerge sort and Bubble sort generate the same array: " + Arrays.equals(sortedArray, array));
            System.out.println("\n" + "Continue? Enter Y or N: ");
            String yesNo = scanner.next();
            if(yesNo.toUpperCase().equals("N")) break;
        }

        scanner.close();
        System.out.println("Goodbye");
        
    }
}
