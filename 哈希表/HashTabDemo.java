package 哈希表;
import java.util.Scanner;

/**
 * @author 风淡了伤
 * @create 2020-09-25-13:48
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab=new HashTab(10);
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add:添加链表");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            System.out.println("findById:找员工信息");
            key=scanner.next();
            int id=scanner.nextInt();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    System.out.println("输入名字");
                    String name=scanner.next();
                    //创建雇员
                    Emp emp=new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "findById":
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        this.id=id;
        this.name=name;
    }
}

class HashTab{
    private EmpList[] empLists;
    private int size;
    //构造器
    public HashTab(int size){
        this.size=size;
        empLists=new EmpList[size];
        for (int i = 0; i <size ; i++) {
            empLists[i]=new EmpList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        int empLinkedListNO=hashFun(emp.id);
        empLists[empLinkedListNO].add(emp);
    }
    public int hashFun(int id){
        return id%size;
    }
    //遍历哈希表
    public void list(){
        for (int i = 0; i <size ; i++) {
            empLists[i].list();
        }
    }
    //根据id找哈希表中的员工，找到对应的链表后再在该链表中找相应的雇员
    public Emp findEmpById(int id){
        int empHashNum=hashFun(id);
        return empLists[empHashNum].findEmpById(id);
    }

}
class EmpList{
    //头指针，执行第一个EMP，因此我们这个链表的head是直接指向第一个EMP
    private Emp head;
    /*
    * 添加雇员到链表
    * 假定，当添加雇员时，是按id自增长的，故直接添加到相应链表末尾即可
    * */
    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null){
                curEmp.next=emp;
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }
    public void list(){
        if(head==null){
            return;
        }
        System.out.println("当前链表的信息为———》");
        Emp curEmp=head;
        while (true){
            System.out.printf("=》id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
    }
    public Emp findEmpById(int id){
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.id==id){
               break;
            }
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }

}
