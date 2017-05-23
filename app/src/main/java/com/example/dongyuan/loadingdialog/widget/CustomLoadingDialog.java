package com.example.dongyuan.loadingdialog.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.dongyuan.loadingdialog.R;
import com.example.dongyuan.loadingdialog.util.ScreenUtils;

/**
 * Created by yuandong on 2017/5/23.
 */

public class CustomLoadingDialog extends Dialog {
    private Context mContext;

    public CustomLoadingDialog(Context context) {
        this(context, R.style.LoadingDialog);
    }

    public CustomLoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext=context;
        View view = View.inflate(context, R.layout.layout_loading_dialog, null);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                ScreenUtils.getScreenWidth(context) / 3,
                ScreenUtils.getScreenWidth(context) / 4);
        view.setLayoutParams(lp);
        setContentView(view);

    }

    public void showDialog() {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.width = ScreenUtils.getScreenWidth(mContext) / 3; //设置宽度
        lp.height = ScreenUtils.getScreenWidth(mContext) / 4; //设置高度
        this.getWindow().setAttributes(lp);
        this.setCanceledOnTouchOutside(false);
        this.show();
    }
    public void  dismissDialog(){
       if(isShowing()){
         dismiss();
       }
    }
}
