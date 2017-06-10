package in.zollet.abhilashdas.spotspoon.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;

import in.zollet.abhilashdas.spotspoon.ui.fragment.CategoryFragment;

/**
 * Created by abhilashdas on 09/06/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        String title = (String) getPageTitle(position);
        switch (position){
            case 0:
                return   CategoryFragment.newInstance("video");
            case 1:
                return  CategoryFragment.newInstance("music");
            case 2:
                return  CategoryFragment.newInstance("Milestone");

            default:
                return new CategoryFragment();
        }

    }




    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Video";
                break;
            case 1:
                title="Music";
                break;
            case 2:
                title="MileStone";
                break;
        }

        return title;
    }
}