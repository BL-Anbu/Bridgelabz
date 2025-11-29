package Day_14_Practice_Problem_Data_Structures;

public class Queue {
    Node first;
    Node last;
    int length;

    public Queue() {

    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        Node temp = first;
        if (length == 0) return null;
        if (length == 1) {
            first = null;
            last = null;
        } else {
           first=temp.next;
           temp.next=null;
        }
        return temp;
    }
}
