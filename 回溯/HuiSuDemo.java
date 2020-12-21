package 回溯;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 风淡了伤
 * @create 2020-10-09-19:22
 */
public class HuiSuDemo {
   public static void main(String[] args) {
      Combinations combinations=new Combinations();
      String digits="012";
      List<String> list=combinations.combination(digits);
//      Iterator<String> iterator = list.iterator();
      System.out.println(list);
   }
}
class Combinations{
   List<String>list=new ArrayList<String>();
   String[] letterMap={"abc","def","ghi"};
   public void findCombination(String digits,int index,String s){
      if(index==digits.length()){
         System.out.println(s);
         list.add(s);
         return;
      }
      char c=digits.charAt(index);
      String letter=letterMap[c-'0'];
      for (int i = 0; i <letter.length() ; i++) {
         System.out.println("index"+index+"c="+c+",s="+s+",letter[i]="+letter.charAt(i));
         findCombination(digits,index+1,s+letter.charAt(i));
      }
   }
   public List<String> combination(String digit){
      if(digit==null){
         return list;
      }
      findCombination(digit,0,"");
      return list;
   }
}
