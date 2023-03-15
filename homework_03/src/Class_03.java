// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Class_03
{
    public static int sizeOfArrayList = 10;
    public static int maxValueInArray = 10;
    public static String separator = ", ";

    public static void main(String[] args) {
        ArrayList<Integer> rndList = new ArrayList<>();
        Class_01.genArrayListRndNumbers (rndList, sizeOfArrayList, maxValueInArray);
        System.out.println("Список: " + Class_01.printArrayList(rndList, separator));
        Collections.sort(rndList);

        System.out.printf("Минимальный элемент: %d\nМаксимальный элемент: %d\nСреднее: %.2f", rndList.get(0), rndList.get(rndList.size() - 1), midArithmetic(rndList));
    }

    public static float midArithmetic (ArrayList<Integer> arrList) {
        float result = 0f;
        for (int item: arrList) 
            result += item;
        return result / arrList.size();
    }
}
