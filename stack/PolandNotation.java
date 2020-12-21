package stack;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 风淡了伤
 * @create 2020-09-17-14:14
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression="4 5 * 8 - 60 + 8 2 / +";
        List<String> list=getlistString(suffixExpression);
        System.out.println("pstack" + list);
        int res=calculate(list);
        System.out.println(res);
    }
    //将一个逆波兰表达式先转换为list集合
    public static List<String> getlistString(String str){
        List<String> list=new ArrayList<String>();
        String[] split = str.split(" ");
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }
    //对转换为list集合的逆波兰表达式进行
    public static int calculate(List<String> list){
        Stack<String> stack=new Stack<>();
        for(String item:list){
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")) {
                    res=num1/num2;
                }else {
                    throw new RuntimeException("参数不对");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}