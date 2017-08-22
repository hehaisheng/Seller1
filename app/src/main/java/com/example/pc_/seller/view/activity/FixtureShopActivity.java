package com.example.pc_.seller.view.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc_.seller.R;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/22.
 */
public class FixtureShopActivity extends BaseActivity {


    @BindView(R.id.fixture_name)
    TextView fixtureName;
    @BindView(R.id.fixture_name_edit)
    EditText fixtureNameEdit;
    @BindView(R.id.fixture_name_cut)
    TextView fixtureNameCut;
    @BindView(R.id.fixture_name_type1)
    TextView fixtureNameType1;
    @BindView(R.id.fixture_name_type)
    TextView fixtureNameType;
    @BindView(R.id.fixture_name_type_button)
    Button fixtureNameTypeButton;
    @BindView(R.id.fixture_name_cut3)
    TextView fixtureNameCut3;
    @BindView(R.id.fixture_post_image)
    TextView fixturePostImage;
    @BindView(R.id.fixture_name_cut4)
    TextView fixtureNameCut4;
    @BindView(R.id.fixture_shop_name)
    ImageView fixtureShopName;
    @BindView(R.id.fixture_name_button)
    Button fixtureNameButton;
    @BindView(R.id.add_recycler)
    RecyclerView addRecycler;

    @Override
    public int getLayout() {
        return R.layout.shop_activity;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }


}
