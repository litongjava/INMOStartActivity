package com.litongjava.android.inmo.startactivity.model;

public class ActivityModel {
  private String pckageName, activityName;

  public ActivityModel(String pckageName, String activityName) {
    this.pckageName = pckageName;
    this.activityName = activityName;
  }

  public String getPckageName() {
    return pckageName;
  }

  public String getActivityName() {
    return activityName;
  }
}
