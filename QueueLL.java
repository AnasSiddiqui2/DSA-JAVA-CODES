class QueueLinkedList {
    private Node front;
    private Node rear;

    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) { // empty queue
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " enqueued");
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = front.data;
        front = front.next;

        if (front == null) rear = null; // queue became empty
        System.out.println("Removed: " + removed);
        return removed;
    }

    public int peek() {
        if (front == null) return -1;
        return front.data;
    }

    public void printQueue() {
        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        queue.printQueue();
    }
}
