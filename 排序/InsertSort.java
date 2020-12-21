package 排序;

import java.util.Arrays;

/**
 * @author 风淡了伤
 * @create 2020-09-22-14:10
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr=new int[]{101,34,45,124};
        sort(arr);
    }
    public static void sort(int[] arr){
        int insertValue=0;
        int insertIndex=0;
        for (int i = 1; i <arr.length ; i++) {
            insertIndex=i-1;
            insertValue=arr[i];
            while (insertIndex>=0&&insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertValue;
            System.out.println("第" + i + "轮排序后");
            System.out.println(Arrays.toString(arr));
        }
    }
}
