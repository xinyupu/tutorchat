package com.pxy.tutor.main.mine.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.pxy.pangjiao.mvp.view.IViewInject;
import com.pxy.pangjiao.mvp.view.helper.IProvider;
import java.lang.Object;
import java.lang.Override;

public class TutorDetailActivity$$ViewInject implements IViewInject<TutorDetailActivity> {
  @Override
  public void inject(final TutorDetailActivity host, Object o, IProvider provider) {
    host.imgHead=(ImageView)provider.findView(o,2131755199);
    host.tvName=(TextView)provider.findView(o,2131755200);
    host.tvXueLi=(TextView)provider.findView(o,2131755201);
    host.tvTutorZiWo=(TextView)provider.findView(o,2131755202);
    host.tvTutorNo=(TextView)provider.findView(o,2131755203);
    host.tvAdress=(TextView)provider.findView(o,2131755204);
    host.tvCanTeach=(TextView)provider.findView(o,2131755205);
    host.toolbar=(Toolbar)provider.findView(o,2131755178);
    ((View)provider.findView(o,2131755206)).setOnClickListener(host.chat_Click);
  }
}
