package Sort;

import java.util.Arrays;

public class Sort {
    public static void bubble_sort(int[]array) {
        for(int i = array.length - 1; i > 0; i --){
            for(int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public static int[] merge(int[]array1, int[]array2){
        int [] merged_array = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (j < array1.length && k < array2.length){
            if (array1[j] <= array2[k]){
                merged_array[i++] = array1[j++];
            }else{
                merged_array[i++] = array2[k++];
            }
        }
        while (j < array1.length){
            merged_array[i++] = array1[j++];
        }
        while (k < array2.length){
            merged_array[i++] = array2[k++];
        }
        return merged_array;
    }


    public static int[] merge_sort(int[]array){
        if (array.length <= 1) {
            return array;

        } else{
            int arrayLength1 = array.length / 2;
            int[]array1 = Arrays.copyOfRange(array, 0, arrayLength1);
            int[]array2 = Arrays.copyOfRange(array, arrayLength1, array.length);
            array1 = merge_sort(array1);
            array2 = merge_sort(array2);
            int[] merged_array = merge(array1, array2);
            return merged_array;
        }
    }
}
