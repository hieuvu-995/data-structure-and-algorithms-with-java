package com.algorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] rawArr = {7, 15, -1, 20, 35, 4, 55};
        //bubbleSort(rawArr);
        //selectionSort(rawArr);
        mergeSort(rawArr);
        System.out.println(Arrays.toString(rawArr));
    }

    public static void bubbleSort(int[] rawArr) {
        for (int i = 0; i < rawArr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < rawArr.length - i - 1; j++) {
                if (rawArr[j] > rawArr[j + 1]) {
                    int temp = rawArr[j];
                    rawArr[j] = rawArr[j + 1];
                    rawArr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }

    public static void selectionSort(int[] rawArr) {
        for (int i = 0; i < rawArr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < rawArr.length -1; j++) {
                if (rawArr[j] < rawArr[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            if (minValueIndex != i) {
                int tempt = rawArr[i];
                rawArr[i] = rawArr[minValueIndex];
                rawArr[minValueIndex] = tempt;
            }
        }
    }

    public static void insertionSort(int[] rawArr) {
        int valueToInsert, holePosition;
        for (int i = 1; i < rawArr.length; i++) {
            valueToInsert = rawArr[i];
            holePosition = i;

            while (holePosition > 0 && valueToInsert < rawArr[holePosition -1]) {
                rawArr[holePosition] = rawArr[holePosition -1];
                holePosition--;
            }
            if (holePosition != i) {
                rawArr[holePosition] = valueToInsert;
            }
        }
    }

    public static void mergeSort(int[] rawArr) {
        int n = rawArr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = rawArr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = rawArr[i];
        }
        mergeSort(l);
        mergeSort(r);

        merge(rawArr, l, r);
    }

    public static void merge(
            int[] rawArr, int[] l, int[] r) {

        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                rawArr[k] = l[i];
                i++;
            }
            else {
                rawArr[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < l.length) {
            rawArr[k] = l[i];
            k++;
            i++;
        }
        while (j < r.length) {
            rawArr[k] = r[j];
            k++;
            j++;
        }
    }

}