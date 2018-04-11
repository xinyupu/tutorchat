package com.pxy.pangjiao.mvp;

import com.pxy.pangjiao.mvp.ioccontainer.BeanConfig;
import com.pxy.pangjiao.mvp.ioccontainer.DataEventConfig;
import com.pxy.pangjiao.mvp.ioccontainer.IContainerConfig;
import com.pxy.tutor.main.mine.application.imp.TouristService;
import com.pxy.tutor.main.mine.application.imp.UserPresent;
import com.pxy.tutor.main.mine.service.imp.AppService;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MVPDefaultContainer implements IContainerConfig {
  private static MVPDefaultContainer instance;

  private Map<String, BeanConfig> container;

  private Map<String, List> auotwireContainer;

  private Map<String, List> auotwireProxyContainer;

  private Map<String, List> dataEventContainer;

  private Map<String, List> viewContainer;

  private AutoWireInject autoWireInject;

  private MVPDefaultContainer() {
    container=new HashMap<>();
    auotwireContainer=new HashMap<>();
    auotwireProxyContainer=new HashMap<>();
    dataEventContainer=new HashMap<>();
    init();
    initAutoWire();
  }

  public static MVPDefaultContainer createInstance() {
    if(instance==null){
            synchronized (MVPDefaultContainer.class){
             if(instance==null){
                  instance=new MVPDefaultContainer();
                }
            }
        };
    return instance;
  }

  private void init() {

    container.put(AppService.class.getName(),new BeanConfig(new AppService(),true));
    container.put(TouristService.class.getName(),new BeanConfig(new TouristService(),true));
    container.put(UserPresent.class.getName(),new BeanConfig(new UserPresent(),false));
    List<DataEventConfig> com_pxy_tutor_main_mine_ui_activity_TutorDetailActivity_DataEvent=new ArrayList<>();
    com_pxy_tutor_main_mine_ui_activity_TutorDetailActivity_DataEvent.add(new DataEventConfig("com.pxy.tutor.main.mine.ui.activity.TutorDetailActivity","onEvent"));
    dataEventContainer.put("com.pxy.tutor.main.mine.ui.activity.TutorDetailActivity",com_pxy_tutor_main_mine_ui_activity_TutorDetailActivity_DataEvent);

  }

  public Map<String, BeanConfig> getClassTypeContainer() {
    return container;
  }

  public Map<String, List> initAutoWire() {
    autoWireInject=new AutoWireInject(container);
    this.viewContainer=autoWireInject.autoWire();
    return this.viewContainer;
  }

  public Map<String, List> getAutoWireContainer() {
    return auotwireContainer;
  }

  public Map<String, List> getAutoWireProxyContainer() {
    return auotwireProxyContainer;
  }

  public Map<String, List> getDataEvnetContainer() {
    return dataEventContainer;
  }

  public Map<String, List> getViewContainer() {
    return this.viewContainer;
  }

  public Object autoWireFactory(Object o) {
    return autoWireInject.autoWireFactory(o);
  }
}
