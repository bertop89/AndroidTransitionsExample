package com.bertop.transitions.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bertop.transitions.R;

/**
 * Created by Alberto Polidura on 6/02/14.
 */
public class ViewAnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_animation);
    }

    public void imageClicked(View thumbnailView) {
        ImageView thumbnail = (ImageView)thumbnailView;
        ImageView animatedImage = (ImageView) findViewById(R.id.animatedImage);
        animatedImage.setImageDrawable(thumbnail.getDrawable());
        animatedImage.setVisibility(View.VISIBLE);

        Animation animation
                = AnimationUtils.loadAnimation(this, R.animator.scale);
        animatedImage.startAnimation(animation);
    }
}
