public class BinarySearchRecursive {

    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;

        if (target < arr[mid])
            return binarySearchRecursive(arr, low, mid - 1, target);

        return binarySearchRecursive(arr, mid + 1, high, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 7;

        int index = binarySearchRecursive(arr, 0, arr.length - 1, target);

        if (index != -1)
            System.out.println("Target " + target + " found at index: " + index);
        else
            System.out.println("Target " + target + " not found in array.");
    }
}
