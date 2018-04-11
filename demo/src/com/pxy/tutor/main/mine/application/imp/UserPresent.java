package com.pxy.tutor.main.mine.application.imp;

import com.pxy.pangjiao.compiler.mpv.annotation.Autowire;
import com.pxy.pangjiao.compiler.mpv.annotation.Presenter;
import com.pxy.tutor.main.mine.adapter.protocol.studentlogin.StudentLoginResponse;
import com.pxy.tutor.main.mine.adapter.protocol.studentregister.StudentRegisterResponse;
import com.pxy.tutor.main.mine.adapter.protocol.tutorlogin.TutorRegisterResponse;
import com.pxy.tutor.main.mine.adapter.protocol.tutorregister.TutorLoginResponse;
import com.pxy.tutor.main.mine.application.IUserPresent;
import com.pxy.tutor.main.mine.application.IUserView;
import com.pxy.tutor.main.mine.service.IAppService;


/**
 * Created by pxy on 2018/4/1.
 */

@Presenter(singleton = false)
public class UserPresent implements IUserPresent {

    @Autowire
    public IAppService appService;

    private IUserView view;

    @Override
    public void loginStudent(String no, String pwd) {
        StudentLoginResponse response = appService.studentLogin(no, pwd);
        if (response.isSuccess()) {
            view.loginSuccess(response.getData());

        } else {
            view.showToast(response.getMsg());
        }

    }

    @Override
    public void registerStudent(String no, String pwd, String name, String area) {
        StudentRegisterResponse response = appService.studentRegister(no, pwd, name, area);
        if (response.isSuccess()) {
            view.showToast("注册成功");
            view.registerSuccess(response.getData());

        } else {
            view.showToast(response.getMsg());
        }
    }

    @Override
    public void loginTutor(String no, String pwd) {
        TutorLoginResponse response = appService.tutorLogin(no, pwd);
        if (response.isSuccess()) {
            view.loginSuccess(response.getData());

        } else {
            view.showToast(response.getMsg());
        }

    }

    @Override
    public void registerTutor(String no, String pwd, String name, String area) {
        TutorRegisterResponse response = appService.tutorRegister(no, pwd, name, area);
        if (response.isSuccess()) {
            view.showToast("注册成功");
            view.registerSuccess(response.getData());

        } else {
            view.showToast(response.getMsg());
        }
    }

    @Override
    public void build(Object o) {
        this.view = (IUserView) o;
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
