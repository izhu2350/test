package lianbiao;

import sun.text.resources.cldr.ia.FormatData_ia;

import java.util.Stack;

/**
 * @author 风淡了伤
 * @create 2020-09-12-20:51
 */
public class ReverseSingleListTest {
    public static void main(String[] args) {
        ReverseSingleListTest re=new ReverseSingleListTest();
        Node[] nodes=re.defineNode(5);
        SingleList list=new SingleList();
        for (int i = 0; i <5 ; i++) {
            list.addByOrder(nodes[i]);
        }
        list.reversePrint(list.getHead());
        list.reverList();
        list.showList();

    }
    //定义节点方法
    public Node[] defineNode(int k){
        Node[] nodes=new Node[k];
        for (int i = 0; i <k ; i++) {
            nodes[i]=new Node(i);
        }
        return nodes;
    }
}
class SingleList{
    //定义头节点
    Node head=new Node(0);
    //获取头节点
    public Node getHead(){
        return head;
    }
    //插入节点
    public void addByOrder(Node node){
        boolean flag=false;
        Node temp=head;
        while (true){
            if(temp.next==null){
                break;
            }else if(temp.next.no>node.no){
                break;
            }else if(temp.no==node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            System.out.printf("节点%d已经存在",node.no);
        }else {
            node.next=temp.next;
            temp.next=node;
        }
    }
    //反转链表
    public void reverList(){
        Node cur=head.next;
        Node next=null;
        Node temp=new Node(0);
        while (cur!=null){
            if(head.next==null||cur.next==null){
                break;
            }
            next=cur.next;
            cur.next=temp.next;
            temp.next=cur;
            cur=next;
        }
        head.next=temp.next;
    }
    //逆序打印链表，不改变链表结构(使用栈)
    public void reversePrint(Node head){
        Node cur=head.next;
        Stack<Node> stack=new Stack<>();//栈对象的创建
        if(cur==null){
            System.out.println("链表为空");
        }
        while (true){
            if(cur==null){
                break;
            }
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    //显示链表
    public void showList(){
        if(head.next==null){
            System.out.println("链表为空");
        }
        Node temp=head.next;
        while (true){
            if(temp==null){
                System.out.println("遍历完成");
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
//节点类
class Node{
    public int no;
    Node next;
    public Node(int no){
        this.no=no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
