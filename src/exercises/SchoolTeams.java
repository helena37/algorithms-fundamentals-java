package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author helena81
 * @version 1.0
 * @since 10.04.22
 */
public class SchoolTeams {
    public static String[] girls;
    public static String[] boys;
    public static String[] girlsCombinations = new String[3];
    public static String[] boysCombinations = new String[2];

    public static List<String> allGirls = new ArrayList<>();
    public static List<String> allBoys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        girls = reader.readLine().split(", ");
        boys = reader.readLine().split(", ");

        combineGirls(0, 0);
        combineBoys(0, 0);
        print(allGirls, allBoys);

    }

    private static void combineBoys(int index, int start) {
        if (index == boysCombinations.length) {
            allBoys.add(String.join(", ", boysCombinations));
        } else {
            for (int i = start; i < boys.length; i++) {
                boysCombinations[index] = boys[i];
                combineBoys(index + 1, i + 1);
            }
        }
    }

    private static void combineGirls(int index, int start) {
        if (index == girlsCombinations.length) {
            allGirls.add(String.join(", ", girlsCombinations));
        } else {
            for (int i = start; i < girls.length; i++) {
                girlsCombinations[index] = girls[i];
                combineGirls(index + 1, i + 1);
            }
        }
    }

    private static void print(List<String> girls, List<String> boys) {
        for (String girl : girls) {
            for (String boy : boys) {
                System.out.println(girl + ", " + boy);
            }
        }
    }
}

/*
Lisa, Yoana, Marta, Rachel
George, Garry, Bob
 */
