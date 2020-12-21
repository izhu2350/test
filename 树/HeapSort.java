package 树;
import javax.xml.ws.soap.Addressing;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author 风淡了伤
 * @create 2020-10-07-21:03
 */
//public class HeapSort {
//    public static void main(String[] args) {
//        int[] arr={4,6,8,5,9,-1,90,89,-999,99};
//        heapSort(arr);
//    }
//    public static void heapSort(int[] nums){
//        int temp=0;
//        for (int i = nums.length/2-1; i >=0 ; i--) {
//            adjustHeap(nums,i,nums.length);
//        }
//        for(int j=nums.length-1;j>0;j--){
//            temp=nums[j];
//            nums[j]=nums[0];
//            nums[0]=temp;
//            adjustHeap(nums,0,j);
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//    public static void adjustHeap(int[] nums,int i,int length){
//        int temp=nums[i];
//        for (int k = i*2+1; k <length ; k=k*2+1) {
//            if(k+1<length&&nums[k]<nums[k+1]){
//                k++;
//            }
//            if(nums[k]>temp){
//                nums[i]=nums[k];
//                i=k;
//            }else{
//                break;
//            }
//        }
//        nums[i]=temp;
//    }
//
//}
public class HeapSort{
    public static void main(String[] args) {
        int [] arr={9,1,2,4,-1,99,-999,0};
        sort(arr);
    }
    public static void sort(int[] arr){
        int temp=0;
        /*
        * 下面的i能保证每个arr[i]都是非叶子结点原因
        * 因为非叶子结点一定是从右至左开始数，如果当前非叶子结点是左结点，那么说明
        * 右结点一定是遍历完了或者叶子结点，而当前结点i减去1之后一定是父结点
        * */

        /*
        * 初始化一个大顶堆阶段
        * */
        for (int i = arr.length/2-1; i >=0; i--) {
            adjustHeapSort(arr,i,arr.length);
        }
        for(int j=arr.length-1;j>0;j--){
            /*
            * 这里是初始化一个大顶堆后堆顶元素和最末尾叶子结点交换阶段
            * */
            temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            /*
            * 这是交换完后维护大顶堆阶段，即保证堆的结构
            * */
            adjustHeapSort(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void adjustHeapSort(int[] arr,int i,int length){
        int temp=arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k+1]>arr[k]){
                k++;
            }
            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i]=temp;
    }
}