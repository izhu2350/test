package 排序;

import java.util.Arrays;

/**
 * @author 风淡了伤
 * @create 2020-09-23-16:45
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,4,5,6,10,7,9,8,0};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
//    //拆+合
//    public static void mergeSort(int[] arr,int left,int right,int[] temp){
//        if(left<right){
//            int mid=(left+right)/2;
//            mergeSort(arr,left,mid,temp);
//            mergeSort(arr,mid+1,right,temp);
//            merge(arr,left,mid,right,temp);
//        }
//    }
//分+合方法
public static void mergeSort(int[] arr, int left, int right, int[] temp) {
    if(left < right) {
        int mid = (left + right) / 2; //中间索引
        //向左递归进行分解
        mergeSort(arr, left, mid, temp);
        //向右递归进行分解
        mergeSort(arr, mid + 1, right, temp);
        //合并
        Merge(arr, left, right, mid, temp);

    }
}
//    //差分后的合并
    public static void Merge(int[] arr,int left,int right,int mid,int[] temp){
        /*
        * 先将左右两边拆分的数组按照顺序插入到临时数组temp中，直到有一边处理完毕为止
        * */
        int i=left;//左边有序序列的初始索引
        int j=mid+1;//右边有序序列的初始索引
        int t=0;//指向temp数组的当前索引
        while (i<=mid&&j<=right){
            //如果左边的有序序列当前元素小于右边的，则将左边该数据插入到临时数组中
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else{
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }
        /*
        * 将还未遍历完的一边有序序列插入到临时数组中
        * */
        while (i<=mid){
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        /*
        * 将临时数组拷贝到原数组中，注意
        * */
        int Leftemp=left;
        t=0;
        while (Leftemp<=right){
            arr[Leftemp]= temp[t];
            t+=1;
            Leftemp+=1;
        }
    }


    //合并的方法
    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
//    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
//
//        int i = left; // 初始化i, 左边有序序列的初始索引
//        int j = mid + 1; //初始化j, 右边有序序列的初始索引
//        int t = 0; // 指向temp数组的当前索引
//
//        //(一)
//        //先把左右两边(有序)的数据按照规则填充到temp数组
//        //直到左右两边的有序序列，有一边处理完毕为止
//        while (i <= mid && j <= right) {//继续
//            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
//            //即将左边的当前元素，填充到 temp数组
//            //然后 t++, i++
//            if(arr[i] <= arr[j]) {
//                temp[t] = arr[i];
//                t += 1;
//                i += 1;
//            } else { //反之,将右边有序序列的当前元素，填充到temp数组
//                temp[t] = arr[j];
//                t += 1;
//                j += 1;
//            }
//        }
//
//        //(二)
//        //把有剩余数据的一边的数据依次全部填充到temp
//        while( i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
//            temp[t] = arr[i];
//            t += 1;
//            i += 1;
//        }
//
//        while( j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
//            temp[t] = arr[j];
//            t += 1;
//            j += 1;
//        }
//
//
//        //(三)
//        //将temp数组的元素拷贝到arr
//        //注意，并不是每次都拷贝所有
//        t = 0;
//        int tempLeft = left; //
//        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
//        //最后一次 tempLeft = 0  right = 7
//        while(tempLeft <= right) {
//            arr[tempLeft] = temp[t];
//            t += 1;
//            tempLeft += 1;
//        }
//
//    }

}
