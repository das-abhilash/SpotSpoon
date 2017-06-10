package in.zollet.abhilashdas.spotspoon.viewmodel;

import java.util.List;

/**
 * Created by abhilashdas on 09/06/17.
 */

public interface MainViewModelContract {

    interface View extends LifeCycle.View{
        void onBackPress();
        void onFinish();
    }

    interface ViewModel extends LifeCycle.ViewModel{
    }
}
