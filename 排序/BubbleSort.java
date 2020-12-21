package 排序;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * @author 风淡了伤
 * @create 2020-09-22-10:51
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        swap(arr);
    }
    public static void swap(int[] arr){
        int temp=0;
        boolean flag=false;
        for (int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            if(flag==false){
                break;
            }
        }
    }

}
