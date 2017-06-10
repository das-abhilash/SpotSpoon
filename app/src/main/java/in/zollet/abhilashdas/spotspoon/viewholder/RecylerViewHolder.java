package in.zollet.abhilashdas.spotspoon.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


import in.zollet.abhilashdas.spotspoon.ui.adapter.BaseRecyclerAdapter;
import in.zollet.abhilashdas.spotspoon.viewmodel.BaseViewModel;

import in.zollet.abhilashdas.spotspoon.BR;

/**
 * Created by abhilashdas on 12/02/17.
 */

public class RecylerViewHolder<T> extends RecyclerView.ViewHolder {

    private final ViewDataBinding mBinding;

    public RecylerViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(Object item, int position, BaseRecyclerAdapter<T> adapter, BaseViewModel viewModel) {
        mBinding.setVariable(BR.item, item);
        mBinding.setVariable(BR.position, position);
        mBinding.setVariable(BR.model, viewModel);
        mBinding.setVariable(BR.adapter, adapter);
        mBinding.executePendingBindings();
    }
}