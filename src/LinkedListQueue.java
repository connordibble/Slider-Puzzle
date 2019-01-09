//Can generate a queue through this linked list class
//need to figure out how to put enqueue and dequeue

public class LinkedListQueue<E extends Comparable> {
    private ListNode<E> head = new ListNode<>();
    private ListNode<E> tail;
    private int size = 0;


    public LinkedListQueue() {
        this.tail = this.head;
    }

    public void enqueue(E value) {
        ListNode<E> node = new ListNode<>(value);

        //update the next reference on the tail to the new node and then set the tail to the node
        tail.next = node;
        tail = node;

        this.size++;
    }

    //method to remove the head of the queue from the list
    public E dequeue() {
      this.head = head.next;
      this.size--;
      return this.head.value;
    }

    //Show the Queue
    public void show() {
        ListNode<E> current = head.next;
        System.out.println("--- Values in List ---");
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println();
    }


    //method that searches for the value in a linked list
    public boolean findValue(E search) {
        ListNode<E> node = head.next;

        //if item is not found, false will be returned
        boolean found = false;
        while (!found && node != null) {
            if (node.value.compareTo(search) == 0) {
                found = true;
            }
            else {
                node = node.next;
            }
        }

        return found;
    }



    public int getSize() { return this.size; }
    public boolean isEmpty() { return this.size == 0; }

    //nested class that creates a node for the linked list
    private class ListNode<E> {
        public E value;
        public ListNode<E> next;

        public ListNode() {}
        public ListNode(E Z) {
            this.value = Z;
        }
    }
}
