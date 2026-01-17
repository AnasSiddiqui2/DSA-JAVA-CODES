import java.util.Arrays;

public class MergeSortRecursive {

    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) return; // Base case

        int mid = si + (ei - si) / 2;

        divide(arr, si, mid);
        divide(arr, mid + 1, ei);

        conquer(arr, si, mid, ei);
    }

    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];

        int idx1 = si, idx2 = mid + 1, x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) merged[x++] = arr[idx1++];
            else merged[x++] = arr[idx2++];
        }

        while (idx1 <= mid) merged[x++] = arr[idx1++];
        while (idx2 <= ei) merged[x++] = arr[idx2++];

        for (int i = 0, j = si; i < merged.length; i++, j++) arr[j] = merged[i];
    }

    public static void mergeSort(int[] arr, int si, int ei) {
        divide(arr, si, ei);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
