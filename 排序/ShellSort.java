package 排序;

import java.util.Arrays;

/**
 * 希尔排序
 * @author 风淡了伤
 * @create 2020-09-22-15:01
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,3,11,10,4,8,7,0,6};
        sort2(arr);

    }
    /*
    * 这是插入法排序
    * 这里每个gap组中的数据都要进行交换排序，这样就消费了很多时间
    * */
    public static void sort(int[] arr){
        int temp=0;
        int count=0;//记录排序几次
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                for(int j=i-gap;j>=0;j-=gap){
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            System.out.println("第" + (++count) + "轮排序后的结果" + Arrays.toString(arr));
        }
    }
    /*
    * 采用移位法
    * 这里对于每一个gap组进行的是插入排序的思想
    * */
    public static void sort2(int[] arr){
        int temp=0;
        int count=0;
        for(int gap=arr.length/2;gap>0;gap/=2){
            for (int i = gap; i <arr.length ; i++) {
                int j=i;
                temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){//这里是找到temp元素插入的位置
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
            System.out.println("第" + (++count) + "轮排序后的结果：" + Arrays.toString(arr));
        }
    }
}
