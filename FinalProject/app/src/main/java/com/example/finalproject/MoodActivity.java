package com.example.finalproject;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MoodActivity extends AppCompatActivity {

    private ImageView img_rating_bar;
    private SeekBar seek_bar;
    private int mProgress;
    int prog = 0;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        Log.d("mood", "here");

        img_rating_bar = findViewById(R.id.img_rating_bar);
        seek_bar = findViewById(R.id.seek_bar);

        seek_bar.setProgressDrawable(ContextCompat.getDrawable(MoodActivity.this, R.drawable.seekbar_progress_task));
        seek_bar.setProgress(4);

        seek_bar.setMax(9);


        if (!FinalProjectprefs.containKeyDevice(this,"MOOD_INFO")) {
            ValueAnimator anim = ValueAnimator.ofInt(0, 10);
            anim.setDuration(3000);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int animProgress = (Integer) animation.getAnimatedValue();
                    seek_bar.setProgress(animProgress);
                }
            });
            anim.start();

            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            FinalProjectprefs.putStringFlagValue(this,"MOOD_INFO", "1");
        }

        if(FinalProjectprefs.getStringFlagValue(this,"MOOD_INFO", "1") != null){
            seek_bar.setProgress(Integer.parseInt(FinalProjectprefs.getStringFlagValue(this,"MOOD_INFO", "1")));
            setSeekValue(Integer.parseInt(FinalProjectprefs.getStringFlagValue(this,"MOOD_INFO", "1")));
        }

        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                prog = progress;

                FinalProjectprefs.putStringFlagValue(MoodActivity.this,"MOOD_INFO", ""+prog);
                setSeekValue(progress);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        FinalProjectprefs.putStringFlagValue(this,"MOOD_INFO", ""+seek_bar.getProgress());
        super.onBackPressed();

    }

    /*
    set the stress image according to progress
     */
    private void setSeekValue(int progress) {

        img_rating_bar.setBackground(null);

        switch (progress) {
            case 0:
                mProgress = 1;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_1));
                break;

            case 1:
                mProgress = 2;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_2));
                break;

            case 2:
                mProgress = 3;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_3));
                break;

            case 3:
                mProgress = 4;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_4));
                break;

            case 4:
                mProgress = 5;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_5));
                break;

            case 5:
                mProgress = 6;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_6));
                break;

            case 6:
                mProgress = 7;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_7));
                break;

            case 7:
                mProgress = 8;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_8));
                break;

            case 8:
                mProgress = 9;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_9));
                break;

            case 9:
                mProgress = 10;
                img_rating_bar.setBackground(getResources().getDrawable(R.drawable.mood_10));
                break;
        }
    }

}
