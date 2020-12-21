package 树.线索二叉树;

import java.io.PrintStream;

/**
 * @author 风淡了伤
 * @create 2020-10-04-19:55
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        Node root=new Node(1);
        Node node2=new Node(3);
        Node node3=new Node(6);
        Node node4=new Node(8);
        Node node5=new Node(10);
        Node node6=new Node(14);
        root.setLeftNode(node2);
        root.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node3.setLeftNode(node6);
        ThreadedBinaryTree threaded=new ThreadedBinaryTree();
        threaded.setRoot(root);
        threaded.threadedBinaryTree();
        Node node8=node2.getLeftNode();
//        System.out.println("8结点的前驱结点="+node8.getLeftNodeType()+node8.getRightNode());
        threaded.ThreadedList();
    }
}
class ThreadedBinaryTree{
    private Node root;
    private Node pre=null;
    public void setRoot(Node root){
        this.root=root;
    }
    public void threadedBinaryTree(){
        this.threadedBinaryTree(root);
    }
    public void threadedBinaryTree(Node node){
        if(node==null){
            return;
        }
        //线索化左子树
        threadedBinaryTree(node.getLeftNode());
        //线索化当前结点，先处理当前结点的前驱结点
        if(node.getLeftNode()==null){
            node.setLeftNode(pre);
            node.setLeftNodeType(1);
        }
        //线索化当前结点的后继结点
        if(pre!=null&&pre.getRightNode()==null){
            pre.setRightNode(node);
            pre.setRightNodeType(1);
        }
        pre=node;
        //线索化右子树
        threadedBinaryTree(node.getRightNode());
    }
    //遍历线索二叉树
    public void ThreadedList(){
        Node node=root;
        while (node!=null){
            while (node.getLeftNodeType()==0){
                node=node.getLeftNode();
            }
            System.out.println(node);
            while (node.getLeftNodeType()==1){
                node=node.getRightNode();
                System.out.println(node);
            }
            node=node.getRightNode();
        }
    }
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }
}
class Node{
    private Node leftNode;
    private Node rightNode;
    private int no;
    private int leftNodeType;
    private int rightNodeType;

    public Node(int no) {
        this.no = no;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setLeftNodeType(int leftNodeType) {
        this.leftNodeType = leftNodeType;
    }

    public void setRightNodeType(int rightNodeType) {
        this.rightNodeType = rightNodeType;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public int getNo() {
        return no;
    }

    public int getLeftNodeType() {
        return leftNodeType;
    }

    public int getRightNodeType() {
        return rightNodeType;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.leftNode!=null){
            this.leftNode.preOrder();
        }
        if(this.rightNode!=null){
            this.rightNode.preOrder();
        }
    }
}
