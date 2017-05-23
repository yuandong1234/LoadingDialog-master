package com.example.dongyuan.loadingdialog.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.widget.ImageView;

import com.example.dongyuan.loadingdialog.R;

/**
 * 通过一组图片顺序播放的帧动画
 * Created by dong.yuan on 2017/5/23.
 */

public class FrameLoadingDialog extends Dialog {

    private ImageView progressImg;
    //帧动画
    private AnimationDrawable animation;

    public FrameLoadingDialog(@NonNull Context context) {
        this(context, R.style.LoadingDialog);
    }

    public FrameLoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame_anim_dialog);
        setCanceledOnTouchOutside(false);
        progressImg = (ImageView) findViewById(R.id.refreshing_drawable_img);
        animation = (AnimationDrawable) progressImg.getDrawable();
    }

    @Override
    protected void onStart() {
        super.onStart();
        animation.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        animation.stop();
    }
}
