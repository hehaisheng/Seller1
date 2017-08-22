package com.example.pc_.seller.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc_.seller.R;
import com.example.pc_.seller.view.activity.AddActivity;
import com.example.pc_.seller.view.activity.ChangePriceActivity;
import com.example.pc_.seller.view.activity.FixtureShopActivity;
import com.example.pc_.seller.view.activity.OrderDetailActivity;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/13.
 */
public class SelfFragment extends BaseFragment implements View.OnClickListener{


    @BindView(R.id.seller_judge_mark)
    TextView sellerJudgeMark;
    @BindView(R.id.seller_judge_middle)
    Button sellerJudgeMiddle;
    @BindView(R.id.seller_judge_middle_text)
    TextView sellerJudgeMiddleText;
    @BindView(R.id.seller_judge_two_text)
    TextView sellerJudgeTwoText;
    @BindView(R.id.seller_judge_one_text)
    TextView sellerJudgeOneText;
    @BindView(R.id.seller_judge_four_text)
    TextView sellerJudgeFourText;
    @BindView(R.id.seller_judge_five_text)
    TextView sellerJudgeFiveText;
    @BindView(R.id.seller_judge_two)
    Button sellerJudgeTwo;
    @BindView(R.id.seller_judge_one)
    Button sellerJudgeOne;
    @BindView(R.id.seller_judge_four)
    Button sellerJudgeFour;
    @BindView(R.id.seller_judge_five)
    Button sellerJudgeFive;
    @BindView(R.id.seller_today_text)
    TextView sellerTodayText;
    @BindView(R.id.seller_today_count_text)
    TextView sellerTodayCountText;
    @BindView(R.id.seller_mouth_text)
    TextView sellerMouthText;
    @BindView(R.id.seller_mouth_count_text)
    TextView sellerMouthCountText;
    @BindView(R.id.seller_detail_text)
    TextView sellerDetailText;
    @BindView(R.id.seller_quit_text)
    TextView sellerQuitText;
    @BindView(R.id.seller_ever_text)
    TextView sellerEverText;
    @BindView(R.id.seller_self_text)
    TextView sellerSelfText;
    @BindView(R.id.seller_add_text)
    TextView sellerAddText;
    @BindView(R.id.seller_fixture_text)
    TextView sellerFixtureText;



    public  MyDialogFragment myDialogFragment;

    @Override
    public void rxPreLoad() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.self_fragment;
    }

    @Override
    public void initView() {


    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

        sellerSelfText.setOnClickListener(this);
        sellerAddText.setOnClickListener(this);
        sellerDetailText.setOnClickListener(this);
        sellerEverText.setOnClickListener(this);
        sellerQuitText.setOnClickListener(this);
        sellerFixtureText.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.seller_fixture_text:
                Intent shopIntent=new Intent(getActivity(), FixtureShopActivity.class);
                startActivity(shopIntent);
                break;
            case R.id.seller_self_text:
                Intent intent=new Intent(getActivity(), ChangePriceActivity.class);
                startActivity(intent);
                break;
            case R.id.seller_add_text:
                Intent intent1=new Intent(getActivity(), AddActivity.class);
                startActivity(intent1);
                break;
            case R.id.seller_detail_text:
                Intent intent2=new Intent(getActivity(), OrderDetailActivity.class);
                startActivity(intent2);
                break;
            case R.id.seller_ever_text:
                quitOrEver(1);
                break;
            case R.id.seller_quit_text:
                quitOrEver(2);
                break;

        }
    }

    public void  quitOrEver(final int j){
        //能进入该方法，说明j位置由数据
        Bundle bundle = new Bundle();
        if(j==1){
            bundle.putString("dialogContent", "是否确定解除卖家职务");
        }else  if(j==2){
            bundle.putString("dialogContent", "是否确定退出");
        }
        myDialogFragment = MyDialogFragment.newInstance(bundle);
        myDialogFragment.show(getActivity().getFragmentManager(),"dialogFragment");

        myDialogFragment.setDialogListener(new MyDialogFragment.IDialogListener() {
            @Override
            public void confirm() {

                if(j==2){
                    SharedPreferences sharedPreferences=getActivity().getSharedPreferences("Login",0);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("HasLogin",false);
                    editor.apply();
                }else{
                   //发送信息告诉服务器，将该 商户的信息删除
                }
                myDialogFragment.dismiss();
                getActivity().finish();
            }
            @Override
            public void cancel() {

                myDialogFragment.dismiss();

            }
        });
    }
}
