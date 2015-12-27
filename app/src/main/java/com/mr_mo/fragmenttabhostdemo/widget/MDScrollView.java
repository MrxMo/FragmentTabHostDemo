package com.mr_mo.fragmenttabhostdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * http://fine36.blog.163.com/blog/static/189251005201521194330347/
 * Created by moguangjian on 15/8/11 15:27.
 */
public class MDScrollView extends ScrollView {
    private float xDistance;
    private float yDistance;
    private float xLast;
    private float yLast;

    private OnScrollListener onScrollListener;

    public interface OnScrollListener {
        void onScroll(int scrollY);
    }

    public MDScrollView(Context context) {
        super(context);
    }

    public MDScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MDScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollListener != null) {
            onScrollListener.onScroll(t);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;

                if (xDistance > yDistance) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(ev);
    }

}
