public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 12, 9, 21, 3};
        int index = linearSearch(arr, 21);

        System.out.println(index == -1 ? "Not Found" : "Found at index: " + index);
    }
}
