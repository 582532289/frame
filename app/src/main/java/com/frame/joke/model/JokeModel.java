package com.frame.joke.model;

import android.text.TextUtils;

import com.frame.baese.BaeseModel;
import com.frame.http.HttpMethods;
import com.frame.joke.presenter.IJokeP;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;

/**
 * Created by xuning on 17/3/2.
 */
public class JokeModel extends BaeseModel<IJokeP> {

    public JokeModel(IJokeP iPresenter) {
        super(iPresenter);
    }

    public void loadJoke(String page) {
        if (TextUtils.isEmpty(page)) {
            return;
        }

        Map<String, String> map = new HashMap<>();
        map.put("key", "e5919ae4d8f9288fdede67e4ed4634df");
        map.put("sort", "desc");
        map.put("page", page);
        map.put("time", "1418816972");
        map.put("pagesize", "20");
        HttpMethods.getInstance().getJoker(map, new Subscriber<Back>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mIPresenter.showEmpty();
            }

            @Override
            public void onNext(Back back) {
                mIPresenter.showData(back.getResult().getData());
            }
        });

    }
}
