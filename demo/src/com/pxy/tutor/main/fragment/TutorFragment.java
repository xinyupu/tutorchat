package com.pxy.tutor.main.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.netease.nim.demo.R;
import com.pxy.pangjiao.PangJiao;
import com.pxy.pangjiao.compiler.injectview.annotation.InitView;
import com.pxy.pangjiao.compiler.mpv.annotation.AutowireProxy;
import com.pxy.pangjiao.compiler.mpv.annotation.Views;
import com.pxy.pangjiao.mvp.viewmodel.views.PJFragment;
import com.pxy.tutor.main.activity.MainActivity;
import com.pxy.tutor.main.fragment.MainTabFragment;
import com.pxy.tutor.main.mine.adapter.protocol.gettutors.GetTutorsResponse;
import com.pxy.tutor.main.mine.application.IPublicView;
import com.pxy.tutor.main.mine.application.ITutorPresent;
import com.pxy.tutor.main.mine.ui.adapter.TutorRecyclerViewAdapter;


/**
 * Created by Administrator on 2018/3/29.
 */

@Views
public class TutorFragment extends MainTabFragment implements IPublicView {

    @InitView(id = R.id.recycler_view)
    public RecyclerView recyclerView;

    @InitView(id = R.id.no_data)
    public TextView tvNoData;

    @AutowireProxy
    public ITutorPresent tutorPresent;

    private TutorRecyclerViewAdapter adapter;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onCurrent();
        PangJiao.register(this);
        PangJiao.inject(getActivity().findViewById(R.id.tutor_fragment_root_view),this);
        initData();
    }


    protected void initData() {
        adapter = new TutorRecyclerViewAdapter(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        //tutorPresent.getTutors(0, ((MainActivity) getActivity()).currentCity);
    }

    @Override
    public void refresh(Object o) {
        if (o instanceof GetTutorsResponse) {
            tvNoData.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setDataBeans(((GetTutorsResponse) o).getData());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String s) {

    }

    public void onSelectCity(String city) {
        tutorPresent.getTutors(0, city);
    }

    @Override
    public void clearData() {
        recyclerView.setVisibility(View.GONE);
        tvNoData.setVisibility(View.VISIBLE);
        adapter.setDataBeans(null);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onInit() {

    }
}
