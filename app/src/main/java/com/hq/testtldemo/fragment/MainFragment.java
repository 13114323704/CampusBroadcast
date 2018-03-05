package com.hq.testtldemo.fragment;

import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.hq.testtldemo.ChannelDetailinfoActivity;
import com.hq.testtldemo.R;
import com.hq.testtldemo.SearchActivity;

import java.util.ArrayList;

/**
 * Created by 黄庆 on 2017/7/2.
 */

public class MainFragment extends Fragment implements View.OnClickListener{

    private View main_view,view_area1,view_area2,view_area3,view_area4,view_area5;
    private PullRefreshLayout pullRefreshLayout_area1,pullRefreshLayout_area2,pullRefreshLayout_area3,pullRefreshLayout_area4,pullRefreshLayout_area5;
    private Handler handler = new Handler();
    private ImageView imageView_search;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<View> viewContainter = new ArrayList<View>();
    private ArrayList<String> titleContainer = new ArrayList<String>();
    private PagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main_view=inflater.inflate(R.layout.fragment_main,container,false);

        initData();
        initView();
        initListener();

        return main_view;
    }

    private void initData(){
        viewContainter.clear();
        titleContainer.clear();

        LayoutInflater inflater=LayoutInflater.from(getActivity());
        view_area1=inflater.inflate(R.layout.fragment_main_area1,null);
        view_area2=inflater.inflate(R.layout.fragment_main_area2,null);
        view_area3=inflater.inflate(R.layout.fragment_main_area3,null);
        view_area4=inflater.inflate(R.layout.fragment_main_area4,null);
        view_area5=inflater.inflate(R.layout.fragment_main_area5,null);

        viewContainter.add(view_area5);
        viewContainter.add(view_area1);
        viewContainter.add(view_area2);
        viewContainter.add(view_area3);
        viewContainter.add(view_area4);

        titleContainer.add("综合");
        titleContainer.add("通知");
        titleContainer.add("新闻");
        titleContainer.add("音乐");
        titleContainer.add("寻物");

    }

    private void initViewArea1(){
        view_area1.findViewById(R.id.channel_playing1).setOnClickListener(this);
        view_area1.findViewById(R.id.channel_playing2).setOnClickListener(this);
        view_area1.findViewById(R.id.channel_playing3).setOnClickListener(this);
        view_area1.findViewById(R.id.channel_playing4).setOnClickListener(this);
        view_area1.findViewById(R.id.channel_history1).setOnClickListener(this);
        view_area1.findViewById(R.id.channel_history2).setOnClickListener(this);
        view_area1.findViewById(R.id.channel_history3).setOnClickListener(this);
    }

    private void initViewArea2(){
        View view1=view_area2.findViewById(R.id.channel_playing1);
        View view2=view_area2.findViewById(R.id.channel_playing2);
        View view3=view_area2.findViewById(R.id.channel_playing3);
        View view4=view_area2.findViewById(R.id.channel_playing4);
        View view5=view_area2.findViewById(R.id.channel_history1);
        View view6=view_area2.findViewById(R.id.channel_history2);
        View view7=view_area2.findViewById(R.id.channel_history3);
        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        view5.setOnClickListener(this);
        view6.setOnClickListener(this);
        view7.setOnClickListener(this);

        TextView textView1=(TextView)view1.findViewById(R.id.channel_person);
        textView1.setText("官方新闻广播");
        TextView textView2=(TextView)view2.findViewById(R.id.channel_person);
        textView2.setText("南区宿舍新闻广播");
        TextView textView3=(TextView)view3.findViewById(R.id.channel_person);
        textView3.setText("城建学院新闻广播");
        TextView textView4=(TextView)view4.findViewById(R.id.channel_person);
        textView4.setText("艺设学院新闻广播");
        TextView textView5=(TextView)view5.findViewById(R.id.channel_person);
        textView5.setText("计算机学院新闻广播");
        TextView textView6=(TextView)view6.findViewById(R.id.channel_person);
        textView6.setText("北区宿舍新闻广播");
        TextView textView7=(TextView)view7.findViewById(R.id.channel_person);
        textView7.setText("官方新闻广播");
    }

    private void initViewArea3(){
        View view1=view_area3.findViewById(R.id.channel_playing1);
        View view2=view_area3.findViewById(R.id.channel_playing2);
        View view3=view_area3.findViewById(R.id.channel_history1);
        View view4=view_area3.findViewById(R.id.channel_history2);
        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        TextView textView1=(TextView)view1.findViewById(R.id.channel_person);
        textView1.setText("官方音乐广播");
        TextView textView2=(TextView)view2.findViewById(R.id.channel_person);
        textView2.setText("图书馆音乐广播");
        TextView textView3=(TextView)view3.findViewById(R.id.channel_person);
        textView3.setText("南苑音乐广播");
        TextView textView4=(TextView)view4.findViewById(R.id.channel_person);
        textView4.setText("艺设学院音乐广播");

    }

    private void initViewArea4(){
        View view1=view_area4.findViewById(R.id.channel_playing1);
        View view2=view_area4.findViewById(R.id.channel_playing2);
        View view3=view_area4.findViewById(R.id.channel_playing3);
        View view4=view_area4.findViewById(R.id.channel_history1);
        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        TextView textView1=(TextView)view1.findViewById(R.id.channel_person);
        textView1.setText("官方寻物广播");
        TextView textView2=(TextView)view2.findViewById(R.id.channel_person);
        textView2.setText("计算机学院寻物广播");
        TextView textView3=(TextView)view3.findViewById(R.id.channel_person);
        textView3.setText("南苑寻物广播");
        TextView textView4=(TextView)view4.findViewById(R.id.channel_person);
        textView4.setText("北苑寻物广播");
    }

    private void initViewArea5(){
        View view1=view_area5.findViewById(R.id.channel_playing1);
        View view2=view_area5.findViewById(R.id.channel_playing2);
        View view3=view_area5.findViewById(R.id.channel_playing3);
        View view4=view_area5.findViewById(R.id.channel_playing4);
        View view5=view_area5.findViewById(R.id.channel_history1);
        View view6=view_area5.findViewById(R.id.channel_history2);
        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        view5.setOnClickListener(this);
        view6.setOnClickListener(this);
    }

    private void initView(){
        initViewArea1();
        initViewArea2();
        initViewArea3();
        initViewArea4();
        initViewArea5();
        imageView_search=(ImageView)main_view.findViewById(R.id.search_label);

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
        pullRefreshLayout_area1=(PullRefreshLayout)view_area1.findViewById(R.id.pullRefreshLayout_area1);
        pullRefreshLayout_area2=(PullRefreshLayout)view_area2.findViewById(R.id.pullRefreshLayout_area2);
        pullRefreshLayout_area3=(PullRefreshLayout)view_area3.findViewById(R.id.pullRefreshLayout_area3);
        pullRefreshLayout_area4=(PullRefreshLayout)view_area4.findViewById(R.id.pullRefreshLayout_area4);
        pullRefreshLayout_area5=(PullRefreshLayout)view_area5.findViewById(R.id.pullRefreshLayout_area5);
    }

    private void initListener(){
        imageView_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        pullRefreshLayout_area1.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_area1.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        pullRefreshLayout_area2.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_area2.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        pullRefreshLayout_area3.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_area3.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        pullRefreshLayout_area4.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_area4.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
        pullRefreshLayout_area5.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_area5.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.channel_playing1:
            case R.id.channel_playing2:
            case R.id.channel_playing3:
            case R.id.channel_playing4:
            case R.id.channel_history1:
            case R.id.channel_history2:
            case R.id.channel_history3:
                Intent intent=new Intent(getActivity(), ChannelDetailinfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
