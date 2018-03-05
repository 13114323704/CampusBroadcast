package com.hq.testtldemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hq.testtldemo.BroadcastActivity;
import com.hq.testtldemo.LoveActivity;
import com.hq.testtldemo.MyRecordActivity;
import com.hq.testtldemo.R;
import com.hq.testtldemo.TakeActivity;
import com.hq.testtldemo.TaskActivity;
import com.hq.testtldemo.TrackActivity;

/**
 * Created by 黄庆 on 2017/7/2.
 */

public class MineFragment extends Fragment {
    private View main_view;
    private LinearLayout linearLayout_broadcast, linearLayout_take;
    private LinearLayout linearLayout_task, linearLayout_track;
    private RelativeLayout relativeLayout_love,relativeLayout_record;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        main_view = inflater.inflate(R.layout.fragment_mine, null);
        linearLayout_broadcast = (LinearLayout) main_view.findViewById(R.id.linearlayout_broadcast);
        linearLayout_take = (LinearLayout) main_view.findViewById(R.id.linearlayout_take);
        linearLayout_task = (LinearLayout) main_view.findViewById(R.id.linearlayout_task);
        linearLayout_track = (LinearLayout) main_view.findViewById(R.id.linearlayout_track);
        relativeLayout_love=(RelativeLayout)main_view.findViewById(R.id.relative_collect);
        relativeLayout_record=(RelativeLayout)main_view.findViewById(R.id.relative_history_played);
        linearLayout_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BroadcastActivity.class);
                startActivity(intent);
            }
        });
        linearLayout_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TakeActivity.class);
                startActivity(intent);
            }
        });
        linearLayout_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TaskActivity.class);
                startActivity(intent);
            }
        });
        linearLayout_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrackActivity.class);
                startActivity(intent);
            }
        });
        relativeLayout_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoveActivity.class);
                startActivity(intent);
            }
        });
        relativeLayout_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MyRecordActivity.class);
                startActivity(intent);
            }
        });
        return main_view;
    }
}
