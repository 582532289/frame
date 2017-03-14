package com.frame.joke.model;

import android.text.TextUtils;
import android.util.Log;

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

//        NetUtils.loadJoke(page)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Action1<Back>() {
//                    @Override
//                    public void call(Back back) {
//                        if (back == null || back.getResult() == null
//                                || back.getResult().getData() == null
//                                || back.getResult().getData().size() <= 0) {
//                            mIPresenter.showEmpty();
//                        } else {
//                            mIPresenter.showData(back.getResult().getData());
//                        }
//                    }
//                });

        Subscriber subscriber = new Subscriber<Back>() {
            @Override
            public void onCompleted() {
                Log.e("", "加载完毕");
            }

            @Override
            public void onError(Throwable e) {
                mIPresenter.showEmpty();
            }

            @Override
            public void onNext(Back movieEntity) {
                Log.e("data", movieEntity.toString());
            }
        };

        Map<String, String> map = new HashMap<>();
        map.put("key", "e5919ae4d8f9288fdede67e4ed4634df");
        map.put("sort", "desc");
        map.put("page", page);
        map.put("time", "1418816972");
        map.put("pagesize", "20");
        HttpMethods.getInstance().getTopMovie(subscriber, map);


    }
}
