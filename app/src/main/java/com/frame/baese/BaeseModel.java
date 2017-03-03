package com.frame.baese;

/**
 * Created by xuning on 17/3/2.
 */

public abstract class BaeseModel<IP> {


    protected IP mIPresenter;

    public BaeseModel(IP iPresenter) {
        this.mIPresenter = iPresenter;
    }
}
