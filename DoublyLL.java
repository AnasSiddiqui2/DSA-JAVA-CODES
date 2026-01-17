class DoublyLL {

    Node head, tail;

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ⇆ ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void deleteFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteLast() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();

        dll.addFirst(20);
        dll.addFirst(10);
        dll.addLast(30);

        System.out.print("Forward: ");
        dll.printForward();

        System.out.print("Backward: ");
        dll.printBackward();

        dll.deleteFirst();
        System.out.print("After deleteFirst: ");
        dll.printForward();

        dll.deleteLast();
        System.out.print("After deleteLast: ");
        dll.printForward();
    }
}
