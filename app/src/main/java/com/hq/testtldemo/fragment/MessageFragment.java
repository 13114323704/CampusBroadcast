package com.hq.testtldemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.hq.testtldemo.R;

import java.util.ArrayList;

/**
 * Created by 黄庆 on 2017/7/2.
 */

public class MessageFragment extends Fragment{

    private View main_view,view_message_public, view_message_private;
    private PullRefreshLayout pullRefreshLayout_message_public,pullRefreshLayout_message_private;
    private Handler handler = new Handler();

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<View> viewContainter = new ArrayList<View>();
    private ArrayList<String> titleContainer = new ArrayList<String>();
    private PagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main_view=inflater.inflate(R.layout.fragment_message,null);

        initData();
        initView();
        initListener();

        return main_view;
    }

    private void initData(){
        view_message_public = LayoutInflater.from(getActivity()).inflate(R.layout.message_public_layout, null);
        view_message_private = LayoutInflater.from(getActivity()).inflate(R.layout.message_private_layout, null);

        viewContainter.clear();
        titleContainer.clear();

        viewContainter.add(view_message_public);
        viewContainter.add(view_message_private);

        titleContainer.add("系统消息");
        titleContainer.add("秘密私信");
    }

    private void initView(){
        viewPager = (ViewPager)main_view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) main_view.findViewById(R.id.tablayout);
        adapter = new PagerAdapter() {
            // viewpager中的组件数量
            @Override
            public int getCount() {
                return viewContainter.size();
            }

            // 滑动切换的时候销毁当前的组件
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewContainter.get(position));
            }

            // 每次滑动的时候生成的组件
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewContainter.get(position));
                return viewContainter.get(position);
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getItemPosition(Object object) {

                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {

                return titleContainer.get(position);
            }

        };

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        pullRefreshLayout_message_public=(PullRefreshLayout)view_message_public.findViewById(R.id.pullRefreshLayout_message_public);
        pullRefreshLayout_message_private=(PullRefreshLayout)view_message_private.findViewById(R.id.pullRefreshLayout_message_private);
    }

    private void initListener(){

        pullRefreshLayout_message_public.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_message_public.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        pullRefreshLayout_message_private.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_message_private.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
    }
}
