package com.frame.joke.view;

import com.frame.baese.IBaeseView;
import com.frame.joke.model.JokeBean;

import java.util.List;

/**
 * Created by xuning on 17/3/2.
 */

public interface IView extends IBaeseView {

    /** 显示数据 */
    void showData(List<JokeBean> list);

    /** 无数据 */
    void showEmpty();
}
