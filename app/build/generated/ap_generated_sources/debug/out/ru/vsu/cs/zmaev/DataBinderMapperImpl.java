package ru.vsu.cs.zmaev;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ru.vsu.cs.zmaev.databinding.ActivityMainBindingImpl;
import ru.vsu.cs.zmaev.databinding.FragmentGameBindingImpl;
import ru.vsu.cs.zmaev.databinding.FragmentGameResultBindingImpl;
import ru.vsu.cs.zmaev.databinding.FragmentTitleBindingImpl;
import ru.vsu.cs.zmaev.databinding.FragmentUserEditProfileBindingImpl;
import ru.vsu.cs.zmaev.databinding.FragmentUserProfileBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTGAME = 2;

  private static final int LAYOUT_FRAGMENTGAMERESULT = 3;

  private static final int LAYOUT_FRAGMENTTITLE = 4;

  private static final int LAYOUT_FRAGMENTUSEREDITPROFILE = 5;

  private static final int LAYOUT_FRAGMENTUSERPROFILE = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(ru.vsu.cs.zmaev.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ru.vsu.cs.zmaev.R.layout.fragment_game, LAYOUT_FRAGMENTGAME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ru.vsu.cs.zmaev.R.layout.fragment_game_result, LAYOUT_FRAGMENTGAMERESULT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ru.vsu.cs.zmaev.R.layout.fragment_title, LAYOUT_FRAGMENTTITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ru.vsu.cs.zmaev.R.layout.fragment_user_edit_profile, LAYOUT_FRAGMENTUSEREDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(ru.vsu.cs.zmaev.R.layout.fragment_user_profile, LAYOUT_FRAGMENTUSERPROFILE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAME: {
          if ("layout/fragment_game_0".equals(tag)) {
            return new FragmentGameBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_game is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGAMERESULT: {
          if ("layout/fragment_game_result_0".equals(tag)) {
            return new FragmentGameResultBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_game_result is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTITLE: {
          if ("layout/fragment_title_0".equals(tag)) {
            return new FragmentTitleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_title is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTUSEREDITPROFILE: {
          if ("layout/fragment_user_edit_profile_0".equals(tag)) {
            return new FragmentUserEditProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_user_edit_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTUSERPROFILE: {
          if ("layout/fragment_user_profile_0".equals(tag)) {
            return new FragmentUserProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_user_profile is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "game");
      sKeys.put(2, "user");
      sKeys.put(3, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_main_0", ru.vsu.cs.zmaev.R.layout.activity_main);
      sKeys.put("layout/fragment_game_0", ru.vsu.cs.zmaev.R.layout.fragment_game);
      sKeys.put("layout/fragment_game_result_0", ru.vsu.cs.zmaev.R.layout.fragment_game_result);
      sKeys.put("layout/fragment_title_0", ru.vsu.cs.zmaev.R.layout.fragment_title);
      sKeys.put("layout/fragment_user_edit_profile_0", ru.vsu.cs.zmaev.R.layout.fragment_user_edit_profile);
      sKeys.put("layout/fragment_user_profile_0", ru.vsu.cs.zmaev.R.layout.fragment_user_profile);
    }
  }
}
