/*
Реализуйте очередь с помощью LinkedList со следующими методами:
• enqueue() — помещает элемент в конец очереди,
• dequeue() — возвращает первый элемент из очереди и удаляет его,
• first() — возвращает первый элемент из очереди, не удаляя.
 */

import java.util.LinkedList;

public class Class_02 {
    private static final int sizeOfList = 5, maxValueInList = 10;
    public static void main(String[] args) {
        LinkedList <Integer> linkList = new LinkedList<>();

        Class_01.genListRndNumbers(linkList, sizeOfList, maxValueInList);
        System.out.print("LinkedList: ");
        Class_01.printListNumbers(linkList);

        enqueue(linkList, 999);
        System.out.print("enqueue: ");
        Class_01.printListNumbers(linkList);

        System.out.println("dequeue(): " + dequeue(linkList));
        System.out.print("LinkedList: ");
        Class_01.printListNumbers(linkList);

        System.out.println("first(): " + first(linkList));
        System.out.print("LinkedList: ");
        Class_01.printListNumbers(linkList);
    }

    public static void enqueue (LinkedList<Integer> linkList, int element) {
        linkList.addLast(element);
    }

    public static int dequeue (LinkedList<Integer> linkList) {
        return linkList.removeFirst();
    }

    public static int first (LinkedList<Integer> linkList) {
        return linkList.getFirst();
    }
}
