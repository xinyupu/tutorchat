package com.pxy.tutor.main.mine.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.netease.nim.demo.R;
import com.pxy.pangjiao.databus.DataBus;
import com.pxy.tutor.main.mine.adapter.protocol.gettutors.GetTutorsResponse;
import com.pxy.tutor.main.mine.ui.utils.GlideCircleTransform;

import java.util.List;


/**
 * Created by pxy on 2018/3/31.
 */

public class TutorRecyclerViewAdapter extends RecyclerView.Adapter {


    private Activity activity;
    private List<GetTutorsResponse.DataBean> dataBeans;

    public TutorRecyclerViewAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_tutor_item, parent, false);
        return new TutorViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TutorViewHolder) {
            ((TutorViewHolder) holder).tvTutorName.setText(dataBeans.get(position).getName());
            ((TutorViewHolder) holder).tvTutorAddress.setText(dataBeans.get(position).getAddress());
            String headUrl = dataBeans.get(position).getHeadUrl();
            if (TextUtils.isEmpty(headUrl)){
                Resources res = activity.getResources();
                Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.default_head);
                ((TutorViewHolder) holder).imgImageHead.setImageBitmap(bmp);
            }
            else {
            Glide.with(activity).load(headUrl).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(activity)))
                        .into(((TutorViewHolder) holder).imgImageHead);
            }

            ((TutorViewHolder) holder).btnSeeDetail.setTag(position);
            ((TutorViewHolder) holder).btnSeeDetail.setOnClickListener(see_Click);
        }
    }


    public void setDataBeans(List<GetTutorsResponse.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }

    private View.OnClickListener see_Click = (view) -> {
        int position = (int) view.getTag();
        DataBus.getDefault().postStick(dataBeans.get(position));
        //activity.startActivity(new Intent(activity, TutorDetailActivity.class));
    };

    @Override
    public int getItemCount() {
        return this.dataBeans == null ? 0 : dataBeans.size();
    }

    public static class TutorViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTutorName;
        public TextView tvTutorAddress;
        public ImageView imgImageHead;
        public Button btnSeeDetail;

        public TutorViewHolder(View itemView) {
            super(itemView);
           /* tvTutorName = itemView.findViewById(R.id.item_tutor_name);
            tvTutorAddress = itemView.findViewById(R.id.item_tutor_address);
            imgImageHead = itemView.findViewById(R.id.tutor_head);
            btnSeeDetail = itemView.findViewById(R.id.see_detail);*/
        }
    }
}
