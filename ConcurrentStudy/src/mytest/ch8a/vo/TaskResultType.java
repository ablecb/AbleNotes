package mytest.ch8a.vo;

/**
 * 方法本身运行是否是正确的结果类型
 */
public enum TaskResultType {
    Success,Failture,Exception;
    //方法返回了业务人员需要的结果
    //方法返回了业务人员不需要的结果
    //方法执行抛出了Exception
}
