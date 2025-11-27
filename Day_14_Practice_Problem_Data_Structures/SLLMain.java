package Day_14_Practice_Problem_Data_Structures;

public class SLLMain {

    public static void main(String[] args) {
        SingleLinkedList myLinkedList = new SingleLinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.prepend(0);

        //      PRINT LIST
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        myLinkedList.printList();
        System.out.println("\nRemoved Last value : " + myLinkedList.removeLast().value);
        System.out.println("\nRemoved First value : " + myLinkedList.removeFirst().value);
        System.out.println("\nget value by Index : " + myLinkedList.get(1).value);
        System.out.println("\nset value by Index: " + myLinkedList.set(2,10));
        myLinkedList.printList();
        System.out.println("\ninsert value by Index: " + myLinkedList.insert(1,11));
        myLinkedList.printList();
        System.out.println("\ndelete value by Index: " + myLinkedList.remove(3).value);

        myLinkedList.printList();


    }
}
