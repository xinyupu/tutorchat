package com.pxy.tutor.main.mine.application.imp;

import com.pxy.pangjiao.compiler.mpv.annotation.Autowire;
import com.pxy.pangjiao.compiler.mpv.annotation.Presenter;
import com.pxy.tutor.main.mine.adapter.protocol.gettutors.GetTutorsResponse;
import com.pxy.tutor.main.mine.application.IPublicView;
import com.pxy.tutor.main.mine.application.ITutorPresent;
import com.pxy.tutor.main.mine.service.IAppService;


/**
 * Created by Administrator on 2018/3/17.
 */

@Presenter
public class TouristService implements ITutorPresent {


    @Autowire
    public IAppService appService;

    private IPublicView view;

    @Override
    public void build(Object view) {
        this.view = (IPublicView) view;
    }


    @Override
    public void onDestroy() {
        this.view = null;
    }


    @Override
    public void getTutors(int page, String city) {
        GetTutorsResponse response = appService.getTutors(city, page);
        if (response.isSuccess()) {
            view.refresh(response);
        }
        else {
            view.showToast(response.getMsg());
            view.clearData();
        }
    }
}
