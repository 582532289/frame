package com.frame.joke.model;

import android.text.TextUtils;

import com.frame.baese.BaeseModel;
import com.frame.joke.presenter.IJokeP;
import com.frame.net.NetUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

        NetUtils.loadJoke(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<Back>() {
                    @Override
                    public void call(Back back) {
                        if (back == null || back.getResult() == null
                                || back.getResult().getData() == null
                                || back.getResult().getData().size() <= 0) {
                            mIPresenter.showEmpty();
                        } else {
                            mIPresenter.showData(back.getResult().getData());
                        }
                    }
                });

    }
}
