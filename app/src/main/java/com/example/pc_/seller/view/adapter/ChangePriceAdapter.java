package com.example.pc_.seller.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pc_.seller.R;
import com.example.pc_.seller.database.ChangePriceModel;
import com.example.pc_.seller.database.LiteOrmManager;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pc- on 2017/8/16.
 */
public class ChangePriceAdapter extends BaseQuickAdapter<ChangePriceModel> {


    public Context context;
    public LiteOrmManager liteOrmManager;
    public List<ChangePriceModel>  newPriceModels=new ArrayList<>();
    public ChangePriceAdapter(int layoutResId, List<ChangePriceModel> data) {
        super(layoutResId, data);
    }

    public ChangePriceAdapter(Context context, int layoutResId, List<ChangePriceModel> data) {
        this(layoutResId, data);
        this.context=context;
        this.liteOrmManager=LiteOrmManager.newInstance(context);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final ChangePriceModel changePriceModel) {



        baseViewHolder.setText(R.id.change_price_text,"价格"+changePriceModel.getGoodsPrice()+"/斤")
                .setText(R.id.change_sell_text,"销量"+changePriceModel.getGoodsSell()+"/月")
                .setText(R.id.change_goods_name,changePriceModel.getGoodsName());

        //第一个界面
        baseViewHolder.getView(R.id.change_goods_price_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText= baseViewHolder.getView(R.id.change_edit);
                String priceStr=editText.getText().toString();
                if(priceStr.length()>0){
                    changePriceModel.setGoodsPrice(Integer.valueOf(priceStr));
                    baseViewHolder.setText(R.id.change_price_text,"价格"+priceStr+"/斤");
                    liteOrmManager.update(changePriceModel,2);
                }else{
                    iChangePriceInterface.dialog();
                }
                //int newPrice=priceModel.getGoodsPrice()-1;

            }
        });

    }
    public IChangePriceInterface iChangePriceInterface;
    public void setIChangePriceInterface(IChangePriceInterface iChangePriceInterface){
        this.iChangePriceInterface=iChangePriceInterface;
    }
    public interface  IChangePriceInterface{
        void  dialog();
    }
}
