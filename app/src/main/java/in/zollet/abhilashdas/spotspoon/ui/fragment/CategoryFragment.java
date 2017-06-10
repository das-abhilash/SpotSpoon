package in.zollet.abhilashdas.spotspoon.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.zollet.abhilashdas.spotspoon.R;
import in.zollet.abhilashdas.spotspoon.databinding.FragmentCategoryBinding;
import in.zollet.abhilashdas.spotspoon.utility.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    public String categoryType;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance(String type) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCategoryBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false);
        View view = binding.getRoot();

        if (getArguments() != null && getArguments().getString(Constants.TYPE) != null) {
            categoryType = getArguments().getString(Constants.TYPE);
        }

        return view;
    }


}
