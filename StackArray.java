class StackArray {
    private int[] stack;
    private int top;

    public StackArray(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == stack.length - 1) {  // Stack full, resize
            resize();
        }
        stack[++top] = value;
        System.out.println(value + " pushed to stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }
        int removed = stack[top--];
        System.out.println(removed + " popped from stack");
        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

    private void resize() {
        int newSize = stack.length * 2;
        int[] newStack = new int[newSize];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        System.out.println("Stack size doubled to " + newSize);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();          // 30 popped
        stack.push(40);
        stack.push(50);
        stack.push(60);       // triggers resize

        System.out.println("Top element: " + stack.peek());
        stack.printStack();   // prints stack from top to bottom
    }
}
