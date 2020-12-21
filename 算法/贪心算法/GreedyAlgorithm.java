package 算法.贪心算法;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author 风淡了伤
 * @create 2020-10-21-17:02
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //存放所有电台与与之对应的覆盖范围
        HashMap<String, HashSet<String>> broadCast = new HashMap<>();
        //电台1对应的覆盖范围
        HashSet<String> hashSet1=new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        //电台2对应的覆盖范围
        HashSet<String> hashSet2=new HashSet<>();
        hashSet2.add("杭州");
        hashSet2.add("广州");
        //电台3对应的覆盖范围
        HashSet<String> hashSet3=new HashSet<>();
        hashSet3.add("北京");
        hashSet3.add("深圳");
        //电台4对应的覆盖范围
        HashSet<String> hashSet4=new HashSet<>();
        hashSet4.add("东莞");
        hashSet4.add("苏州");
        hashSet4.add("杭州");
        broadCast.put("K1",hashSet1);
        broadCast.put("K2",hashSet2);
        broadCast.put("K3",hashSet3);
        broadCast.put("K4",hashSet4);
        //存放所有需要覆盖的地区
        HashSet<String> allAreas=new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("杭州");
        allAreas.add("苏州");
        //定义存放我们最终要选择的电台的存储列表
        List<String> select=new ArrayList<>();
        //定义一个临时列表，用来存储某个电台所覆盖的地区和我们所要求覆盖地区的交集
        HashSet<String> areaTemp=new HashSet<>();
        //定义一个maxKey来存储每轮电台遍历时所覆盖地区最多的那个key
        String maxKey=null;
        while (allAreas.size()!=0){
            maxKey=null;
            for(String key:broadCast.keySet()){
                areaTemp.clear();
                //定义一个存储当前这个key所对应的地区
                HashSet<String> area=broadCast.get(key);
                areaTemp.addAll(area);
                areaTemp.retainAll(allAreas);
                /*
               如果这个areaTemp的数量不为0且(当前的maxkey还没选择或者之前选择了，但之前选择的key所对应的
               地区数没有现在的多，则maxkey选择当前的电台
               这里就是贪心算法的关键，就是每次都是选择最优的
                */
                if(areaTemp.size()>0&&(maxKey==null||areaTemp.size()>broadCast.get(maxKey).size())){
                    maxKey=key;
                }
            }
            if(maxKey!=null){
                select.add(maxKey);
                allAreas.removeAll(broadCast.get(maxKey));
            }
        }
        System.out.println("最终选择的结果"+select.toString());




    }
}
