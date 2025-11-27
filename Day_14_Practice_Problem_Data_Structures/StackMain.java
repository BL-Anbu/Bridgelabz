package Day_14_Practice_Problem_Data_Structures;

public class StackMain {
    // First in Last out / Last in First out
    public static void main(String[] args) {
        Stack myStack = new Stack(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println("\nStacks : ");
        myStack.printStack();
        myStack.getTop();
        myStack.getHeight();

        System.out.println("POP : " + myStack.pop().value);
        myStack.printStack();
        System.out.println("POP : " + myStack.pop().value);
        myStack.printStack();
    }
}
