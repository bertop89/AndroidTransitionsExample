package com.bertop.transitions.activities;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.bertop.transitions.R;

/**
 * Created by Alberto Polidura on 25/02/14.
 */
public class ButtonAnimations extends BaseActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        v.animate()
                .translationYBy(-100)
                .setDuration(200)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .scaleXBy(1).scaleYBy(1)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        v.animate()
                                .setDuration(200)
                                .translationYBy(100)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .scaleXBy(-1)
                                .scaleYBy(-1);
                    }
                });
    }
}
