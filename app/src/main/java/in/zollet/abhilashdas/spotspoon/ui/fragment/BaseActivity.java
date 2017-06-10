package in.zollet.abhilashdas.spotspoon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.zollet.abhilashdas.spotspoon.viewmodel.LifeCycle;


public abstract class BaseActivity extends AppCompatActivity implements LifeCycle.View {

   public static final String TAG="BaseFragment";

    public abstract LifeCycle.ViewModel getViewModel();

    @Override
    public void onResume() {
        super.onResume();
        getViewModel().onViewResumed();
    }

    @Override
    public void onStart() {
        super.onStart();
        getViewModel().onViewStarted(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getViewModel().onViewStopped();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getViewModel().onDestroy();
    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

}
