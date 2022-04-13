package searching_sorting_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author helena81
 * @version 1.0
 * @since 13.04.22
 */
public class SumOfCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(7).split(", ");

        int[] coins = new int[elements.length];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(reader.readLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    //Greedy algorithm implementation
    private static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
        int index = coins.length - 1;

        while (targetSum > 0) {
            int coinsToTake = targetSum / coins[index];

            if (coinsToTake != 0) {
                usedCoins.put(coins[index], coinsToTake);
            }
            targetSum %= coins[index];
            index--;
        }


        return usedCoins;
    }
}
