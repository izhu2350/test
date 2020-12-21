package 查找;

/**
 * @author 风淡了伤
 * @create 2020-09-24-15:03
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[]=new int[]{1,9,11,-1,34,89};
    }
    /*
    * 顺序查找
    * */
    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
