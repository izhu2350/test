package 树;



/**
 * @author 风淡了伤
 * @create 2020-09-29-9:52
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode node2=new HeroNode(2,"卢俊义");
        HeroNode node3=new HeroNode(3,"鲁智深");
        HeroNode node4=new HeroNode(4,"林冲");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        binaryTree.setRoot(root);
//        binaryTree.preOrder();
//        binaryTree.postOrder();
//        HeroNode resNode=binaryTree.preOrderSearch(2);
//        System.out.println(resNode);
        binaryTree.preOrder();
        binaryTree.delNode(2);
        binaryTree.preOrder();
    }
}
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root=root;
    }
    public void preOrder(){
        if(this.root!= null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }
    public HeroNode preOrderSearch(int no){
        HeroNode resNode;
        if(root!=null){
            resNode=root.preOrederSearch(no);
        }else{
            System.out.println("二叉树为空");
            return null;
        }
        return resNode;
    }

   public HeroNode infixOrderSearch(int no){
        HeroNode resNode=null;
        if(root!=null){
            resNode=root.infixOrderSearch(no);
        }else{
            System.out.println("二叉树为空");
        }
        return resNode;
   }
   //后序查找
   public HeroNode postOrderSearch(int no){
        HeroNode resNode=null;
        if(root!=null){
            resNode=root.postNodeSearch(no);
        }else{
            System.out.println("二叉树为空");
        }
        return resNode;
   }
   //删除节点
   public void delNode(int no){
        if(root!=null){
            if(this.root.getNo()==no){
                this.root=null;
                return;
            }else{
                this.root.delNode(no);
            }
        }else{
            System.out.println("二叉树为空");
        }
   }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //后续遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序遍历查找节点
    public HeroNode preOrederSearch(int no){
        System.out.println("前序遍历");
        if(this.no==no){
            return this;
        }
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrederSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.preOrederSearch(no);
        }
        return resNode;
    }
    //中序遍历查找节点
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no==no){
            return this;
        }
        if(this.right!=null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //后续遍历查找节点
    public HeroNode postNodeSearch(int no){
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.postNodeSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.postNodeSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no==no){
            return this;
        }
        return resNode;
    }
    //删除节点
    public void delNode(int no){
        if(this.left.no==no&&this.left!=null){
            this.left=null;
            return;
        }
        if(this.right.no==no&&this.right!=null){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}
