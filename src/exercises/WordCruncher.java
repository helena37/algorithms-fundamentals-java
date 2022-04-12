package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author helena81
 * @version 1.0
 * @since 10.04.22
 */
public class WordCruncher {
    public static List<String> words;
    public static List<String> combined = new ArrayList<>();
    public static String target;
    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurrences = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        words = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        target = reader.readLine();

        words.removeIf(next -> !target.contains(next));

        for (String word : words) {
            occurrences.putIfAbsent(word, 0);
            occurrences.put(word, occurrences.get(word) + 1);

            int index = target.indexOf(word);

            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());

                table.get(index).add(word);
                index = target.indexOf(word, index + 1);
            }
        }

        permute(0);
    }

    private static void permute(int index) {
        if (index == target.length()) {
            printOutput();
        } else if (table.containsKey(index)){
            List<String> strings = table.get(index);
            for (String str : strings) {
                if (occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    combined.add(str);
                    permute(index + str.length());
                    combined.remove(combined.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }
            }
        }
    }

    private static void printOutput() {
        String actual = String.join("", combined);

        if (actual.contains(target)) {
            for (String s : combined) {
                System.out.print(s + " ");
            }

            System.out.println();
        }
    }
}

/* Testcases

text, me, so, do, m, ran
somerandomtext

this, th, is, Word, cruncher, cr, h, unch, c, r, un, ch, er
Wordcruncher

 */