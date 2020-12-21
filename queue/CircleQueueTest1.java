package queue;

import java.util.Scanner;

/**
 * //环形数组队列
 * @author 风淡了伤
 * @create 2020-09-11-18:38
 */
public class CircleQueueTest1 {
    public static void main(String[] args) {
        CircleQueue que=new CircleQueue(3);
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
                    que.enterQueue(value);
                    break;
                case 'g':
                    try {
                        int v=que.exitQueue();
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
class CircleQueue{
    //创建头尾指针以及循环队列数组
    private int maxSize;//数组容量
    private int front;//队头指针
    private int rear;//队尾指针
    private int []circleArr;
    //构造函数,初始化循环队列
    public CircleQueue(int maxSize){
        this.maxSize=maxSize;
        this.front=0;
        this.rear=0;
        circleArr=new int[maxSize];
    }
    //判断是否队空
    public boolean isEmpty(){
        return front==rear;
    }
    //判断队满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //进队操作
    public void enterQueue(int x){
        //判断是否队满
        if(isFull()){
            System.out.println("队列已满");
        }
        circleArr[rear]=x;
        rear=(rear+1)%maxSize;
    }
    //出队操作
    public int exitQueue(){
        //判断是否队空
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法出队");
        }
        int value=circleArr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //打印队列
    public void showQueue(){
        //判断是否队空
        if(isEmpty()){
            System.out.println("队列为空");
        }
        for(int i=front;i<(rear-front+maxSize)%maxSize;i++){
            System.out.println(String.format("circleArr[%d]=%d",i%maxSize,circleArr[i%maxSize]));
        }
    }
    //打印队列头
    public int showHead(){
        //判断是否队空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value=circleArr[front];
        front=(front+1)%maxSize;
        return value;
    }
}
