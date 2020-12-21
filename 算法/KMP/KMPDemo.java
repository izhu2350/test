package 算法.KMP;

/**
 * @author 风淡了伤
 * @create 2020-10-20-16:57
 */
public class KMPDemo {
    public static void main(String[] args) {
        String s="ABCDBBEEAADDCC";
        String s1="BBEEAA";
        int[] next=preNext(s1);
//        for (int i = 0; i <next.length ; i++) {
//            System.out.println(next[i]);
//        }
        int i=KMPSearch(s,s1,next);
        System.out.println(i);
    }
    public static int KMPSearch(String s1,String s2,int[] next){
        for (int i = 0,len=0; i <s1.length() ; i++) {
            while (len>0&&s1.charAt(i)!=s2.charAt(len)){
                len=next[len-1];
            }
            if(s1.charAt(i)==s2.charAt(len)){
                len++;
            }
            if(len==s2.length()) {
                return i - len + 1;
            }
        }
        return -1;
    }
    /*
    *获取一个字符串(子串)的部分匹配表
    * */
    public static int[] preNext(String str){
        int len=0;//
        int[] next=new int[str.length()];
        next[0]=0;
        for (int i = 1; i <str.length() ; i++) {
            while (len>0&&str.charAt(i)!=str.charAt(len)){
                len=next[len-1];
            }
            if(str.charAt(i)==str.charAt(len)){
                len++;
            }
            next[i]=len;
        }
        return next;
    }
}
