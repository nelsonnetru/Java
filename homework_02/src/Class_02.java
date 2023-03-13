// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.Random;
import java.util.logging.*;
import java.io.IOException;

public class Class_02 {
    public static int maxValueForRandom = 10;

    public static void main(String[] args) {
        int[] arrayForSort = new int[10];
        maxValueForRandom = 55;
        fillRandomArray(maxValueForRandom, arrayForSort);
        System.out.print("Start array:\n" + Arrays.toString(arrayForSort) + "\n");

        try {
            sortArrayBubble(arrayForSort);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void sortArrayBubble(int[] arr) throws IOException {
        Logger logger = Logger.getLogger(Class_02.class.getName());
        logger.setLevel(Level.INFO);

        FileHandler fHandler = new FileHandler ("log_sort.txt");
        logger.addHandler(fHandler);

        SimpleFormatter sFormat = new SimpleFormatter();
        fHandler.setFormatter(sFormat);

        logger.info(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            logger.info(Arrays.toString(arr));
        }
    }

    public static void fillRandomArray(int maxValue, int[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = rnd.nextInt(maxValue + 1);
    }
}
