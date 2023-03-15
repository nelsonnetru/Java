// Реализовать алгоритм сортировки слиянием

import java.util.Random;
import java.util.ArrayList;

public class Class_01 {

    public static int sizeOfArrayList = 15;
    public static int maxValueInArray = 20;
    public static String separator = ", ";

    public static void main(String[] args) {
        ArrayList<Integer> rndList = new ArrayList<>();


// Реализовать алгоритм сортировки слиянием






    }

    public static void genArrayListRndNumbers (ArrayList<Integer> rndList, int sizeOfArrayList, int maxValueInArray) {
        Random rnd = new Random();
        for (int i = 0; i < sizeOfArrayList; i++) 
            rndList.add(rnd.nextInt(maxValueInArray + 1));
    }

    public static String printArrayList (ArrayList<Integer> arrList, String separator) {
        StringBuilder result = new StringBuilder();
        for (Integer item: arrList) 
            result.append(item).append(separator);
        if (separator.length() > 0) 
            result.replace(result.length() - separator.length(), result.length(), "");
        return result.toString();
    }
}
