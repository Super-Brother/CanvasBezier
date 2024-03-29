package com.example.canvasbezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class BezierView extends View {

    private Paint mPaint, mLinePointPaint;
    private Path mPath;

    private ArrayList<PointF> mControlPoints;

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);

        mLinePointPaint = new Paint();
        mLinePointPaint.setAntiAlias(true);
        mLinePointPaint.setStrokeWidth(4);
        mLinePointPaint.setStyle(Paint.Style.STROKE);
        mLinePointPaint.setColor(Color.GRAY);

        mPath = new Path();
        mControlPoints = new ArrayList<>();

        init();
    }

    private void init() {
        mControlPoints.clear();
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int x = random.nextInt(800) + 200;
            int y = random.nextInt(800) + 200;
            PointF pointF = new PointF(x, y);
            mControlPoints.add(pointF);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = mControlPoints.size();
        PointF pointF;
        for (int i = 0; i < size; i++) {
            pointF = mControlPoints.get(i);
            if (i > 0) {
                //控制点连线
                canvas.drawLine(mControlPoints.get(i - 1).x, mControlPoints.get(i - 1).y, pointF.x,
                        pointF.y, mLinePointPaint);
            }
            //控制点
            canvas.drawCircle(pointF.x, pointF.y, 12, mLinePointPaint);
        }
        buildBezierPoints();
        canvas.drawPath(mPath, mPaint);
    }

    private ArrayList<PointF> buildBezierPoints() {
        mPath.reset();

        ArrayList<PointF> points = new ArrayList<>();
        int order = mControlPoints.size() - 1;
        float delta = 1.0f / 1000;
        for (float t = 0; t <= 1; t += delta) {
            //Bezier点集
            PointF pointF = new PointF(deCasteljauX(order, 0, t), deCasteljauY(order, 0, t));
            points.add(pointF);
            if (points.size() == 1) {
                mPath.moveTo(points.get(0).x, points.get(0).y);
            } else {
                mPath.lineTo(pointF.x, pointF.y);
            }
        }
        return points;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            init();
            invalidate();
        }
        return super.onTouchEvent(event);
    }

    private float deCasteljauY(int i, int j, float t) {
        if (i == 1) {
            return (1 - t) * mControlPoints.get(j).y + t * mControlPoints.get(j + 1).y;
        }
        return (1 - t) * deCasteljauY(i - 1, j, t) + t * deCasteljauY(i - 1, j + 1, t);
    }

    private float deCasteljauX(int i, int j, float t) {
        if (i == 1) {
            return (1 - t) * mControlPoints.get(j).x + t * mControlPoints.get(j + 1).x;
        }
        return (1 - t) * deCasteljauX(i - 1, j, t) + t * deCasteljauX(i - 1, j + 1, t);
    }
}
