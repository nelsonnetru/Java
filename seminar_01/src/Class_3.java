import java.util.Arrays;
import java.util.Random;

public class Class_3
{
    public static void main(String[] args) {
        // Элементы в массиве, равные указанному перенести в конец массива

        Random rnd = new Random();
        int length = 15;
        int[] arr = new int[length];
        int rangeRnd = 5;
        int count = 0;

        for (int i = 0; i < length; i++ ) {
            arr[i] = rnd.nextInt(rangeRnd);
        }

        int findItem = rnd.nextInt(rangeRnd);
        int lastIndex = length - 1;

        System.out.printf("Искомый элемент: %d\n", findItem);
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < lastIndex; i++) {
            if (arr[i] == findItem) {

                while (arr[lastIndex] == arr[i] && i < lastIndex) {
                    lastIndex--;
                }

                int tmp = arr[i];
                arr[i] = arr[lastIndex];
                arr[lastIndex] = tmp;
                count++;
                lastIndex--;
            }
        }

        System.out.printf("\nЭлементов в массиве: %d\n", length);
        System.out.println(Arrays.toString(arr));
        System.out.printf("Перенесено: %d элементов\n", count);
    }
}
