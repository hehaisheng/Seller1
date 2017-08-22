package com.example.pc_.seller.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.pc_.seller.R;
import com.example.pc_.seller.database.ChangePriceModel;
import com.example.pc_.seller.database.LiteOrmManager;
import com.example.pc_.seller.view.adapter.ChangePriceAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/16.
 */
public class ChangePriceActivity extends BaseActivity {


    @BindView(R.id.change_recycler)
    RecyclerView changeRecycler;

    public ChangePriceAdapter changePriceAdapter;
    public LiteOrmManager liteOrmManager;

    public List<ChangePriceModel> changePriceModels=new ArrayList<>();



    @Override
    public int getLayout() {
        return R.layout.change_activity;
    }

    @Override
    public void initView() {

        changeRecycler.setLayoutManager(new LinearLayoutManager(this));
        liteOrmManager=LiteOrmManager.newInstance(this);
        changePriceModels=liteOrmManager.getQueryAll(ChangePriceModel.class);
        if(changePriceModels.size()==0||changePriceModels==null){
            for (int i=0;i<10;i++){

                ChangePriceModel priceModel2= new ChangePriceModel();
                priceModel2.setGoodsPrice(13);
                priceModel2.setGoodsName("猪肉");
                priceModel2.setGoodsSell(122);
                changePriceModels.add(priceModel2);
                liteOrmManager.save(priceModel2,2);

            }

        }
        changePriceAdapter=new ChangePriceAdapter(this,R.layout.change_item,changePriceModels);
        changeRecycler.setAdapter(changePriceAdapter);
        changePriceAdapter.setIChangePriceInterface(new ChangePriceAdapter.IChangePriceInterface() {
            @Override
            public void dialog() {
                Toast.makeText(ChangePriceActivity.this,"请填写正确的价格",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }


}
