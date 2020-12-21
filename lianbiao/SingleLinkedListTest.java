package lianbiao;

import jdk.nashorn.internal.ir.WhileNode;

import java.security.Signature;
import java.util.LinkedList;

/**
 * @author 风淡了伤
 * @create 2020-09-11-20:30
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        HearoNode hearo1=new HearoNode(1,"宋江","及时雨");
        HearoNode hearo2=new HearoNode(2,"卢俊义","玉麒麟");
        HearoNode hearo3=new HearoNode(3,"吴用","智多星");
        HearoNode hearo4=new HearoNode(4,"林冲","豹子头");
        SingleLinkedList singlelist=new SingleLinkedList();
/*        singlelist.add(hearo1);
        singlelist.add(hearo2);
        singlelist.add(hearo3);
        singlelist.add(hearo4);
        singlelist.showList();*/
        singlelist.addByOrder(hearo1);
        singlelist.addByOrder(hearo4);
        singlelist.addByOrder(hearo2);
        singlelist.addByOrder(hearo3);
        singlelist.showList();
        HearoNode hearoNode5=new HearoNode(3,"璐璐","玉骑铃");
        singlelist.updateNode(hearoNode5);
        singlelist.showList();
        singlelist.deleteNode(4);
        singlelist.showList();

    }
}
//定义链表
class SingleLinkedList{
    //初始化一个头结点
    private HearoNode head=new HearoNode(0,"","");
    public HearoNode getHead(){
        return head;
    }
    //向链表添加节点
    public void add(HearoNode hearoNode){
        HearoNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=hearoNode;
    }
    //顺序添加节点
    public void addByOrder(HearoNode hearoNode){
        boolean flag=false;
        HearoNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }else if(temp.next.no>hearoNode.no){
                break;
            }else if(temp.no==hearoNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            System.out.printf("节点%d已经存在",hearoNode.no);
        }else {
            hearoNode.next=temp.next;
            temp.next=hearoNode;
        }
    }
    //修改节点
    public void updateNode(HearoNode newNode){
        boolean flag=false;
        HearoNode temp=head.next;
        while (true){
            if(temp==null){
                System.out.println("节点为空");
            }
            if(temp.no==newNode.no){
                temp.name=newNode.name;
                temp.nickName=newNode.nickName;
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    public void deleteNode(int nodeNum){
        boolean flag=false;
        HearoNode temp=head;
        while (true){
            if(temp.next==null){
                System.out.println("没有找到该节点");
                break;
            }
            if(temp.next.no==nodeNum){
                temp.next=temp.next.next;
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==false){
            System.out.println("失败");
        }else {
            System.out.println("删除成功");
        }
    }
    //遍历链表
    public void showList(){

        if(head.next==null){
            System.out.println("链表为空");
        }
        HearoNode temp=head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
//定义节点
class HearoNode{
    public int no;
    public String name;
    public String nickName;
    HearoNode next;

    public HearoNode (int no,String name,String nickName) {
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HearoNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
