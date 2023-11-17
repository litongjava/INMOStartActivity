package com.litongjava.android.inmo.startactivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.litongjava.android.inmo.startactivity.model.ActivityModel;
import com.litongjava.android.view.inject.annotation.FindViewById;
import com.litongjava.android.view.inject.annotation.FindViewByIdLayout;
import com.litongjava.android.view.inject.utils.ViewInjectUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@FindViewByIdLayout(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @FindViewById(R.id.defaultLinearLayout)
  private LinearLayout defaultLinearLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ViewInjectUtils.injectActivity(this, this);
    //setContentView(R.layout.activity_main);
    //获取viewGroup
//    LayoutInflater layoutInflater = LayoutInflater.from(this);
//    View view = layoutInflater.inflate(R.layout.activity_main, null);
//    ViewGroup viewGroup = (ViewGroup) view;

    //初始化视图
    List<View> childVews = initView();
    //initView(viewGroup);
    //添加button到ViewGroup
    for (View childVew : childVews) {
//      viewGroup.addView(childVew);
      defaultLinearLayout.addView(childVew);
    }
    //绑定ViewGroup到Activity
//    setContentView(viewGroup);

  }

  private List<View> initView() {
    List<ActivityModel> activityNameList = ActivityModels.getActivityNames();
    String packageName = getPackageName();
    log.info("packageName:{}", packageName);

    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
      ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    List<View> childVews = new ArrayList<>();
    //创建Button,并添加到Activity
    for (final ActivityModel activityModel : activityNameList) {
      String activityName = activityModel.getActivityName();
      log.info("generate button:{}", activityName);
      //初始化Button
      Button button = new Button(this);
      button.setText(activityName);
      button.setLayoutParams(params);
      childVews.add(button);
      //添加启动Activity的代码
      button.setOnClickListener((v) -> {
        log.info("start Activity:{}", activityName);
        String pckageName = activityModel.getPckageName();
        Intent intent = new Intent();
        //ComponentName component = new ComponentName("com.android.music", "com.android.music.MediaPlaybackActivity");
//        ComponentName component = new ComponentName("com.android.soundrecorder", "com.sprd.soundrecorder.RecorderActivity");
//        intent.setComponent(component);

        ComponentName cn = new ComponentName(pckageName, activityName);
        intent.setComponent(cn);
        try {
          startActivity(intent);
        } catch (Exception e) {
          Toast.makeText(this, "启动失败:" + activityName, Toast.LENGTH_SHORT).show();
          e.printStackTrace();
        }

      });
    }
    return childVews;
  }
}