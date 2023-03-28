// 3*. Реализовать алгоритм пирамидальной сортировки (HeapSort).

import java.util.Arrays;
import java.util.Random;

public class Class_03 {
    private static final int sizeOfList = 10;
    private static final int maxValueInArr = 15;

    public static void main(String[] args) {
        int[] rndArray = new int[sizeOfList];
        genArrayRndNumbers(rndArray, maxValueInArr);
        System.out.println("Исходный массив: " + Arrays.toString(rndArray));
        heapSort(rndArray);
        System.out.println("Отсортированный массив: " + Arrays.toString(rndArray));
    }

    public static void genArrayRndNumbers (int[] rndArray, int maxValueInArr) {
        Random rnd = new Random();
        for (int i = 0; i < rndArray.length; i++)
            rndArray[i] = rnd.nextInt(maxValueInArr + 1);
    }

    static void heapMe (int[] rndArray, int length, int i) {
        int leftElement = 2 * i + 1;
        int rightElement = 2 * i + 2;
        int largest = i;

        if (leftElement < length && rndArray[leftElement] > rndArray[largest]) largest = leftElement;
        if (rightElement < length && rndArray[rightElement] > rndArray[largest]) largest = rightElement;

        if (largest != i) {
            int temp = rndArray[i];
            rndArray[i] = rndArray[largest];
            rndArray[largest] = temp;
            heapMe (rndArray, length, largest);
        }
    }

    public static void heapSort (int[] rndArray) {
        if (rndArray.length == 0) return;
        int length = rndArray.length;
        for (int i = length / 2-1; i >= 0; i--)
            heapMe (rndArray, length, i);

        for (int i = length-1; i >= 0; i--) {
            int temp = rndArray[0];
            rndArray[0] = rndArray[i];
            rndArray[i] = temp;

            heapMe (rndArray, i, 0);
        }
    }}
