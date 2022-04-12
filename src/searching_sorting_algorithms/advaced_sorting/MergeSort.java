package searching_sorting_algorithms.advaced_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author helena81
 * @version 1.0
 * @since 12.04.22
 */
public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int num : arr) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        int left = mid;
        int right = mid + 1;

        mergeSort(arr, start, left);
        mergeSort(arr, right, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        if (mid < 0 || mid >= arr.length || arr[mid] < arr[mid + 1]) {
            return;
        }

        int left = start;
        int right = mid + 1;

        int[] helper = new int[arr.length];

        for (int i = start; i <= end; i++) {
            helper[i] = arr[i];
        }

        for (int i = start; i <= end; i++) {
            if (left > mid) {
                arr[i] = helper[right++];
            } else if (right > end) {
                arr[i] = helper[left++];
            } else if (helper[left] <= helper[right]) {
                arr[i] = helper[left++];
            } else if (helper[right] <= helper[left]){
                arr[i] = helper[right++];
            }
        }
    }
}

//55 24 1 12 76 32 12 11 5 44 44
//1 45 87 54 22 1 78 65 33 1 87 100