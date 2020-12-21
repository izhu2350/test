package 查找;

/**
 * 插值查找
 * @author 风淡了伤
 * @create 2020-09-24-19:08
 */
/*
* 插值查找适用于数据分布均匀
* */

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i <100 ; i++) {
            arr[i]=i;
        }
        int index=insertValueSearch(arr,0,arr.length-1,66);
        System.out.println(index);

    }
    public static int insertValueSearch(int[] arr,int left,int right,int findValue){
        System.out.println("查找次数");
        if(left>right||findValue<arr[0]||findValue>arr[right]){
            return -1;
        }
        /*
        * 这个mid的计算公式是插值查找的关键，其它和二分查找一样
        * */
        int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[mid];
        if(findValue>midValue){
            return insertValueSearch(arr,mid+1,right,findValue);
        }else if(findValue<midValue){
            return insertValueSearch(arr,left,mid-1,findValue);
        }else{
            return mid;
        }
    }

}
