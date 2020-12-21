package 查找;

/**
 * @author 风淡了伤
 * @create 2020-10-16-21:18
 */
public class BianrySearchNoCursion {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,100,150};
        int index=binarySearch(arr,1);
        System.out.println(index);
    }
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){return mid;}
            else if(arr[mid]>target){right=mid-1;}
            else{
                left=mid+1;
            }
        }
        return -1;
    }
}
