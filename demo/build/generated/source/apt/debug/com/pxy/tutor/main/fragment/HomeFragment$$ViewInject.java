package com.pxy.tutor.main.fragment;

import android.view.View;
import android.widget.TextView;
import com.pxy.pangjiao.mvp.view.IViewInject;
import com.pxy.pangjiao.mvp.view.helper.IProvider;
import java.lang.Object;
import java.lang.Override;

public class HomeFragment$$ViewInject implements IViewInject<HomeFragment> {
  @Override
  public void inject(final HomeFragment host, Object o, IProvider provider) {
    host.tvCurrentCity=(TextView)provider.findView(o,2131755198);
    ((View)provider.findView(o,2131755198)).setOnClickListener(host.tv_Click);
  }
}
