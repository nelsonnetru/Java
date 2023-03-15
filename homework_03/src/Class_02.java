// Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.util.Random;
import java.util.ArrayList;

public class Class_02 {

    public static int sizeOfArrayList = 15;
    public static int maxValueInArray = 20;
    public static String separator = ", ";

    public static void main(String[] args) {
        ArrayList<Integer> rndList = new ArrayList<>();
        Class_01.genArrayListRndNumbers (rndList, sizeOfArrayList, maxValueInArray);
        System.out.println("Начальный список: " + Class_01.printArrayList(rndList, separator));
        delEvenNumbers(rndList);
        System.out.println("Список без четных чисел: " + Class_01.printArrayList(rndList, separator));   
    }

    public static void delEvenNumbers (ArrayList<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) % 2 == 0) {
                arrList.remove(i);
                i--;
            }
        }
    }
}