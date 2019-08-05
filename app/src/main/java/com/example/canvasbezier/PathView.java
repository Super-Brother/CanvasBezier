package com.example.canvasbezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class PathView extends View {

    private Path mPath = new Path();
    private Paint mPaint = new Paint();

    public PathView(Context context) {
        super(context);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        mPaint.setStyle(Paint.Style.FILL);
        //一阶贝塞尔曲线
//        mPath.moveTo(100, 70);
////        mPath.lineTo(140, 800);
//        //lineTo:相对于原点坐标；rLineTo:相对于上一个坐标;
//        mPath.rLineTo(140, 800);
//        mPath.lineTo(250, 600);
//        mPath.close();

        //添加圆弧
//        mPath.addArc(200, 200, 400, 400, -225, 225);
////        //添加矩形（CW：顺时针绘制；CCW：逆时针绘制；）
////        mPath.addRect(500, 500, 900, 900, Path.Direction.CW);
////        //添加圆形
////        mPath.addCircle(700, 700, 200, Path.Direction.CW);
////        //添加椭圆形
////        mPath.addOval(0, 0, 500, 300, Path.Direction.CCW);

        //追加图形
//        mPath.arcTo(400, 200, 600, 400, -180, 225, false);

        //forceMove, true：绘制时移动起点；false：绘制时连接最后一个点和圆弧起点
//        mPath.moveTo(0, 0);
//        mPath.lineTo(100, 100);
//        mPath.arcTo(400, 200, 600, 400, 0, 270, true);

//        mPath.moveTo(100, 70);
//        mPath.lineTo(140, 180);
//        mPath.lineTo(250, 330);
//        mPath.lineTo(400, 630);
//        mPath.lineTo(100, 830);
//        Path newPath = new Path();
//        newPath.moveTo(100, 1000);
//        newPath.lineTo(600, 1300);
//        newPath.lineTo(400, 1700);
//        mPath.addPath(newPath);

        //添加圆角矩形
//        RectF rectF = new RectF(200, 800, 700, 1200);
//        mPath.addRoundRect(rectF, 20, 20, Path.Direction.CCW);

        //画二阶贝塞尔曲线
//        mPath.moveTo(300, 500);
//        mPath.quadTo(500, 100, 800,500);
//        mPath.rQuadTo(200, -400, 500, 0);

        //画三阶贝塞尔曲线
//        mPath.moveTo(300, 500);
//        mPath.cubicTo(500,100,600,1200,800,500);
//        mPath.rCubicTo(200, -400, 300, 700, 500, 0);


        canvas.drawPath(mPath, mPaint);
    }
}
