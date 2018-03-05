package com.hq.testtldemo;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hq.testtldemo.fragment.CircleFragment;
import com.hq.testtldemo.fragment.MainFragment;
import com.hq.testtldemo.fragment.MessageFragment;
import com.hq.testtldemo.fragment.MineFragment;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FragmentManager fm=getSupportFragmentManager();
    private FragmentTransaction ft=fm.beginTransaction();
    private LinearLayout linearLayout_main,linearLayout_circle,linearLayout_message,linearLayout_mine;
    private ImageView mainpager_label,circle_label,message_label,mine_label;

    private MainFragment mainFragment=new MainFragment();
    private CircleFragment circleFragment=new CircleFragment();
    private MessageFragment messageFragment=new MessageFragment();
    private MineFragment mineFragment=new MineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //初始化界面
        ft.replace(R.id.content,mainFragment,"MainFragment");
        ft.commit();

        //实例化按钮
        linearLayout_main=(LinearLayout) this.findViewById(R.id.mainpager_linelayout);
        linearLayout_circle=(LinearLayout) this.findViewById(R.id.circle_linelayout);
        linearLayout_message=(LinearLayout)this.findViewById(R.id.message_linelayout);
        linearLayout_mine=(LinearLayout) this.findViewById(R.id.mine_linelayout);
        mainpager_label=(ImageView)this.findViewById(R.id.mainpager_label);
        circle_label=(ImageView)this.findViewById(R.id.circle_label);
        message_label=(ImageView)this.findViewById(R.id.message_label);
        mine_label=(ImageView)this.findViewById(R.id.mine_label);
        //绑定监听器
        linearLayout_main.setOnClickListener(this);
        linearLayout_circle.setOnClickListener(this);
        linearLayout_message.setOnClickListener(this);
        linearLayout_mine.setOnClickListener(this);

        freshLabel(1);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //适配6.0以上机型请求权限
        PermissionGen.with(MainActivity.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.CAMERA
                )
                .request();
    }

    //以下三个方法用于6.0以上权限申请适配
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 100)
    public void doSomething(){
        //Toast.makeText(this, "相关权限已允许", Toast.LENGTH_SHORT).show();
    }

    @PermissionFail(requestCode = 100)
    public void doFailSomething(){
        //Toast.makeText(this, "相关权限已拒绝", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        ft=fm.beginTransaction();
        switch (v.getId()){

            case R.id.mainpager_linelayout:
                if(fm.findFragmentByTag("MainFragment")!=mainFragment){
                    ft.replace(R.id.content,mainFragment,"MainFragment");
                    freshLabel(1);
                }
                break;

            case R.id.circle_linelayout:
                if(fm.findFragmentByTag("CircleFragment")!=circleFragment){
                    ft.replace(R.id.content,circleFragment,"CircleFragment");
                    freshLabel(2);
                }
                break;

            case R.id.message_linelayout:
                if(fm.findFragmentByTag("MessageFragment")!=messageFragment){
                    ft.replace(R.id.content,messageFragment,"MessageFragment");
                    freshLabel(3);
                }
                break;

            case R.id.mine_linelayout:
                if(fm.findFragmentByTag("MineFragment")!=mineFragment) {
                    ft.replace(R.id.content,mineFragment,"MineFragment");
                    freshLabel(4);
                }
                break;
        }
        ft.commit();
    }

    private void freshLabel(int position){
        switch (position){
            case 1:
                mainpager_label.setImageResource(R.mipmap.mainpager_pressed);
                circle_label.setImageResource(R.mipmap.circle_normal);
                message_label.setImageResource(R.mipmap.message_normal);
                mine_label.setImageResource(R.mipmap.mine_normal);
                break;
            case 2:
                mainpager_label.setImageResource(R.mipmap.mainpager_normal);
                circle_label.setImageResource(R.mipmap.circle_pressed);
                message_label.setImageResource(R.mipmap.message_normal);
                mine_label.setImageResource(R.mipmap.mine_normal);
                break;
            case 3:
                mainpager_label.setImageResource(R.mipmap.mainpager_normal);
                circle_label.setImageResource(R.mipmap.circle_normal);
                message_label.setImageResource(R.mipmap.message_pressed);
                mine_label.setImageResource(R.mipmap.mine_normal);
                break;
            case 4:
                mainpager_label.setImageResource(R.mipmap.mainpager_normal);
                circle_label.setImageResource(R.mipmap.circle_normal);
                message_label.setImageResource(R.mipmap.message_normal);
                mine_label.setImageResource(R.mipmap.mine_pressed);
                break;
            default:
                break;
        }
    }
}
