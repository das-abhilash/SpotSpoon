package in.zollet.abhilashdas.spotspoon.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by abhilashdas on 09/06/17.
 */

public interface LifeCycle {

    interface View{
        Context getActivityContext();
        void showProgress();
        void hideProgress();
        void showError(Exception e);
        void showError(Throwable t);
    }

    interface ViewModel{
        void onViewResumed();
        void onViewStarted(@NonNull LifeCycle.View viewCallback);
        void onViewStopped();
        void onDestroy();
    }

}