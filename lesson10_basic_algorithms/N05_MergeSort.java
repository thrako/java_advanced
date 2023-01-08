package lesson10_basic_algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N05_MergeSort {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sortedArr = mergeSort(inputArr);

        String result = Arrays.stream(sortedArr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    private static int[] mergeSort (int[] partition) {

        if (partition.length == 1) return partition;

        int end = partition.length - 1;
        int mid = end / 2;

        int[] leftPartition = new int[mid + 1];
        System.arraycopy(partition, 0, leftPartition, 0, mid + 1);
        leftPartition = mergeSort(leftPartition);

        int[] rightPartition = new int[end - mid];
        System.arraycopy(partition, mid + 1, rightPartition, 0, end - mid);
        rightPartition = mergeSort(rightPartition);

        int[] mergedArr = new int[leftPartition.length + rightPartition.length];
        int leftIdx = 0;
        int rightIdx = 0;
        int mergedIdx = 0;

        while (mergedIdx < mergedArr.length) {

            if (leftIdx >= leftPartition.length) {
                while (rightIdx < rightPartition.length) {
                    mergedArr[mergedIdx++] = rightPartition[rightIdx++];
                }

            } else if (rightIdx >= rightPartition.length) {
                while (leftIdx < leftPartition.length) {
                    mergedArr[mergedIdx++] = leftPartition[leftIdx++];
                }

            } else if (leftPartition[leftIdx] <= rightPartition[rightIdx]) {
                mergedArr[mergedIdx++] = leftPartition[leftIdx++];

            } else {
                mergedArr[mergedIdx++] = rightPartition[rightIdx++];
            }

        }

        return mergedArr;
    }

}
