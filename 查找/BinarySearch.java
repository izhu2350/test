package 查找;

import java.util.ArrayList;

/**
 * @author 风淡了伤
 * @create 2020-09-24-15:11
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
        int index=binarySearch(arr,0,arr.length-1,8);
        System.out.println(index);
        int[] arr1=new int[]{1,2,3,4,5,6,6,6,9,10};
        ArrayList list=binarySearch2(arr1,0,arr1.length,6);
        System.out.println(list.toString());
    }
    /*
    * 这里是没考虑有重复值的情况
    * */
    public static int binarySearch(int[] arr,int left,int right,int value){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if(arr[mid]>value){
           return binarySearch(arr,left,mid-1,value);
        }else if(arr[mid]<value){
            return binarySearch(arr,mid+1,right,value);
        }else{
            return mid;
        }
    }
    /*
    * 找有重复值的情况
    * */
    public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int value){
        if(left>right){
            return new ArrayList<>();
        }
        int mid=(left+right)/2;
        int findvalue=arr[mid];
        if(findvalue>value){
            return binarySearch2(arr,left,mid-1,value);
        }else if(findvalue<value){
            return binarySearch2(arr,mid+1,right,value);
        }else{
            ArrayList<Integer> list=new ArrayList<>();
            list.add(mid);
            int tem=mid-1;
            while (true){
                if(tem<0||arr[tem]!=value){
                    break;
                }
                list.add(tem);
                tem--;
            }
            tem=mid+1;
            while (true){
                if(tem>right||arr[tem]!=value){
                    break;
                }
                list.add(tem);
                tem++;
            }
            return list;
        }
    }
}
