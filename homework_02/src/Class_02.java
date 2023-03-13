// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Class_02 {
    public static int maxValueForRandom = 10;

    public static void main(String[] args) {
        int[] arrayForSort = new int[10];
        maxValueForRandom = 55;
        fillRandomArray(maxValueForRandom, arrayForSort);
        System.out.print("Start array:\n" + Arrays.toString(arrayForSort) + "\n");
        sortArrayBubble(arrayForSort);


        Logger logger = new Logger.getLogger();
        logger.setLevel(Level.INFO););
    }

    public static void sortArrayBubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void fillRandomArray(int maxValue, int[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = rnd.nextInt(maxValue + 1);
    }
}
