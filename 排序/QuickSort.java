package 排序;
import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 * @author 风淡了伤
 * @create 2020-09-22-16:20
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{47,31,83,91,57,18,96,16};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr,int low,int high) {
        if(low>high){
            return;
        }
        int i,j,base,t;
        i=low;
        j=high;
        base=arr[low];
        while (i<j){
            while (arr[j]>base&&i<j)--j;
            while (arr[i]<=base&&i<j)++i;//这里一定要有等于，因为base值是不能换到右边的
            if(i<j){
                t=arr[j];
                arr[j]=arr[i];
                arr[i]=t;
            }
        }
        arr[low]=arr[i];
        arr[i]=base;
        System.out.println(Arrays.toString(arr));
        sort(arr,low,j-1);
        sort(arr,j+1,high);
    }
}
