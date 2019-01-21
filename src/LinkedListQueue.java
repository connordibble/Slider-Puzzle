public class LinkedListQueue<E> {
    private ListNode<E> head = new ListNode<>();
    private ListNode<E> tail;
    private int size = 0;
    private int boardsRemoved = 0;
    private int added = 0;


    public LinkedListQueue() {
        this.tail = this.head;
    }

    public void enqueue(E value) {
        ListNode<E> node = new ListNode<>(value);

        //update the next reference on the tail to the new node and then set the tail to the node
        tail.next = node;
        tail = node;

        this.size++;
        this.added++;
    }

    //method to remove the head of the queue from the list
    public E dequeue() {

      this.head = head.next;
      this.size--;
      this.boardsRemoved++;
      return this.head.value;
    }

    public int getSize() { return this.size; }
    public int getAdded() { return this.added; }
    public int getBoardsRemoved() { return this.boardsRemoved; }

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
