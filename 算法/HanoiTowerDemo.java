package 算法;

/**
 * @author 风淡了伤
 * @create 2020-10-17-10:49
 */
public class HanoiTowerDemo {
    public static void main(String[] args) {
        HanoiTower htower=new HanoiTower();
        htower.hanoiTower(64,'A','B','C');
    }
}
class HanoiTower{
    public void hanoiTower(int nums,char a,char b,char c){
        if(nums==1){
            System.out.println("第1个盘从"+a+"-->"+c);
        }else{
            hanoiTower(nums-1,a,c,b);
            System.out.println("第"+nums+"个盘从"+a+"-->"+c);
            hanoiTower(nums-1,b,a,c);
        }
    }
}
