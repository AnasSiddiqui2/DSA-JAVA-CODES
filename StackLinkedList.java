class StackLinkedList {

    private Node top;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(value + " pushed to stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        System.out.println(poppedValue + " popped from stack");
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        Node current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printStack2() {
        while (!isEmpty()) {
            System.out.println(peek());
            pop();
        }
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop(); // removes 30

        stack.push(40);

        System.out.println("Top element: " + stack.peek());

        stack.printStack(); // prints 40 20 10
    }
}
