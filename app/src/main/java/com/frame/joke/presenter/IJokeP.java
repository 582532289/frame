package com.frame.joke.presenter;

import com.frame.joke.model.JokeBean;

import java.util.List;

/**
 * Created by xuning on 17/3/2.
 */
public interface IJokeP {

    /** 显示数据 */
    void showData(List<JokeBean> list);

    /** 提示无数据 */
    void showEmpty();
}
