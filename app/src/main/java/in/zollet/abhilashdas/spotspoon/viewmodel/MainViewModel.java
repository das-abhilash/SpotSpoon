package in.zollet.abhilashdas.spotspoon.viewmodel;

import android.app.FragmentManager;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.List;

import in.zollet.abhilashdas.spotspoon.R;
import in.zollet.abhilashdas.spotspoon.configuration.RecyclerConfiguration;
import in.zollet.abhilashdas.spotspoon.configuration.ViewPagerConfiguration;
import in.zollet.abhilashdas.spotspoon.model.ListItem;
import in.zollet.abhilashdas.spotspoon.ui.adapter.LayoutProvider;
import in.zollet.abhilashdas.spotspoon.ui.adapter.SingleLayoutAdapter;
import in.zollet.abhilashdas.spotspoon.ui.adapter.ViewPagerAdapter;
import in.zollet.abhilashdas.spotspoon.ui.adapter.ViewPagerList;
import in.zollet.abhilashdas.spotspoon.ui.adapter.ViewPagerMap;

/**
 * Created by abhilashdas on 09/06/17.
 */

public class MainViewModel extends BaseViewModel implements MainViewModelContract.ViewModel {

    private MainViewModelContract.View viewCallback;
    FragmentManager fragmentManager;
    ViewPagerAdapter adapter;
    public ViewPagerConfiguration viewPagerConfiguration = new ViewPagerConfiguration();
    public ViewPagerConfiguration bottomViewPagerConfiguration = new ViewPagerConfiguration();
    private RecyclerConfiguration recyclerConfiguration = new RecyclerConfiguration();
    public ObservableField<LayoutProvider> topViewpagerLayoutProvider = new ObservableField<>();
    public ViewPagerList topCollectionViewPagerList = new ViewPagerList(topViewpagerLayoutProvider,this);

    public ObservableField<LayoutProvider> bottomViewpagerLayoutProvider = new ObservableField<>();
    public ViewPagerList bottomCollectionViewPagerList = new ViewPagerList(bottomViewpagerLayoutProvider,this);
    public MainViewModel(){
        setDummyDataTopViewPager();
        setDummyDataBottomViewPager();
    }

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewStarted(@NonNull LifeCycle.View viewCallback) {
        this.viewCallback = (MainViewModelContract.View) viewCallback;
        initRecycler();


    }

    public RecyclerConfiguration getConfig(){
        return recyclerConfiguration;
    }
    private void initRecycler() {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(viewCallback.getActivityContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerConfiguration.setLayoutManager(layoutManager);
        recyclerConfiguration.setItemAnimator(new DefaultItemAnimator());
        recyclerConfiguration.setAdapter(new SingleLayoutAdapter(R.layout.adapter_recylerview,this));
    }

    private void setDummyDataBottomViewPager() {
        bottomCollectionViewPagerList.add(new ViewPagerMap(R.layout.adapter_bottom_viewpager,"Video","Video" ));
        bottomCollectionViewPagerList.add(new ViewPagerMap(R.layout.adapter_bottom_viewpager,"Image","Image" ));
        bottomCollectionViewPagerList.add(new ViewPagerMap(R.layout.adapter_bottom_viewpager,"MileStone","MileStone" ));
    }

    private void setDummyDataTopViewPager() {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0)
                topCollectionViewPagerList.add(new ViewPagerMap(R.layout.adapter_top_viewpager, "http://s3.amazonaws.com/NRNArt/Michael-Buble--To-Be-Loved-album-cover.jpg"));
            else {
                topCollectionViewPagerList.add(new ViewPagerMap(R.layout.adapter_top_viewpager, "https://upload.wikimedia.org/wikipedia/en/b/b5/Nas-gods-son-music-album.jpg"));
            }
        }
    }

    @Override
    public void onViewStopped() {

    }

    @Override
    public void onDestroy() {

    }


    public List<ListItem> getList(String category){
        return getArrayList(category);
    }

    private List<ListItem> getArrayList(String category){

        List<ListItem> itemList = new ArrayList<>();
        itemList.add(new ListItem("Song1 - " + category , "12 hrs ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry","http://s3.amazonaws.com/NRNArt/Michael-Buble--To-Be-Loved-album-cover.jpg"));
        itemList.add(new ListItem("Song2 - " + category, "11 hrs ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry","https://upload.wikimedia.org/wikipedia/en/b/b5/Nas-gods-son-music-album.jpg"));
        itemList.add(new ListItem("Song3 - " + category, "1 hrs ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry","http://s3.amazonaws.com/NRNArt/Michael-Buble--To-Be-Loved-album-cover.jpg"));
        itemList.add(new ListItem("Song4- " + category, "14 hrs ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry","https://upload.wikimedia.org/wikipedia/en/b/b5/Nas-gods-son-music-album.jpg"));
        itemList.add(new ListItem("Song5- " + category, "13 hrs ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry","http://s3.amazonaws.com/NRNArt/Michael-Buble--To-Be-Loved-album-cover.jpg"));
        itemList.add(new ListItem("Song6- " + category, "2 hrs ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry","https://upload.wikimedia.org/wikipedia/en/b/b5/Nas-gods-son-music-album.jpg"));
        itemList.add(new ListItem("Song7- " + category, "7 hrs ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry","http://s3.amazonaws.com/NRNArt/Michael-Buble--To-Be-Loved-album-cover.jpg"));
        return itemList;
    }

    public void onItemClicked(View view, ListItem item){
        Toast.makeText(view.getContext(), "Item is Clicked - " + item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
