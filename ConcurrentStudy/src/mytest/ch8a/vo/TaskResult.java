package mytest.ch8a.vo;

import java.util.Random;

/**
 * @ClassName TaskResult
 * @Description 任务处理返回的结果实体类
 * @Author 曹博
 * @Date 2019/5/28 19:49
 * @Version 1.0
 */
public class TaskResult<R> {
    private final TaskResultType resultType;
    private final R returnValue;//方法的业务结果数据
    private final String reason;//方法失败的原因

    public TaskResult(TaskResultType resultType, R returnValue, String reason) {
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = reason;
    }
    public TaskResult(TaskResultType resultType, R returnValue) {
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = "Success";
    }

    public TaskResultType getResultType() {
        return resultType;
    }

    public R getReturnValue() {
        return returnValue;
    }

    public String getReason() {
        return reason;
    }
}
