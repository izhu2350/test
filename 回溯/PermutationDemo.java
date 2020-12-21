package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 风淡了伤
 * @create 2020-10-10-10:18
 */
public class PermutationDemo {
    public static void main(String[] args) {
        Permutation permutation=new Permutation();
        int[] nums={1,2,3};
        List<List<Integer>> list = permutation.permutationTest(nums);
        System.out.println(list);
    }
}
class Permutation{
    List<Integer> list=new ArrayList<Integer>();
    List<List<Integer>> list1=new ArrayList<>();
    boolean[] use={false,false,false};
    public void permutation(int[] nums,int index,List list){
        if(index==nums.length){
//            System.out.println("list:"+list);
            list1.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(use[i]!=true){
                list.add(nums[i]);
                use[i]=true;
                System.out.println("递归回溯前"+list);
                permutation(nums,index+1,list);
                list.remove(list.size()-1);
                System.out.println("递归回溯后"+list);
                use[i]=false;
            }
        }
        return;
    }
    public List<List<Integer>> permutationTest(int[] nums){
        if(nums==null){
            return list1;
        }
        permutation(nums,0,list);
        return list1;
    }
//    List<List<Integer>> list1=new ArrayList<>();
//    List<Integer> list=new ArrayList<>();
//    boolean[] use=new boolean[3];
//public List<List<Integer>> permute(int[] nums) {
//    if(nums==null){
//        return list1;
//        }
//    permutation(nums,0,list1,list,use);
//    return list1;
//}
//    public void permutation(int[] nums,int index,List<List<Integer>> list1,List<Integer> list,boolean[] use) {
//        if(index==nums.length){
//            list1.add(new ArrayList<>(list));
//            System.out.println(list1);
//            return;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(!use[i]){
//                list.add(nums[i]);
//                use[i]=true;
//                System.out.println("递归回溯前"+list);
//                permutation(nums,index,list1,list,use);
//                list.remove(list.size()-1);
//                use[i]=false;
//                System.out.println("递归回溯后"+list);
//            }
//        }
//        return;
//    }
}
