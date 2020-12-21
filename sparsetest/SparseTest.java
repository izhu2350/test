package sparsetest;

/**
 * @author 风淡了伤
 * @create 2020-09-09-7:39
 */
public class SparseTest {
    public static void main(String[] args) {
       //创建原始二维数组
        int arr1[][]=new int[11][11];
        arr1[2][1]=3;
        arr1[5][6]=5;
        arr1[6][8]=9;
        for (int [] row:arr1){
            for(int item:row){
                System.out.print("\t" + item);
            }
            System.out.println();
        }
//        System.out.println(arr1.length)
        //首先获得有多少个非0值
        int num=0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr1[i][j]!=0)
                    num++;
            }
        }
        int sparse[][]=new int[num+1][3];
        //转稀疏矩阵
        int count=0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr1[i][j]!=0){
                    count++;
                    sparse[count][0]=i;
                    sparse[count][1]=j;
                    sparse[count][2]=arr1[i][j];
                }
            }
        }
             sparse[0][0]=arr1.length;
        sparse[0][1]=arr1.length;
        sparse[0][2]=count;
        //输出稀疏矩阵
        for(int row[]:sparse){
            for(int item:row){
                System.out.print("\t" + item);
            }
            System.out.println();
        }
        //将稀疏矩阵转为二维矩阵
        int arr2[][]=new int[sparse[0][0]][sparse[0][1]];
        for(int i=1;i<sparse.length;i++){
            arr2[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        for (int [] row:arr2){
            for(int item:row){
                System.out.print("\t" + item);
            }
            System.out.println();
        }
    }
}
