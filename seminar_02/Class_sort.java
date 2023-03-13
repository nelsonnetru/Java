import java.util.Arrays;
import java.util.Random;

public class Class_sort
{
    public static void main(String[] args) {

        Random rnd = new Random();
        int[] arrForSort = new int[10];
        fillRandomArray (55, arrForSort);

        System.out.print("Array:\n"+Arrays.toString(arrForSort));
        sortArrayBubble1(arrForSort);

    }
    
    public static void sortArrayBubble1 (int[] arrForSort) {
        for (int i=0; i<arrForSort.length; i++) { // сортировка массива методом пузырька
            for (int j=0; j<(arrForSort.length-i-1); j++) {
                if (arrForSort[j] > arrForSort[j+1]) {
                    System.out.print(" bubble: " + arrForSort[j]);
                    int tmp = arrForSort[j];
                    arrForSort[j] = arrForSort[j+1];
                    arrForSort[j+1] = tmp;
                }
            }
            System.out.print("\n"+Arrays.toString(arrForSort));
        }    
    }

    public static void fillRandomArray (int maxValue, int[] arrForFill) {
        int length = arrForFill.length;
        Random rnd = new Random();

        for (int i = 0; i < length; i++ )
            arrForFill[i] = rnd.nextInt(maxValue + 1);
    }
}
