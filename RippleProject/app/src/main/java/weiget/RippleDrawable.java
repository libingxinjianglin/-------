package weiget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class RippleDrawable extends Drawable {
    private Paint mPaint;
    private float mStartX;
    private float mStartY;
    private float mRadio = 20;
    public RippleDrawable(){
        // ARGB 0xFF FF FF FF
        setColorFilter(new LightingColorFilter(0xFF0000FF,0xFFFFFFFF));
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
    }
    /**
     * 进行绘制
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        //canvas.drawColor(Color.BLUE);
        canvas.drawCircle(200,300,mRadio,mPaint);

    }

    /**
     * 进行设置透明度
     * @param i
     */
    @Override
    public void setAlpha(int i) {

    }

    /**
     * 进行颜色滤镜
     * @param colorFilter
     */
    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    /**
     * 获得透明的
     * @return
     */
    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
    public void onTouchEvent(MotionEvent event) {
        mRadio = mRadio + 20;
        invalidateSelf();
    }
}
