package com.bertop.transitions.activities;

import android.app.Activity;

import com.bertop.transitions.R;

/**
 * Created by Alberto Polidura on 7/02/14.
 */
public abstract class BaseActivity extends Activity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.push_right_in,R.animator.push_right_out);
    }

}
