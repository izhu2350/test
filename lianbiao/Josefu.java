package lianbiao;

/**
 * 约瑟夫问题
 * n个小孩围绕成一个圈，现在从任意一个小孩开始数，数到第m个小孩则出队，然后继续从下一个小孩
 * 开始数，仍然数到第m个小孩出队，依次轮流知道最后一个小孩出队。
 * @author 风淡了伤
 * @create 2020-09-13-15:08
 */
public class Josefu {
    public static void main(String[] args) {
        CircularLinkList list=new CircularLinkList();
        list.addBoy(5);
//        list.showCircularList();
        list.josefu(1,2,5);
    }
}
/*
* 定义单向循环链表
* */
class CircularLinkList{
    private Boy first=null;
    //添加小孩节点
    public void addBoy(int num){
        //先对小孩节点做一个校验
        if(num<=0){
            System.out.println("数据不正确");
            return;
        }
        Boy curBoy=null;
        for (int i = 1; i <=num ; i++) {
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                curBoy= first;
                curBoy.setNext(first);
            }else{
                curBoy.setNext(boy);
                curBoy=boy;
                curBoy.setNext(first);
            }

        }
    }
    /*
    * @param startnum 开始从第几个小孩开始数
    * @param count     表示数几次
    * @param nums     表示最初有多少小孩在圈中
    * */
    //josefu问题
    public void josefu(int startnum,int count,int num){
        if(first==null||startnum<1||startnum>num){
            System.out.println("参数有错");
            return;
        }
        Boy help=first;
        //应该移动help指针，让help指向first的前一个节点，也就是链表的最后一个节点
        while (true){
            if(help.getNext()==first){
                break;
            }
            help=help.getNext();
        }
        //在开始数之前，先让first指针和help分别指向开始数的节点的前一个节点
        for (int i = 0; i <startnum-1 ; i++) {
            first=first.getNext();
            help=help.getNext();
        }
        //开始数
        while (true){
            if(help==first){
                break;
            }
            for(int j=0;j<count-1;j++){
                first=first.getNext();
                help=help.getNext();
            }
            System.out.println("出队节点是："+first.getNo());
            first=first.getNext();
            help.setNext(first);
        }
        System.out.println("最后一个节点是：" + help.getNo());
    }
    //遍历循环链表
    public void showCircularList(){
        if(first.getNext()==first){
            System.out.println("链表为空");
            return;
        }
        Boy cur=first;
        while (true){
            System.out.printf("同学编号为=%d",cur.getNo());
            cur=cur.getNext();
            if(cur==first){
                return;
            }
        }
    }
}
/*
* 定义小孩节点
* */
class Boy {
    private int no;
    private Boy next;
    public Boy(int num){
        this.no=num;

    }
    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}