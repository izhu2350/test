package 算法.背包;

import java.util.concurrent.ForkJoinPool;

/**
 * @author 风淡了伤
 * @create 2020-10-18-10:11
 */
public class NapSackProblem {
    public static void main(String[] args) {
        int[] value={1500,3000,2000};
        int[] weight={1,4,3};
        int n=3;//物品数量
        int m=4;//背包容量
        int[][] v=new int[n+1][m+1];
        int[][] path=new int[n+1][m+1];//这个存储最终存储到背包中的物品编号
        //给第一行置0
        for (int i = 0; i <v[0].length ; i++) {
            v[0][i]=0;
        }
        //给第一列置为0
        for (int i = 0; i <v.length ; i++) {
            v[i][0]=0;
        }
        //根据公式来动态规划处理
        for (int i = 1; i <v.length ; i++) {
            for (int j = 1; j <v[i].length ; j++) {
                //如果当前物品重量小于背包重量
                if(weight[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else{
                    //这里看pad笔记
//                    v[i][j]=Math.max(v[i][j],value[i-1]+v[i-1][j-weight[i-1]]);
                    if(v[i-1][j]<value[i-1]+v[i-1][j-weight[i-1]]){
                        v[i][j]=value[i-1]+v[i-1][j-weight[i-1]];
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
            
        }
        for (int i = 0; i <v.length ; i++) {
            for (int j = 0; j <v[i].length ; j++) {
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        /*
        * 输出最终放入背包的物品
        * */
        int i=path.length-1;//行的最大下标
        int j=path[0].length-1;//列的最大下标
        /*
        * 因为i是代表着第几个物品，而j是代表着背包容量，path是记录着存入背包的物品编号
        * 当输出第i个物品后还有容量则需要减去i这个物品容量之后再遍历剩余容量对应的物品编号
        * */
        while (i>0&&j>0){
            if(path[i][j]==1){
                System.out.println("第"+i+"个物品放入背包中");
                j=j-weight[i-1];
            }
            i--;
        }
    }
}
