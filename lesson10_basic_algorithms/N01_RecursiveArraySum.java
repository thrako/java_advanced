package lesson10_basic_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class N01_RecursiveArraySum {

    private static int[] numbers;

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        readNumbers(scanner);

        System.out.println(sum(0, 0));
    }

    private static int sum (int idx, int sum) {

        if (idx < numbers.length) {
            sum = numbers[idx] + sum(idx + 1, sum);
        }

        return sum;
    }

    private static void readNumbers (Scanner scanner) {
        numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
