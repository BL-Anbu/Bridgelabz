package Day_14_Practice_Problem_Data_Structures.InterviewProblem;


public class SingleLinkedList {

//1. Find the Middle of the Node
//      public Node findMiddleNode() {
//          Node slow = head;
//          Node fast = head;
//          while (fast != null && fast.next != null) {
//              slow = slow.next;
//              fast = fast.next.next;
//          }
//          return Node;
//      }

//2. Has Loop ,find the list is loop
//    public boolean hasLoop() {
//        Node slow = head;
//        Node fast = head;
//        while (fast != null && fast.next != null) {
//            slow=slow.next;
//            fast=fast.next.next;
//            if(fast==slow) return true;
//        }
//        return false;
//    }

    //3. Kth Node from End
//    public Node kthNodeFromEnd(int k) {
//        Node slow = head;
//        Node fast = head;
//        for (int i = 0; i < k; i++) {
//            if (fast == null) return null;
//            fast = fast.next;
//        }
//        while (fast != null) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//        return slow;
//    }

    //4.  Remove Duplicate
//    public void removeDuplicate() {
//        Node current = head;
//        while (current != null) {
//            Node runner = current;
//            while (runner.next != null) {
//                if(current.value == runner.next.value){
//                    runner.next=runner.next.next;
//                }else{
//                    runner=runner.next;
//                }
//            }
//            current=current.next;
//        }
//    }
//    public void removeDuplicates() {
//        Set<Integer> values = new HashSet<>();
//        Node previous = null;
//        Node current = head;
//        while (current != null) {
//            if (values.contains(current.value)) {
//                previous.next = current.next;
//                length -= 1;
//            } else {
//                values.add(current.value);
//                previous = current;
//            }
//            current = current.next;
//        }
//    }

//    5. Binary TO Decimal
//    public int binaryToDecimal() {
//        int num = 0;
//        Node current = head;
//        while (current != null) {
//            num = num * 2 + current.value;
//            current = current.next;
//        }
//        return num;
//    }
}
