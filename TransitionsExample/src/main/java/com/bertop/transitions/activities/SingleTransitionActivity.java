package com.bertop.transitions.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bertop.transitions.R;
import com.bertop.transitions.fragments.FirstTransition;
import com.bertop.transitions.fragments.SecondTransition;
import com.bertop.transitions.fragments.ThirdTransition;

/**
 * Created by Alberto Polidura on 4/02/14.
 */
public class SingleTransitionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        int type = getIntent().getIntExtra("type",0);
        Fragment fragment;
        switch (type) {
            case 0:
                fragment = new FirstTransition();
                break;
            case 1:
                fragment = new SecondTransition();
                break;
            case 2:
                fragment = new ThirdTransition();
                break;
            default:
                fragment = new FirstTransition();
                break;
        }

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
