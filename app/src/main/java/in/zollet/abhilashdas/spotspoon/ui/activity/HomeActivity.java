package in.zollet.abhilashdas.spotspoon.ui.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.zollet.abhilashdas.spotspoon.R;
import in.zollet.abhilashdas.spotspoon.databinding.ActivityHomeBinding;
import in.zollet.abhilashdas.spotspoon.ui.fragment.BaseActivity;
import in.zollet.abhilashdas.spotspoon.viewmodel.LifeCycle;
import in.zollet.abhilashdas.spotspoon.viewmodel.MainViewModel;
import in.zollet.abhilashdas.spotspoon.viewmodel.MainViewModelContract;

public class HomeActivity extends BaseActivity implements MainViewModelContract.View {

    MainViewModel model = new MainViewModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);
        activityMainBinding.setModel(model);
        activityMainBinding.tabLayout.setupWithViewPager(activityMainBinding.viewpagerBottom);
    }


    @Override
    public LifeCycle.ViewModel getViewModel() {
        return model;
    }


    @Override
    public void onBackPress() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public Context getActivityContext() {
        return null;
    }

    @Override
    public void showError(Throwable t) {

    }
}
