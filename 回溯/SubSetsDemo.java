package 回溯;

import java.util.*;

/**
 * @author 风淡了伤
 * @create 2020-10-11-8:39
 */
public class SubSetsDemo {
    public static void main(String[] args) {
        int[] nums={4,4,4,1};
        Solution so=new Solution();
        List<List<Integer>> list=so.subsets(nums);
        Iterator<List<Integer>> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class Solution{
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null){
            return list;
        }
        Arrays.sort(nums);
        dfs(nums,0,temp);
        return list;
    }
    public void dfs(int[] nums,int index,List<Integer> temp){
//        if(index==nums.length){
//            list.add(new ArrayList<>(temp));
//            System.out.println(list);
//            return;
//        }
//        temp.add(nums[index]);
//        System.out.println("第一次dfs前："+temp);
//        dfs(nums,index+1,temp);
//        System.out.println("第一次dfs后："+temp);
//        temp.remove(temp.size()-1);
//        System.out.println("第二次dfs前"+temp);
//        dfs(nums,index+1,temp);
//        System.out.println("第二次dfs后"+temp);
//        if(index==nums.length){
//            return;
//        }
        list.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if(i>index&&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            dfs(nums,i+1,temp);
            temp.remove(temp.size()-1);
        }

    }
}

