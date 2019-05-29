package mytest.ch8a.vo;

public interface ITaskProcesser<T,R> {
    TaskResult<R > taskExecute(T data);
}
