/*
1.Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

2.Доп Задача. Добавляем метод сортировки для связного списка.
Можно использовать любой алгоритм, что мы использовали на предыдущем семинаре,
но с точки зрения работы связного списка лучше ориентироваться на пузырьковую
сортировку, т.к. она взаимодействует с соседними элементами, а не только по
индексам, как делают все остальные сортировки.
 */

public class Mylist
{
    Node head;
    Node tail;
    
    public void add (int value) {
        Node node = new Node();
        node.value = value;
        
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
    
    public void reverseList () {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            
            if (next == null) {
                head = currentNode;
            }
            
            currentNode = next;
        }
    }

	public void sort() {
	    Node currentNode = head;
        Node index = null;
 
        int temp;
 
        if (head == null) return;
        else {
            while (currentNode != null) {
                index = currentNode.next;
 
                while (index != null) {
                    if (currentNode.value > index.value) {
                        temp = currentNode.value;
                        currentNode.value = index.value;
                        index.value = temp;
                    }
                     index = index.next;
                }
                currentNode = currentNode.next;
            }
        }
	}

	public String toString () {
	    String result = "";
	    Node currentNode = head;
	    while (currentNode != null) {
	        result = result + currentNode.value + " ";
	        currentNode = currentNode.next;
	    }
	    return result;
	}
	
	public class Node {
	    int value;
	    Node next;
	    Node previous;
	    
	    public String toString() {
	        return "" + value;
	    }
	}

    public static void main (String[] args) {
        Mylist lnkList = new Mylist();

        for (int i = 1; i <= 9; i++) {
            lnkList.add(i);
        }

        System.out.println("Разворот:");
        System.out.println(lnkList);
        lnkList.reverseList();
        System.out.println(lnkList);
        
        System.out.println("\nСортировка:");
        lnkList.add(55);
        System.out.println(lnkList);
        lnkList.sort();
        System.out.println(lnkList);
    }
}