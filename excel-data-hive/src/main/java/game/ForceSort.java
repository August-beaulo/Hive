package game;
/**
 * 暴力排序
 * 从小到大
 * 两两比较 交换位置
 * 一趟排序后最大的数在最后
 * 一共需要n-1趟排序
 * 每趟排序需要比较n-1-i次
 * i为趟数
 */
public class ForceSort {
    //暴力排序
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4, 7, 6, 9, 8};
        forceSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 暴力排序 从小到大    两两比较 交换位置 一趟排序后最大的数在最后 一共需要n-1趟排序 每趟排序需要比较n-1-i次 i为趟数
     * @param arr
     */
    private static void forceSort(int[]arr) {
        //外层循环控制排序趟数
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }
}
