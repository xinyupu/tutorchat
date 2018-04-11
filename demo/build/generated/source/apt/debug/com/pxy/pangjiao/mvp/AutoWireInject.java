package com.pxy.pangjiao.mvp;

import com.pxy.pangjiao.mvp.ioccontainer.BeanConfig;
import com.pxy.pangjiao.mvp.ioccontainer.ViewConfig;
import com.pxy.tutor.main.mine.application.imp.TouristService;
import com.pxy.tutor.main.mine.application.imp.UserPresent;
import com.pxy.tutor.main.mine.service.IAppService;
import com.pxy.tutor.main.mine.service.imp.AppService;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoWireInject {
  private Map<String, BeanConfig> container;

  Map<String, List> viewContainer;

  public AutoWireInject(Map<String, BeanConfig> container) {
    this.container=container;
    this.viewContainer=new HashMap<>();
  }

  public AutoWireInject getAutoWireInject() {
    return this;
  }

  public Map<String, List> autoWire() {
    List<ViewConfig> com_pxy_tutor_main_fragment_TutorFragment=new ArrayList<>();
    com_pxy_tutor_main_fragment_TutorFragment.add(new ViewConfig("tutorPresent","com.pxy.tutor.main.mine.application.imp.TouristService"));
    this.viewContainer.put("com.pxy.tutor.main.fragment.TutorFragment",com_pxy_tutor_main_fragment_TutorFragment);
    TouristService touristService=(TouristService)container.get("com.pxy.tutor.main.mine.application.imp.TouristService").getObject();
    touristService.appService=(AppService)container.get("com.pxy.tutor.main.mine.service.imp.AppService").getObject();
    UserPresent userPresent=(UserPresent)container.get("com.pxy.tutor.main.mine.application.imp.UserPresent").getObject();
    userPresent.appService=(AppService)container.get("com.pxy.tutor.main.mine.service.imp.AppService").getObject();
    return this.viewContainer;
  }

  public Object autoWireFactory(Object o) {
    String className=o.getClass().getName();
    if(o.getClass().getName().equals("com.pxy.tutor.main.mine.application.imp.TouristService")) {
      ((TouristService)o).appService=(IAppService)container.get("com.pxy.tutor.main.mine.service.imp.AppService").getObject();
    }
    if(o.getClass().getName().equals("com.pxy.tutor.main.mine.application.imp.UserPresent")) {
      ((UserPresent)o).appService=(IAppService)container.get("com.pxy.tutor.main.mine.service.imp.AppService").getObject();
    }
    return o;
  }
}
