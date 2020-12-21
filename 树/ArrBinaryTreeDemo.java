package 树;

/**
 * @author 风淡了伤
 * @create 2020-10-04-18:44
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        ArrBinary arrBinary=new ArrBinary(arr);
        arrBinary.infixOrder();
        System.out.println("********");
        arrBinary.preOrder();
    }
}
class ArrBinary{
    private int[] arr;
    public ArrBinary(int[] arr){
        this.arr=arr;
    }
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void infixOrder(int index){
        if(arr.length==0||arr==null){
            System.out.println("数组为空");
        }
        if(index*2+1<arr.length){
            infixOrder(index*2+1);
        }
        System.out.println(arr[index]);
        if(index*2+2<arr.length){
            infixOrder(index*2+2);
        }
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        if(index*2+1<arr.length){
            preOrder(index*2+1);
        }
        if(index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
}
