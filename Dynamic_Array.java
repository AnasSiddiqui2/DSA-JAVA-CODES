public class DynamicArray {
    private int[] items;
    private int count;

    public DynamicArray(int length) {
        items = new int[length];
    }

    public void insert(int value) {

        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
            System.out.println("Array resized to " + items.length);
        }
        items[count++] = value;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Invalid index!");
            return;
        }
        for (int i = index; i < count - 1; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++)
            if (items[i] == value)
                return i;
        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.print(items[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray(2);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30); // triggers resize
        numbers.insert(40);
        numbers.print();
        numbers.removeAt(2);
        numbers.print();
        System.out.println("Index of 30: " + numbers.indexOf(20));
        numbers.print();
    }
}
