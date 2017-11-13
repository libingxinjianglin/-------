package weiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class RippleButton extends Button {
    protected RippleDrawable mDrawable;
    private float mStartX;
    private float mStartY;
    private float mRadio = 20;
    private Paint mPaint;
    public RippleButton(Context context) {
        super(context,null);
    }

    public RippleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mDrawable = new RippleDrawable();
    }

    public RippleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mDrawable.draw(canvas);
        super.onDraw(canvas);
        canvas.drawCircle(200,300,mRadio,mPaint);
        mDrawable.setCallback(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
      super.onSizeChanged(w,h,oldw,oldh);
        mDrawable.setBounds(w,h,getWidth(),getHeight());
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        return who == mDrawable || super.verifyDrawable(who);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //invalidate();
        mDrawable.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
