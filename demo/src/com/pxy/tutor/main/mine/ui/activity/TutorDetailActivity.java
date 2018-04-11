package com.pxy.tutor.main.mine.ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.netease.nim.demo.R;
import com.pxy.pangjiao.compiler.injectview.annotation.InitView;
import com.pxy.pangjiao.compiler.injectview.annotation.OnClick;
import com.pxy.pangjiao.databus.DataBus;
import com.pxy.pangjiao.databus.DataEvent;
import com.pxy.pangjiao.mvp.viewmodel.views.PJAppCompatActivity;
import com.pxy.tutor.main.mine.adapter.protocol.gettutors.GetTutorsResponse;
import com.pxy.tutor.main.mine.ui.utils.GlideCircleTransform;


/**
 * Created by pxy on 2018/3/31.
 */

public class TutorDetailActivity extends PJAppCompatActivity {

    @InitView(id = R.id.tutor_head)
    public ImageView imgHead;

    @InitView(id = R.id.tv_name)
    public TextView tvName;

    @InitView(id = R.id.tv_xue_li)
    public TextView tvXueLi;

    @InitView(id = R.id.tutor_zi_wo)
    public TextView tvTutorZiWo;

    @InitView(id = R.id.tutor_no)
    public TextView tvTutorNo;

    @InitView(id = R.id.tutor_address)
    public TextView tvAdress;

    @InitView(id = R.id.can_teach)
    public TextView tvCanTeach;


    @InitView(id = R.id.toolbar)
    public Toolbar toolbar;


    private String no;
    private String name;
    private boolean isTutor;

    @Override
    public int initView() {
        return R.layout.activity_tutor_detail;
    }

    @Override
    public void initData() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(v -> TutorDetailActivity.this.finish());
        DataBus.getDefault().register(this);
    }

    @OnClick(R.id.btn_go_to_chat)
    public View.OnClickListener chat_Click = view -> {

    };


    @DataEvent
    public void onEvent(Object o) {
        if (o instanceof GetTutorsResponse.DataBean) {
            String nameO = ((GetTutorsResponse.DataBean) o).getName();
            if (nameO.length() >= 3) {
                this.name = ((GetTutorsResponse.DataBean) o).getName().substring(0, 3);
            }
            no = ((GetTutorsResponse.DataBean) o).getTutorNO();
            isTutor = true;
            String headUrl = ((GetTutorsResponse.DataBean) o).getHeadUrl();
            if (TextUtils.isEmpty(headUrl)) {
                Resources res = getResources();
                Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.default_head);
                imgHead.setImageBitmap(bmp);
            } else {
                Glide.with(this).load(headUrl).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(this)))
                        .into(imgHead);
            }
            tvName.setText(((GetTutorsResponse.DataBean) o).getName());
            tvXueLi.setText(((GetTutorsResponse.DataBean) o).getEducation());
            tvTutorZiWo.setText(((GetTutorsResponse.DataBean) o).getDescTeach());
            tvTutorNo.setText(((GetTutorsResponse.DataBean) o).getTutorNO());
            tvAdress.setText(((GetTutorsResponse.DataBean) o).getAddress());
            tvCanTeach.setText(((GetTutorsResponse.DataBean) o).getCanTeach());
        }
    }
}
