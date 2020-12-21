package recursion;

import java.util.concurrent.ForkJoinPool;

/**
 * @author 风淡了伤
 * @create 2020-09-21-15:00
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map=new int [7][8];
        //定义上下两边为1
        for(int i=0;i<8;i++){
            map[0][i]=1;
            map[6][i]=1;
        }
        //定义左右两边为1
        for(int j=0;j<7;j++){
            map[j][0]=1;
            map[j][7]=1;
        }
        //定义挡板
        map[3][1]=map[3][2]=1;
        setWay(map,1,1);
        //查看地图
        for (int i = 0; i <7 ; i++) {
            for(int j=0;j<8;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean setWay(int[][] map,int i,int j){
        if(map[5][6]==2){//通路已经找到
            return true;
        }else{
            if(map[i][j]==0){//如果当前这个点还没有走过
                //按照策略 下-》右-》上——》左走
                map[i][j]=2;//假定该点可以走通
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
