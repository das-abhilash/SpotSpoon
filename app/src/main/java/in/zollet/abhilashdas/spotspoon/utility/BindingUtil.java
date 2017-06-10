package in.zollet.abhilashdas.spotspoon.utility;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.zollet.abhilashdas.spotspoon.R;
import in.zollet.abhilashdas.spotspoon.configuration.RecyclerConfiguration;
import in.zollet.abhilashdas.spotspoon.configuration.ViewPagerConfiguration;
import in.zollet.abhilashdas.spotspoon.customview.CirclePageIndicator;
import in.zollet.abhilashdas.spotspoon.ui.adapter.BasePagerAdapter;
import in.zollet.abhilashdas.spotspoon.ui.adapter.BaseRecyclerAdapter;
import in.zollet.abhilashdas.spotspoon.ui.adapter.GenericPagerAdapter;
import in.zollet.abhilashdas.spotspoon.ui.adapter.LayoutProvider;
import in.zollet.abhilashdas.spotspoon.ui.adapter.SingleLayoutAdapter;
import in.zollet.abhilashdas.spotspoon.viewmodel.BaseViewModel;

/**
 * Created by abhilashdas on 09/06/17.
 */

public class BindingUtil {

    @BindingAdapter({"imageUrl", "errorDrawble"})
    public static void setImage(ImageView imageView, @NonNull String url, Drawable errorDrawable) {
        Glide.with(imageView.getContext()).load(url).placeholder(errorDrawable).dontAnimate()/*.fitCenter()*/.into(imageView);
    }


    @BindingAdapter("pageIndicatorConfig")
    public static void configureCirclePageIndicator(CirclePageIndicator circlePageIndicator, ViewPagerConfiguration viewPagerConfiguration) {
        if (viewPagerConfiguration == null) {
            return;
        }
        circlePageIndicator.setFillColor(viewPagerConfiguration.getCirclePagefillColor() != 0 ? viewPagerConfiguration.getCirclePagefillColor() : Color.parseColor("#FFFFFF"));
        circlePageIndicator.setPageColor(viewPagerConfiguration.getCirclepageColor() != 0 ? viewPagerConfiguration.getCirclepageColor() : Color.parseColor("#bebebe"));
        circlePageIndicator.setStrokeWidth(0.0f);
        viewPagerConfiguration.setCirclePageIndicator(circlePageIndicator);
    }

    @BindingAdapter({"layoutProvider", "viewPagerConfig"})
    public static <T> void setPagerAdapter(ViewPager viewPager, LayoutProvider layoutProvider, ViewPagerConfiguration viewPagerConfiguration) {
        setPagerAdapter(viewPager,layoutProvider,viewPagerConfiguration,null);
    }
        @BindingAdapter({"layoutProvider", "viewPagerConfig", "tabProperty"})
    public static <T> void setPagerAdapter(ViewPager viewPager, LayoutProvider layoutProvider, ViewPagerConfiguration viewPagerConfiguration, TabLayout tabLayout) {

        if (viewPagerConfiguration == null) {
            return;
        }

        viewPager.setClipToPadding(viewPagerConfiguration.isClipToPadding());
        viewPager.setPageMargin(viewPagerConfiguration.getViewPagerMargin());
        viewPager.setPadding(viewPagerConfiguration.getPaddingLeft(), viewPagerConfiguration.getPaddingTop(), viewPagerConfiguration.getPaddingRight(), viewPagerConfiguration.getPaddingBottom());
        viewPager.setOffscreenPageLimit(viewPagerConfiguration.getOffScreenpageLimit());
        if (viewPager.getAdapter() == null) {
            viewPager.setAdapter(new GenericPagerAdapter(layoutProvider));
            if (viewPagerConfiguration.getCirclePageIndicator() != null) {
                viewPagerConfiguration.getCirclePageIndicator().setViewPager(viewPager);
            }
        } else {


            BasePagerAdapter basePagerAdapter = (BasePagerAdapter) viewPager.getAdapter();
            basePagerAdapter.setLayoutProvider(layoutProvider);
            basePagerAdapter.notifyDataSetChanged();
            if (viewPagerConfiguration.getCirclePageIndicator() != null) {
                viewPagerConfiguration.getCirclePageIndicator().invalidate();
            }
        }

            if(tabLayout !=null){
                setTabProperty(tabLayout,layoutProvider);
            }
    }

    @BindingAdapter({"listItem","viewModel"})
    public static <T>void setSingeLAyoutAdapter(RecyclerView recyclerView, List<T> listItem, BaseViewModel viewModel){

        BaseRecyclerAdapter<T> baseAdapter= (BaseRecyclerAdapter<T>) recyclerView.getAdapter();
        if(baseAdapter==null){

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL,false);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new SingleLayoutAdapter(listItem, R.layout.adapter_recylerview,viewModel));
            recyclerView.addItemDecoration(new CustumDecoration());
            recyclerView.setLayoutManager(linearLayoutManager);
//            recyclerView.addItemDecoration(new DefaultItemAnimator());
        }else {

            baseAdapter.updateList(listItem);
            baseAdapter.notifyDataSetChanged();

        }


    }

    @BindingAdapter("tabProperty")
    public static void setTabProperty(TabLayout tabLayout, LayoutProvider layoutProvider) {



        for (int i = 0; i < layoutProvider.getSize(); i++) {
            if (tabLayout.getTabAt(i) != null) {


                View view = LayoutInflater.from(tabLayout.getContext()).inflate(R.layout.custom_tab, null);

                TextView tab = (TextView) view.findViewById(R.id.tab);
                ImageView icon = (ImageView) view.findViewById(R.id.tabIcon);



                switch (layoutProvider.getTitle(i)) {
                    case "Video":
                        tab.setText("Video");
                        icon.setImageResource(R.drawable.select_video_background);
                        tabLayout.getTabAt(i).setCustomView(view);
                        break;
                    case "Image":
                        tab.setText("Image");
                        icon.setImageResource(R.drawable.select_image_background);
                        tabLayout.getTabAt(i).setCustomView(view);
                        break;
                    case "MileStone":
                        tab.setText("MileStone");
                        icon.setImageResource(R.drawable.select_milestone_background);
                        tabLayout.getTabAt(i).setCustomView(view);
                        break;
                }
            }
        }
    }



}

