package bonus00;

public class BinarySearch {
    public static int binarySearch(int[] array, int target, int left, int right) {
        if(left == right) return -1;

        int idx = left + (right - left) / 2;

        if (array[idx] == target) return idx;
        else if (target > array[idx]) {
            return binarySearch(array, target, idx + 1, right);
        } else if (target < array[idx]) {
            return binarySearch(array, target, left, idx);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(array, 3, 0, 9));
    }
}

