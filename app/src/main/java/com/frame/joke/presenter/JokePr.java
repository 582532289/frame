package com.frame.joke.presenter;

import android.os.Handler;
import android.os.Message;

import com.frame.baese.IBaeseP;
import com.frame.joke.model.JokeBean;
import com.frame.joke.model.JokeModel;
import com.frame.joke.view.IView;

import java.util.List;

/**
 * Created by xuning on 17/3/2.
 */
public class JokePr implements IBaeseP<IView>, IJokeP {

    private IView mView;
    private JokeModel mModel;

    public JokePr(IView view) {
        bindView(view);
        mModel = new JokeModel(this);
    }


    @Override
    public void bindView(IView view) {
        this.mView = view;
    }

    @Override
    public void releaseView() {
        this.mView = null;
    }

    @Override
    public void showData(List<JokeBean> list) {
        mView.dismiss();
        mView.showData(list);
    }

    @Override
    public void showEmpty() {
        mView.dismiss();
        mView.showEmpty();
    }

    public void loadJoke(String page) {
        mView.showLoading();
        Message message = new Message();
        message.what = 200;
        message.obj = page;
        handler.sendMessageDelayed(message,3000);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 200) {
                String page = (String) msg.obj;
                mModel.loadJoke(page);
            }
        }
    };
}
