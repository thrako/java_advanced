package lesson10_basic_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class N04_SetCover {

    public static void main (String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();

        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];

            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }

            sets.add(set);
        }

        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));

        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("[\\[\\]]", ""));
            sb.append(" }").append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    public static List<int[]> chooseSets (List<int[]> sets, int[] universe) {

        List<int[]> setsPool = new ArrayList<>(sets);
        List<int[]> setsTaken = new ArrayList<>();
        List<Integer> missingNumbers = Arrays.stream(universe)
                .boxed()
                .collect(Collectors.toList());

        Comparator<int[]> byMissingNumbersCount = (set1, set2) -> {

            int count1 = 0;
            int count2 = 0;

            for (int number : set1) {
                if (missingNumbers.contains(number)) count1++;
            }

            for (int number : set2) {
                if (missingNumbers.contains(number)) count2++;
            }

            return Integer.compare(count1, count2);
        };

        while (missingNumbers.size() > 0 && setsPool.size() > 0) {
            int[] setToTake = setsPool.stream()
                    .max(byMissingNumbersCount)
                    .get();
            List<Integer> takenNumbers = Arrays.stream(setToTake)
                    .boxed()
                    .collect(Collectors.toList());
            missingNumbers.removeAll(takenNumbers);
            setsTaken.add(setToTake);
            setsPool.remove(setToTake);
        }

        return setsTaken;
    }

}
