package 图;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author 风淡了伤
 * @create 2020-10-14-16:26
 */
public class GraphInit {
    private ArrayList<String> vertexList;//存储节点
    private int[][] edges;//边的邻接矩阵
    private int numEdges;//边的数目
    boolean[] isVisited;
    public static void main(String[] args) {
        GraphInit graph=new GraphInit(5);
        String[] Vertex={"A","B","C","D","E"};
        for(String vertex:Vertex){
            graph.insertVertex(vertex);
        }
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.showGraph();
//        graph.depthFirstSearch();
        graph.BFSFirstSearch();
    }
    public GraphInit(int n){
        vertexList=new ArrayList<>(n);
        edges=new int [n][n];
        numEdges=0;
        isVisited=new boolean[n];
    }
    //得到节点的个数
    public int getVertexNum(){
        return vertexList.size();
    }
    //得到边的个数
    public int getNumEdges(){
        return numEdges;
    }
    //返回结点i的数据
    public Object getValueByIndex(int i){
        return vertexList.get(i);
    }
    //插入结点
    public void insertVertex(String vertexvalue){
        vertexList.add(vertexvalue);
    }
    //插入边信息
    public void insertEdges(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        numEdges++;
    }
    //显示图信息
    public void showGraph(){
        for(int[] vertex:edges){
            System.out.println(Arrays.toString(vertex));
        }
    }
    //删除节点
    public void deleteVertex(int v1,int v2){
        edges[v1][v2]=0;
        numEdges--;
    }
    //获取第一个结点
    public int getFirstVertex(int i){
        for (int j = 0; j <vertexList.size() ; j++) {
            if(edges[i][j]>0){
                return j;
            }
        }
        return -1;
    }
    //根据当前结点索引获取下一个邻接结点
    public int getNextVertex(int v1,int v2){
        for (int i = v2+1; i <vertexList.size() ; i++) {
            if(edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历
    public void depthFirstSearch(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i)+"-->");
        isVisited[i]=true;
        int w=getFirstVertex(i);
        while (w!=-1){
            if(!isVisited[w]){
                depthFirstSearch(isVisited,w);
            }
            w=getNextVertex(i,w);
        }
    }
    //对外公开函数，通过重载来实现对外公开深度优先遍历
    public void depthFirstSearch(){
        /*
        * 这里用for循环的原因是对于非连通的图来说，仅仅通过一个结点是无法遍历所有结点的
        * 只有通过for循环来保证每个结点都会被访问到
        * */
        for (int i = 0; i <vertexList.size() ; i++) {
            if(!isVisited[i]){
                depthFirstSearch(isVisited,i);
            }
        }
    }

    public void BFSFirstSearch(boolean[] isVisited,int i){
        int w,u;
        System.out.println(getValueByIndex(i)+"==>");
        isVisited[i]=true;
        Deque dq=new ArrayDeque();
        dq.addLast(i);
        while (!dq.isEmpty()){
            u=(Integer) dq.pollFirst();
            w=getFirstVertex(u);
            while (w!=-1){
                if(!isVisited[w]){
                    isVisited[w]=true;
                    dq.addLast(w);
                    System.out.println(getValueByIndex(w)+"==>");
                }
                w=getNextVertex(u,w);
            }
        }
    }
    public void BFSFirstSearch(){
        for (int i = 0; i <vertexList.size() ; i++) {
            if(!isVisited[i]){
                BFSFirstSearch(isVisited,i);
            }
        }
    }
}
