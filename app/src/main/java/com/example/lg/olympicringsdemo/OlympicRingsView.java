package com.example.lg.olympicringsdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ligen on 2017/6/5.
 */

public class OlympicRingsView extends View {

    private Context mContext;
    private float viewWidth;
    private float viewHeight;
    private float mSpace; //圆环之间的间距
    private float mStroke; //圆环宽度
    private float mRadius; //圆环半径
    private PointF o1; //第一个圆环的圆心坐标
    private PointF o2; //第二个圆环的圆心坐标
    private PointF o3; //第三个圆环的圆心坐标
    private PointF o4; //第四个圆环的圆心坐标
    private PointF o5; //第五个圆环的圆心坐标
    private RectF r1;  //第一个圆环的矩形区域
    private RectF r2;  //第二个圆环的矩形区域
    private RectF r3;  //第三个圆环的矩形区域
    private RectF r4;  //第四个圆环的矩形区域
    private RectF r5;  //第五个圆环的矩形区域
    private Paint p1;
    private Paint p2;
    private Paint p3;
    private Paint p4;
    private Paint p5;

    public OlympicRingsView(Context context) {
        this(context,null);
    }

    public OlympicRingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.OlympicRingsView, 0, 0);
        mRadius = typedArray.getDimension(R.styleable.OlympicRingsView_ringRadius,96);
        mStroke = mRadius / 6;
        mSpace = mStroke * 2;
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initVariable();
        canvas.drawArc(r1,45,316,false,p1);
        canvas.drawArc(r4,0,271,false,p4);
        canvas.drawArc(r1,0,46,false,p1);
        canvas.drawArc(r4,315,46,false,p4);
        canvas.drawArc(r2,45,316,false,p2);
        canvas.drawArc(r4,270,46,false,p4);
        canvas.drawArc(r5,315,316,false,p5);
        canvas.drawArc(r2,0,46,false,p2);
        canvas.drawArc(r3,0,360,false,p3);
        canvas.drawArc(r5,270,46,false,p5);
    }

    private void initVariable() {
        float xCenter = getMeasuredWidth()/2;
        float yCenter = getMeasuredHeight()/2;
        o1 = new PointF(xCenter-(2*mRadius+mSpace),yCenter-(mRadius+mSpace/2)/2);
        o2 = new PointF(xCenter,yCenter-(mRadius+mSpace/2)/2);
        o3 = new PointF(xCenter+(2*mRadius+mSpace),yCenter-(mRadius+mSpace/2)/2);
        o4 = new PointF(xCenter-(mRadius+mSpace/2),yCenter+(mRadius+mSpace/2)/2);
        o5 = new PointF(xCenter+(mRadius+mSpace/2),yCenter+(mRadius+mSpace/2)/2);

        r1 = new RectF(o1.x - mRadius,o1.y - mRadius,o1.x + mRadius,o1.y + mRadius);
        r2 = new RectF(o2.x - mRadius,o2.y - mRadius,o2.x + mRadius,o2.y + mRadius);
        r3 = new RectF(o3.x - mRadius,o3.y - mRadius,o3.x + mRadius,o3.y + mRadius);
        r4 = new RectF(o4.x - mRadius,o4.y - mRadius,o4.x + mRadius,o4.y + mRadius);
        r5 = new RectF(o5.x - mRadius,o5.y - mRadius,o5.x + mRadius,o5.y + mRadius);

        p1 = getPaint(0xff006BB0);
        p2 = getPaint(0xff1D1815);
        p3 = getPaint(0xffDC2F1F);
        p4 = getPaint(0xffEFA90D);
        p5 = getPaint(0xff059341);

    }

    private Paint getPaint(int color){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mStroke);
        paint.setColor(color);
        return paint;
    }

}
