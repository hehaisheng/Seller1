package com.example.pc_.seller.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pc_.seller.R;
import com.example.pc_.seller.model.AddGoodsItem;

import java.util.List;

/**
 * Created by pc- on 2017/8/18.
 */
public class AddAdapter extends BaseQuickAdapter<AddGoodsItem> {
    public AddAdapter(int layoutResId, List<AddGoodsItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, AddGoodsItem addGoodsItem) {
        baseViewHolder.setText(R.id.add_list_goods_name,addGoodsItem.getGoodsType());

    }
}
