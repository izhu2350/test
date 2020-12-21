package 排序;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author 风淡了伤
 * @create 2020-09-22-13:51
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[]{3,1,2,8,5};
        sort(arr);
    }
    public static void sort(int[] arr){
        int minindex=0;
        int min=0;
        for(int i=0;i<arr.length-1;i++){
            minindex=i;
            min=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    minindex=j;
                    min=arr[j];
                }
            }
            if(minindex!=i){
                int temp=arr[i];
                arr[i]=arr[minindex];
                arr[minindex]=temp;
            }

            System.out.println("第" + i + "轮后结果");
            System.out.println(Arrays.toString(arr));
        }
    }
}
