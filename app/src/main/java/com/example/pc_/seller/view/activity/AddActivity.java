package com.example.pc_.seller.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.pc_.seller.R;
import com.example.pc_.seller.model.AddGoodsItem;
import com.example.pc_.seller.view.adapter.AddAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/15.
 */
public class AddActivity extends BaseActivity implements View.OnClickListener{



    @BindView(R.id.add_goods_self_name_edit)
    EditText addSelfGoodsName;
    @BindView(R.id.add_goods_name)
    TextView addGoodsName;
    @BindView(R.id.add_goods_type)
    TextView addGoodsType;
    @BindView(R.id.add_goods_type_button)
    Button addGoodsTypeButton;
    @BindView(R.id. add_goods_name_button)
    Button  addGoodsNameButton;
    @BindView(R.id.add_goods_price)
    TextView addGoodsPrice;
    @BindView(R.id.add_price_edit)
    EditText addPriceEdit;
    @BindView(R.id.add_confirm_button)
    Button addConfirmButton;
    @BindView(R.id.add_recycler)
    RecyclerView addRecycler;


    public String[] goodsName=new String[]{"猪槽头肉","猪排骨","猪腰骨","猪后脚","猪后腿肉","猪后肘","猪里脊肉","前肘","臀尖肉","五花肉","猪大肠","猪肚"};
    public String[] goodsName1=new String[]{"猪耳朵","猪粉肠","猪肝","猪脾","猪前腿肉","猪舌","猪手","猪尾巴","猪心","猪血","猪腰"};
    public String[] typeName=new String[]{"肉类","蔬菜","熟食","海鲜","冻品","杂货","杂粮","果类"};
    public List<AddGoodsItem>  addGoodsItems=new ArrayList<>();
    public List<AddGoodsItem>  addTypeItems=new ArrayList<>();

    public  boolean   hasType=false;
    public  boolean   isVisibility=false;
    //0 代表类型，1代表名字
    public int type;

    public AddAdapter addAdapter;
    @Override
    public int getLayout() {
        return R.layout.add_activity;
    }

    @Override
    public void initView() {

        addRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initData() {

        for (String aGoodsName : goodsName) {
            AddGoodsItem addGoodsItem1 = new AddGoodsItem();
            addGoodsItem1.setGoodsType(aGoodsName);
            addGoodsItems.add(addGoodsItem1);
        }
        for (String aGoodsName : goodsName1) {
            AddGoodsItem addGoodsItem1 = new AddGoodsItem();
            addGoodsItem1.setGoodsType(aGoodsName);
            addGoodsItems.add(addGoodsItem1);
        }
        for(String aTypeName:typeName){
            AddGoodsItem addTypeItem=new AddGoodsItem();
            addTypeItem.setGoodsType(aTypeName);
            addTypeItems.add(addTypeItem);

        }



    }

    @Override
    public void initEvent() {

        addGoodsTypeButton.setOnClickListener(this);
        addConfirmButton.setOnClickListener(this);
        addGoodsNameButton.setOnClickListener(this);
        addRecycler.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

                if(type==0){
                    addGoodsType.setText(addTypeItems.get(i).getGoodsType());
                    hasType=true;
                }else if(type==1){
                    addGoodsName.setText(addGoodsItems.get(i).getGoodsType());
                }
                addRecycler.setVisibility(View.GONE);
                isVisibility=false;

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int y = (int) event.getY();
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int max_y = dm.heightPixels;
                if (y < max_y * 60 / 100) {
                    if (addRecycler.getVisibility() == View.VISIBLE) {
                        addRecycler.setVisibility(View.GONE);
                    }
                }
                isVisibility=false;
                break;
        }
        return super.onTouchEvent(event);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_goods_type_button:
                if(!isVisibility){
                    startVisibility(0);
                    type=0;
                }
                break;
            case R.id.add_goods_name_button:
                if(hasType&&!isVisibility){
                    startVisibility(1);
                    type=1;
                }
                break;
            case R.id.add_confirm_button:
                String selfName=addSelfGoodsName.getText().toString();
                String goodsName=addGoodsName.getText().toString();
                String goodsType=addGoodsType.getText().toString();
                String goodsPrice=addGoodsPrice.getText().toString();
                if(selfName.length()>0&&goodsName.length()>0&&goodsType.length()>0&&goodsPrice.length()>0){
                    Toast.makeText(AddActivity.this,"正在提交数据",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddActivity.this,"请认真填写数据",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void  startVisibility(int dataType){
        addRecycler.setVisibility(View.VISIBLE);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.open_play_list);
        if(dataType==0){
            addAdapter= new AddAdapter(R.layout.add_goods_item, addTypeItems);
        }else if(dataType==1){
            addAdapter= new AddAdapter(R.layout.add_goods_item, addGoodsItems);
        }

        addRecycler.setAdapter(addAdapter);
        addRecycler.setVisibility(View.VISIBLE);
        addRecycler.startAnimation(animation1);
        isVisibility=true;
    }
}
