package com.example.swipe_face_student;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import io.opencensus.tags.Tag;

import static com.example.swipe_face_student.BackHandlerHelper.handleBackPress;



public class FragmentClassDetail extends Fragment implements FragmentBackHandler {


    private String TAG = "ClassDetail";
    private String classId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        Bundle args = new Bundle();//fragment傳值
        args = getArguments();//fragment傳值
        classId=args.getString("info");
        Log.d(TAG,"classId:" +classId);//fragment傳值
        Toast.makeText(getContext(),"現在課程代碼是"+classId,Toast.LENGTH_LONG).show();


        return inflater.inflate(R.layout.fragment_fragment_class_detail, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"classId2:"+classId);
    }

    @Override
    public boolean onBackPressed() {
        if (handleBackPress(this)) {
            //外理返回鍵
            return true;
        } else {
            // 如果不包含子Fragment
            // 或子Fragment沒有外理back需求
            // 可如直接 return false;
            // 註：如果Fragment/Activity 中可以使用ViewPager 代替 this
            //
            return handleBackPress(this);
        }
    }//fragment 返回鍵




}
