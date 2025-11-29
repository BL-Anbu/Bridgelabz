package Day_14_Practice_Problem_Data_Structures;

public class QueueMain {

    //    First in First out / Last in Last out
    public static void main(String[] args) {
        Queue myQueue = new Queue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);

        System.out.println("Enqueue : ");
        myQueue.printQueue();

        System.out.println("Dequeue : " + myQueue.dequeue().value);
        myQueue.printQueue();
        System.out.println("Dequeue : " + myQueue.dequeue().value);
        myQueue.printQueue();
    }
}
