package com.example.dongyuan.loadingdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.dongyuan.loadingdialog.util.ScreenUtils;
import com.example.dongyuan.loadingdialog.widget.CustomLoadingDialog;
import com.example.dongyuan.loadingdialog.widget.CustomLoadingView;
import com.example.dongyuan.loadingdialog.widget.FrameLoadingDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLoadingDialog dialog1;
    private CustomLoadingDialog dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (dialog1 == null) {
                    dialog1 = new FrameLoadingDialog(this);
                }
                if (!dialog1.isShowing()) {
                    dialog1.show();
                }
                break;
            case R.id.button2:
                if (dialog2 == null) {
                    dialog2 = new CustomLoadingDialog(this);
                }
                if (!dialog2.isShowing()) {
                    dialog2.showDialog();
                }else{
                    dialog2.dismissDialog();
                }
                break;
            case R.id.button3:
                createProgressDialog();
                break;
        }
    }


    private void createProgressDialog() {
        FrameLayout rootContainer = (FrameLayout) findViewById(android.R.id.content);
        RelativeLayout dialogContent = (RelativeLayout) rootContainer.findViewById(R.id.dialog_content);
        if (dialogContent == null) {
            // 设置对其方式为：屏幕居中对其
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                    ScreenUtils.getScreenWidth(this) / 3,
                    ScreenUtils.getScreenWidth(this) / 4);
            lp.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;
            View view = View.inflate(this, R.layout.layout_loading_dialog, null);
            view.setLayoutParams(lp);
            rootContainer.addView(view);
        }
        if (dialogContent != null) {
            if (dialogContent.getVisibility() == View.VISIBLE) {
                dialogContent.setVisibility(View.INVISIBLE);
            } else {
                dialogContent.setVisibility(View.VISIBLE);
            }
        }
    }

}
