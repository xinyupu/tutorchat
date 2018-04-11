package com.pxy.tutor.main.mine.application;

import com.pxy.pangjiao.mvp.presenter.IPresenter;

/**
 * Created by Administrator on 2018/3/17.
 */

public interface ITutorPresent extends IPresenter {
    void getTutors(int page, String city);

}
