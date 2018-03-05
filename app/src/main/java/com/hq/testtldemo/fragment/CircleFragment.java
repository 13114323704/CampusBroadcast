package com.hq.testtldemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.hq.testtldemo.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 黄庆 on 2017/7/2.
 */

public class CircleFragment extends Fragment{

    private View main_view;
    private ImageView imageView_qrcode;

    private PullRefreshLayout pullRefreshLayout_circle;
    //用于处理下拉刷新事件
    private Handler pullRefresh_handler = new Handler();

    //图片轮播相关控件
    private ViewPager mViewPaper;
    private List<ImageView> images;
    // 存放图片的id
    private int[] imageIds = new int[]{R.mipmap.a, R.mipmap.b,
            R.mipmap.c, R.mipmap.d, R.mipmap.e};
    private List<View> dots;
    private int currentItem;
    // 记录上一次点的位置
    private int oldPosition = 0;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    //接收子线程传递过来的数据,用于处理图片轮播事件
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        }

        ;
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main_view=inflater.inflate(R.layout.fragment_circle,null);
        initData();
        initView();
        initListener();
        return main_view;
    }

    private void initData() {

        // 显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }

        // 显示的小点
        dots = new ArrayList<View>();
        dots.add(main_view.findViewById(R.id.dot_0));
        dots.add(main_view.findViewById(R.id.dot_1));
        dots.add(main_view.findViewById(R.id.dot_2));
        dots.add(main_view.findViewById(R.id.dot_3));
        dots.add(main_view.findViewById(R.id.dot_4));
    }

    private void initView() {
        imageView_qrcode=(ImageView)main_view.findViewById(R.id.image_qrcode);
        pullRefreshLayout_circle=(PullRefreshLayout)main_view.findViewById(R.id.pullRefreshLayout_circle);

        mViewPaper = (ViewPager) main_view.findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);
    }

    private void initListener(){
        imageView_qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), CaptureActivity.class);
                startActivity(intent);
            }
        });
        pullRefreshLayout_circle.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefresh_handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefreshLayout_circle.setRefreshing(false);
                        Toast.makeText(getActivity(), "刷新完成啦", Toast.LENGTH_SHORT).show();
                    }
                },2000);
            }
        });

        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                dots.get(position).setBackgroundResource(
                        R.drawable.dot_focused);
                dots.get(oldPosition).setBackgroundResource(
                        R.drawable.dot_normal);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    //利用线程池定时执行动画轮播
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(), 3,
                3, TimeUnit.SECONDS);
    }

    @Override
    public void onStop() {
        super.onStop();
        scheduledExecutorService.shutdown();
    }

    private class ViewPageTask implements Runnable {

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
            // super.destroyItem(container, position, object);
            // view.removeView(view.getChildAt(position));
            // view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }
}
