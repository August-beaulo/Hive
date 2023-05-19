package game;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 7, 6, 9, 8};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr) {
        // 外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 比较大小，如果前者大于后者，则交换位置
                if (arr[j] > arr[j + 1]) {
                    // 交换位置
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }

        }
    }
}
