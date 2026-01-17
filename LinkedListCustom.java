import java.util.Scanner;

class LinkedListCustom {

    Node head;
    int size;

    LinkedListCustom() {
        size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public int searchElement(int value) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == value)
                return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public void deleteGreaterThan(int limit) {
        // Delete from head
        while (head != null && head.data > limit) {
            head = head.next;
            size--;
        }

        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data > limit) {
                curr.next = curr.next.next;
                size--;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListCustom list = new LinkedListCustom();

        System.out.print("Enter size of list: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        System.out.print("\nOriginal List: ");
        list.printList();

        // Keep search element functionality as-is
        int searchValue = 7;
        int index = list.searchElement(searchValue);
        if (index != -1)
            System.out.println("Element " + searchValue + " found at index: " + index);
        else
            System.out.println("Element " + searchValue + " not found.");

        // Delete elements greater than 25
        list.deleteGreaterThan(25);

        System.out.print("Updated List (after deleting >25): ");
        list.printList();

        sc.close();
    }
}
