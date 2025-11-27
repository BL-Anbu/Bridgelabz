package Day_14_Practice_Problem_Data_Structures;

public class DLLMain {

    public static void main(String[] args) {

            DoublyLinkedList myDLL = new DoublyLinkedList(1);
            myDLL.append(2);
            myDLL.append(3);
            myDLL.append(4);

            System.out.println("\n(append) Doubly Linked List:");
            myDLL.printList();
            myDLL.getHead();
            myDLL.getTail();
            myDLL.getLength();

            myDLL.prepend(0);
            myDLL.prepend(-1);
            System.out.println("\n(prepend) Doubly Linked List:");
            myDLL.printList();
            myDLL.getHead();
            myDLL.getTail();
            myDLL.getLength();

            System.out.println("\nDoubly Linked List:");
            myDLL.printList();

            System.out.println("\nRemoved Last value : " + myDLL.removeLast().value);
            System.out.println("\nDoubly Linked List:");
            myDLL.printList();
            myDLL.getHead();
            myDLL.getTail();
            myDLL.getLength();

            System.out.println("\nRemoved First value : " + myDLL.removeFirst().value);
            System.out.println("\nDoubly Linked List:");
            myDLL.printList();
            myDLL.getHead();
            myDLL.getTail();
            myDLL.getLength();

            System.out.println("\nget value by Index : " + myDLL.get(4).value);

            System.out.println("\nset value by Index: " + myDLL.set(2,12));
            myDLL.printList();

            System.out.println("\ninsert value by Index: " + myDLL.insert(2,11));
            myDLL.printList();
            myDLL.getHead();
            myDLL.getTail();
            myDLL.getLength();

            System.out.println("\ndelete value by Index: " + myDLL.remove(3).value);
            myDLL.printList();
            myDLL.getHead();
            myDLL.getTail();
            myDLL.getLength();

    }
}
