import java.util.Arrays;
import java.util.Random;

public class Class_2
{
    public static void main(String[] args) {
        // Подсчет максимального количества единиц, которые идут подряд в массиве из 0 и 1

        Random rnd = new Random();
        int length = 15;
        int[] arr = new int[length];
        int count = 0; 
        int maxOnes = 0;

        for (int i = 0; i < length; i++ ) {
            arr[i] = rnd.nextInt(2);
        }

        for (int item: arr) {
            if (item == 1) {
                count++;
                if (count > maxOnes) maxOnes = count;
            }
            else count = 0;
        }

        System.out.printf("Элементов в массиве: %d\n", length);
        System.out.println(Arrays.toString(arr));
        System.out.println("Максимальное кол-во <1>, идущих подряд: " + maxOnes);

    }
}
