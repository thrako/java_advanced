package lesson10_basic_algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N06_QuickSort {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sortedArr = quickSort(inputArr.clone(), 0, inputArr.length - 1);

        String result = Arrays.stream(sortedArr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    public static int[] quickSort (int[] arr, int start, int end) {

        if (start >= end) {
            return arr;
        }

        int storeIdx = partition(arr, start, end);

        if (storeIdx - start < end - storeIdx) {
            quickSort(arr, start, storeIdx);
            quickSort(arr, storeIdx + 1, end);
        } else {
            quickSort(arr, storeIdx + 1, end);
            quickSort(arr, start, storeIdx);
        }

        return arr;
    }

    private static int partition (int[] arr, int start, int end) {

        int pivot = arr[start];
        int leftIdx = start - 1;
        int rightIdx = end + 1;

        while (true) {
            //noinspection StatementWithEmptyBody
            while (++leftIdx < end && arr[leftIdx] < pivot) ;
            //noinspection StatementWithEmptyBody
            while (--rightIdx > start && arr[rightIdx] > pivot) ;

            if (leftIdx < rightIdx) {
                int tmp = arr[leftIdx];
                arr[leftIdx] = arr[rightIdx];
                arr[rightIdx] = tmp;
            } else {
                return rightIdx;
            }
        }
    }

}
