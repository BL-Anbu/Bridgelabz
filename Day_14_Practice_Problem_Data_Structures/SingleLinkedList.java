package Day_14_Practice_Problem_Data_Structures;

public class SingleLinkedList {

    private Node head;
    private Node tail;
    private int length;

    //Constructor
    public SingleLinkedList() {

    }

    public SingleLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void getHead() {
        System.out.println("Head : " + head.value);
    }

    public void getTail() {
        System.out.println("Tail : " + tail.value);
    }

    public void getLength() {
        System.out.println("Length : " + length);
    }

    //Append Method
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //Remove Last value in the List
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node prev = head;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        tail = prev;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    //Prepend Add a value in the Start
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = temp.next;
        temp.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) return false;
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length - 1) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) removeFirst();
        if (index == length - 1) removeLast();
        Node prev = get(index - 1);
        Node temp = get(index);
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

//    public LinkedList(int value){}
//    //Create a new Node
//    public void append(int value){}
//    //Create a new Node
//    //Add node to end
//    public void prepend(int value){}
//    //Create a new Node
//    //Add node to beginning
//    public boolean insert(int index,int value){}
//    //Create a new Node
//    //insert node in particular index

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    /*NOTES :
            1 ) static method can't access the not static global variable





    */
}
