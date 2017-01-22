package school.it.ru.canvas_1practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MyDraw extends View {
    Paint p;
    float speed = 10;
    float angle;
    float xStartLine = 230, yStartLine = 220, xEndLine = 330, yEndLine = 220;
    public MyDraw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(80, 102, 204, 255);
        p.setStrokeWidth(5);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLUE);
        canvas.drawCircle(xStartLine,yStartLine, 100, p);
        p.setColor(Color.LTGRAY);
        canvas.drawCircle(375,170,50,p);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        angle+=speed;
        xEndLine = 100 * (float) Math.cos(Math.toRadians(angle));
        yEndLine = 100 * (float) Math.sin(Math.toRadians(angle));
        p.setColor(Color.BLUE);
        canvas.drawLine(xStartLine,yStartLine,230 + xEndLine,220 + yEndLine, p);
        xEndLine = 50 * (float) Math.cos(Math.toRadians(angle));
        yEndLine = 50 * (float) Math.sin(Math.toRadians(angle));
        p.setColor(Color.LTGRAY);
        canvas.drawLine(375,170,375 + xEndLine,170 + yEndLine,p);
        invalidate();
    }
}
