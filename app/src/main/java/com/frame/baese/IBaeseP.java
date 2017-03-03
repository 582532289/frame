package com.frame.baese;

/**
 * Created by xuning on 17/3/2.
 */
public interface IBaeseP<V extends IBaeseView> {

    /**
     * 绑定接口
     */
    void bindView(V view);

    /**
     * 释放接口
     */
    void releaseView();

}
