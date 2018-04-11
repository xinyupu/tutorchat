package com.pxy.tutor.main.mine.ui.fragment;



import com.netease.nim.demo.R;
import com.pxy.pangjiao.mvp.viewmodel.views.PJFragment;


/**
 * Created by Administrator on 2018/3/29.
 */

public class StudentFragment extends PJFragment {


    @Override
    protected int initView() {
        return R.layout.layout_fragment_student;
    }

    @Override
    protected void initData() {

    }

    public void onSelectCity(String city) {
       // tutorPresent.getTutors(0, city);
    }
}
