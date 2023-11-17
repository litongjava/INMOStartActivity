package com.litongjava.android.inmo.startactivity;

import com.litongjava.android.inmo.startactivity.model.ActivityModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ActivityModels {
  private static List<ActivityModel> activityNames = new ArrayList<>();

  static {
    //com.android.settings/.wifi.WifiPickerActivity
    activityNames.add(new ActivityModel("com.android.settings", "com.android.settings.wifi.WifiPickerActivity"));
    //"com.android.browser/.BrowserActivity"
    activityNames.add(new ActivityModel("com.android.browser", "com.android.browser.BrowserActivity"));
    //"com.android.music/.MediaPlaybackActivity"
    activityNames.add(new ActivityModel("com.android.music", "com.android.music.MediaPlaybackActivity"));
    //com.android.music/.MusicBrowserActivity
    activityNames.add(new ActivityModel("com.android.music", "com.android.music.MusicBrowserActivity"));
    //"com.android.soundrecorder/com.sprd.soundrecorder.RecorderActivity"
    activityNames.add(new ActivityModel("com.android.soundrecorder", "com.sprd.soundrecorder.RecorderActivity"));
    //com.sprd.engineermode/.debuglog.VersionInfoActivity
    activityNames.add(new ActivityModel("com.sprd.engineermode", "com.sprd.engineermode.debuglog.VersionInfoActivity"));
    activityNames.add(new ActivityModel("com.android.musicfx", "com.android.musicfx.ActivityMusic"));
    //com.inmo.inputmethod.pinyin/.SettingsActivity
    activityNames.add(new ActivityModel("com.inmo.inputmethod.pinyin", "com.inmo.inputmethod.pinyin.SettingsActivity"));

  }

  public static List<ActivityModel> getActivityNames() {
    return activityNames;
  }
}
