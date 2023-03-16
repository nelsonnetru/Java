// Реализовать алгоритм сортировки слиянием

import java.util.Random;
import java.util.ArrayList;

public class Class_01 {

    public static int sizeOfArrayList = 15;
    public static int maxValueInArray = 20;
    public static String separator = ", ";

    public static void main(String[] args) {
        ArrayList<Integer> rndList = new ArrayList<>();
        genArrayListRndNumbers (rndList, sizeOfArrayList, maxValueInArray);
        System.out.println("Начальный список: " + printArrayList(rndList, separator));
        divideArrList(rndList, 0, rndList.size() - 1);
        System.out.println("Сортированный список: " + printArrayList(rndList, separator));
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

    public static void divideArrList (ArrayList<Integer> rndList, int startIndex, int endIndex) {
        if(startIndex<endIndex && (endIndex-startIndex)>=1) {
            int mid = (endIndex + startIndex) / 2;
            divideArrList(rndList, startIndex, mid);
            divideArrList(rndList, mid + 1, endIndex);        

            mergeArrList(rndList, startIndex, mid, endIndex);            
        }       
    }

    public static void mergeArrList (ArrayList<Integer> rndList, int startIndex, int midIndex, int endIndex) {
        ArrayList<Integer> mergedSortArray = new ArrayList<Integer>();
        
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;
        
        while(leftIndex <= midIndex && rightIndex <= endIndex) {
            if(rndList.get(leftIndex) <= rndList.get(rightIndex)) {
                mergedSortArray.add(rndList.get(leftIndex));
                leftIndex++;
            }
            else {
                mergedSortArray.add(rndList.get(rightIndex));
                rightIndex++;
            }
        } 

        while(leftIndex<=midIndex) {
            mergedSortArray.add(rndList.get(leftIndex));
            leftIndex++;
        }
        
        while(rightIndex <= endIndex) {
            mergedSortArray.add(rndList.get(rightIndex));
            rightIndex++;
        }
        
        int i = 0;
        int j = startIndex;

        while(i < mergedSortArray.size()) {
            rndList.set(j, mergedSortArray.get(i++));
            j++;
        }
    }
}