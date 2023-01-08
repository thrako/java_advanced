package lesson10_basic_algorithms;

import java.util.*;

public class N03_SumOfCoins {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        if (usedCoins == null) {
            System.out.println("Error");
            return;
        }

        int totalNumberOfCoins = usedCoins.values().stream()
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.printf("Number of coins to take: %d%n", totalNumberOfCoins);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.printf("%d coin(s) with value %d%n", usedCoin.getValue(), usedCoin.getKey());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) throws IllegalArgumentException {

        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();

        Arrays.sort(coins);

        int remainder = targetSum;
        int idx = coins.length - 1;

        while (idx > -1) {

            int nominal = coins[idx];
            int coinsTaken = remainder / nominal;

            if (coinsTaken > 0) {
                usedCoins.put(nominal, coinsTaken);
            }

            remainder %= nominal;

            if (remainder == 0) {
                break;
            }

            idx--;
        }

        if (remainder == 0) {
            return usedCoins;
        } else {
            return null;
        }
    }
}