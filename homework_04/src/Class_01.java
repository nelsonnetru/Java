// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёт «перевёрнутый» список.

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
public class Class_01 {

    private static final int sizeOfList = 10, maxValueInList = 15;
    public static void main(String[] args) {
        LinkedList<Integer> linkList = new LinkedList<>();
        genListRndNumbers(linkList, sizeOfList, maxValueInList);
        LinkedList<Integer> descList = descLinkList(linkList);

        System.out.print("Исходный список: ");
        printListNumbersByIterator(linkList);

        System.out.print("Перевернутый список: ");
        printListNumbers(descList);
    }

    public static LinkedList<Integer> descLinkList (LinkedList<Integer> linkList) {
        Iterator<Integer> desc = linkList.descendingIterator();
        LinkedList<Integer> resultLinkList = new LinkedList<>();
        while (desc.hasNext()) {
            resultLinkList.add(desc.next());
        }
        return resultLinkList;
    }
    public static void printListNumbers (LinkedList<Integer> listNumbers) {
        for (Integer item : listNumbers) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void printListNumbersByIterator (LinkedList<Integer> listNumbers) {
        Iterator<Integer> col = listNumbers.iterator();
        while (col.hasNext()) {
            System.out.print(col.next() + " ");
        }
        System.out.println();
    }
    public static void genListRndNumbers (LinkedList<Integer> rndList, int sizeOfList, int maxValueInList) {
        Random rnd = new Random();
        for (int i = 0; i < sizeOfList; i++)
            rndList.add(rnd.nextInt(maxValueInList + 1));
    }
}
