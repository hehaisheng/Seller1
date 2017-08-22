package com.example.pc_.seller.view.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pc_.seller.R;
import com.example.pc_.seller.database.OrderModel;
import com.example.pc_.seller.utils.AutoSplit;

import java.util.List;

/**
 * Created by pc- on 2017/8/15.
 */
public class OrderAdapter extends BaseQuickAdapter<OrderModel> {

    public static final int REQUEST_PHONE_CODE = 20;

    public Context context;

    public OrderAdapter(int layoutResId, List<OrderModel> data) {
        super(layoutResId, data);
    }


    public OrderAdapter(Context context, int layoutResId, List<OrderModel> data) {
        this(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderModel orderModel) {
        baseViewHolder.setText(R.id.order_detail_text, AutoSplit.autoSplit(orderModel.getOrderContent()))
                .setText(R.id.order_time_text, orderModel.getOrderTime());


        baseViewHolder.getView(R.id.order_send_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        baseViewHolder.getView(R.id.order_send_success_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
