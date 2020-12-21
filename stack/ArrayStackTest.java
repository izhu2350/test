package stack;

/**
 * @author 风淡了伤
 * @create 2020-09-15-18:50
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(4);
        stack.pushStack(5);
        stack.pushStack(5);
        stack.pushStack(8);
        stack.pushStack(10);
        stack.showStack();
        stack.popStack();
        System.out.println("*****************");
        stack.showStack();
    }
}
class ArrayStack{
    //定义栈的结构
    private int top=-1;
    private int[] arr;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
    }
    //判读栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //入栈操作
    public void pushStack(int value){
        //判断是否栈满
        if(isFull()){
            throw new RuntimeException("栈满了，进不来");
        }
        arr[++top]=value;
    }
    //出栈操作
    public int popStack(){
        //判断是否栈满
        if(isEmpty()){
            throw new RuntimeException("栈满了");
        }
        int value= arr[top];
        top--;
        return value;
    }
    public void showStack(){
        if(isEmpty()){
            System.out.println("栈已经空了");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d",i,arr[i]);
        }
    }
}

