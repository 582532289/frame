package com.frame.baese;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xuning on 17/3/2.
 */
public abstract class BaeseActivity<V extends IBaeseView, P extends IBaeseP<V>> extends
        AppCompatActivity implements IBaeseBind<V, P> {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createP();
    }

    @NonNull
    @Override
    public P getP() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.releaseView();
        super.onDestroy();
    }
}

