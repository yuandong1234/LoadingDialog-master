package com.example.dongyuan.loadingdialog.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dong.yuan on 2017/5/23.
 */

public class CustomLoadingView extends View {

    private float scale;    //像素密度
    private float height;     //控件高度
    private float width;       //控件宽度
    private float CIRCLE_R; //球半径
    private float CIRCLE_SPACE;//球间距
    private float CIRCLE_R1;    //球1半径
    private float CIRCLE_R2;    //球2半径
    private float CIRCLE_R3;    //球3半径
    private boolean CIRCLE_R1_STATE = true;    //球1状态，true缩小false增大
    private boolean CIRCLE_R2_STATE = true;    //球2状态，true缩小false增大
    private boolean CIRCLE_R3_STATE = true;    //球3状态，true缩小false增大

    public CustomLoadingView(Context context) {
      this(context,null);
    }

    public CustomLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        scale = context.getResources().getDisplayMetrics().density;       //获得像素密度
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        CIRCLE_R = width /20;
        float temp = CIRCLE_R / 6;
        CIRCLE_R1 = CIRCLE_R;
        CIRCLE_R2 = CIRCLE_R - temp;
        CIRCLE_R3 = CIRCLE_R - 2 * temp;
        CIRCLE_SPACE = 1 * scale;
        height=CIRCLE_R*6;
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), (int)height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(CIRCLE_R);
        paint.setStyle(Paint.Style.FILL);
        //画三个圆
        //第一个
       // canvas.drawColor(Color.parseColor("#88000000"));
        canvas.drawCircle(width / 2 - 2 * CIRCLE_R - CIRCLE_SPACE,
                height / 2,
                CIRCLE_R1,
                paint
        );
        if (CIRCLE_R1_STATE) {
            CIRCLE_R1 = CIRCLE_R1 - 0.5f;
            if (CIRCLE_R1 <= CIRCLE_R / 2) {
                CIRCLE_R1_STATE = false;
            }
        } else {
            CIRCLE_R1 = CIRCLE_R1 + 0.5f;
            if (CIRCLE_R1 >= CIRCLE_R) {
                CIRCLE_R1_STATE = true;
            }
        }
        //第二个
        canvas.drawCircle(width / 2,
                height / 2,
                CIRCLE_R2,
                paint
        );
        if (CIRCLE_R2_STATE) {
            CIRCLE_R2 = CIRCLE_R2 - 0.5f;
            if (CIRCLE_R2 <= CIRCLE_R / 2) {
                CIRCLE_R2_STATE = false;
            }
        } else {
            CIRCLE_R2 = CIRCLE_R2 + 0.5f;
            if (CIRCLE_R2 >= CIRCLE_R) {
                CIRCLE_R2_STATE = true;
            }
        }
        //第三个
        canvas.drawCircle(width / 2 + 2 * CIRCLE_R + CIRCLE_SPACE,
                height / 2,
                CIRCLE_R3,
                paint
        );
        if (CIRCLE_R3_STATE) {
            CIRCLE_R3 = CIRCLE_R3 - 0.5f;
            if (CIRCLE_R3 <= CIRCLE_R / 2) {
                CIRCLE_R3_STATE = false;
            }
        } else {
            CIRCLE_R3 = CIRCLE_R3 + 0.5f;
            if (CIRCLE_R3 >= CIRCLE_R) {
                CIRCLE_R3_STATE = true;
            }
        }
        postInvalidateDelayed(5);
    }

}