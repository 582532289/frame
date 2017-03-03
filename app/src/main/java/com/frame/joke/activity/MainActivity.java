package com.frame.joke.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.frame.R;
import com.frame.baese.BaeseActivity;
import com.frame.joke.model.JokeBean;
import com.frame.joke.presenter.JokePr;
import com.frame.joke.view.IView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xuning on 17/3/2.
 */
public class MainActivity extends BaeseActivity<IView, JokePr> implements IView {

    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.nodata)
    TextView nodata;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.pb)
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        if (lv.getVisibility() == View.GONE)
            getP().loadJoke("1");
    }

    @NonNull
    @Override
    public JokePr createP() {
        return new JokePr(this);
    }

    @Override
    public void showData(List<JokeBean> list) {
        lv.setVisibility(View.VISIBLE);
        JokeAdapter adapter = new JokeAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    public void showEmpty() {
        nodata.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismiss() {
        pb.setVisibility(View.GONE);
    }
}
