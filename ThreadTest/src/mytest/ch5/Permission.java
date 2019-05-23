package mytest.ch5;



/**
 * @ClassName Permission
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/23 12:19
 * @Version 1.0
 */
public class Permission {
    public static final int Allow_SELECT =1<<0;
    public static final int Allow_INSERT =1<<1;
    public static final int Allow_UPDATE =1<<2;
    public static final int Allow_DELETE =1<<3;
    private int flag;
    //设置用户的权限
    public void setPer(int per){
        flag=per;
    }
    //增加用户的权限
    public void enable(int per){
        flag=flag|per;
    }
    //删除用户的权限
    public void disable(int per){
        flag=flag&per;
    }
    //判断用户的权限
    public boolean isAllow(int per){
        return (flag&per)==per;
    }
    //判断用户没有的权限
    public boolean isNotAllow(int per){
        return (flag&per)==0;
    }

    public static void main(String[] args) {
        int flag=15;
        Permission permission=new Permission();
        permission.setPer(flag);
        permission.disable(Allow_DELETE|Allow_INSERT);
        System.out.println("Select ="+permission.isAllow(Allow_SELECT));
        System.out.println("Update ="+permission.isAllow(Allow_UPDATE));
        System.out.println("Insert ="+permission.isAllow(Allow_INSERT));
        System.out.println("Delete ="+permission.isAllow(Allow_DELETE));
    }
}
