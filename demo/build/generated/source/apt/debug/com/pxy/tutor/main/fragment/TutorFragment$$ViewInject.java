package com.pxy.tutor.main.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.pxy.pangjiao.mvp.view.IViewInject;
import com.pxy.pangjiao.mvp.view.helper.IProvider;
import java.lang.Object;
import java.lang.Override;

public class TutorFragment$$ViewInject implements IViewInject<TutorFragment> {
  @Override
  public void inject(final TutorFragment host, Object o, IProvider provider) {
    host.recyclerView=(RecyclerView)provider.findView(o,2131755279);
    host.tvNoData=(TextView)provider.findView(o,2131755635);
  }
}
