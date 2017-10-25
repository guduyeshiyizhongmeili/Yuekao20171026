package com.example.dell.myapplication;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    private int time=0;
    private ImageView img;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time++;
            handler.sendEmptyMessageDelayed(0,1000);
            if(time==3){
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        img = (ImageView) findViewById(R.id.img);
        handler.sendEmptyMessageDelayed(0,1000);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
        {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue)
            {
                //  Log.e(TAG, fraction * 3 + "");
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 200 * fraction * 3;
                return point;
            }
        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                img.setX(point.x);
                img.setY(point.y);
            }
        });
    }

}
