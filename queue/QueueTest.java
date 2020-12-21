package queue;

import java.util.Scanner;

/**
 * 用数组模拟队列
 * @author 风淡了伤
 * @create 2020-09-09-19:07
 */
public class QueueTest {
    public static void main(String[] args) {
        //测试队列
        //创建队列
        ArrQue que=new ArrQue(3);
        char key;
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):出队操作");
            System.out.println("h(head):打印头指针数据");
            System.out.println("e(exit):退出程序");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    que.showQueue();
                    break;
                case 'a':
                    int value=scanner.nextInt();
                    que.addValue(value);
                    break;
                case 'g':
                    try {
                        int v=que.outQueue();
                        System.out.println(v);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'h':
                    try {
                        int res=que.showHead();
                        System.out.println("对列头指针是:"+res);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'e':
                    scanner.close();
                    return;
            }

        }
        System.out.println("程序退出");

    }
}
class ArrQue{
    //定义队列大小
    private int maxSize;
    //定义头指针
    private int head;
    //定义尾指针
    private int end;
    //定义队列数组
    private int queue[];
    //构造类队列时初始化一个队列
    public ArrQue(int maxSize) {
        this.maxSize = maxSize;
        head=-1;//指向队列头部
        end=-1;//指向队列尾部
        queue=new int[maxSize];//构造队列数组
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return head==end;
    }
    //判断队列是否满了
    public boolean isFull(){
        return end==maxSize-1;
    }
    //进队操作
    public void addValue(int value){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满，无法进队");
            return;
        }
        queue[++end]=value;
    }
    //出队操作
    public int outQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列为空，不能出队");
        }
        int value=queue[++head];
        return value;
    }
    //输出队列
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法输出");
        }
        for (int i = 0; i <queue.length ; i++) {
            System.out.println(String.format("queue[%d]=%d", i,queue[i]));
        }
    }
    //输出队列头结点
    public int showHead(){
        //判断对列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法输出");
        }
        return queue[head+1];
    }
}
