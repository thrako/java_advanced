package lesson10_basic_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class N07_BinarySearch {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] sortedArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int element = Integer.parseInt(scanner.nextLine());

        int index = binarySearch(element, sortedArr);

        System.out.println(index);
    }

    private static int binarySearch (int element, int[] sortedArr) {

        int start = 0;
        int end = sortedArr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == sortedArr[mid]) {
                return mid;
            } else if (element < sortedArr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
