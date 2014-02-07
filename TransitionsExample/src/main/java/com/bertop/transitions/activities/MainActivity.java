package com.bertop.transitions.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bertop.transitions.R;

public class MainActivity extends Activity {

    ListView mainList;
    String[] transitions = new String[]{
            "First Transition",
            "Second Transition",
            "Third Transition",
            "Card Flip",
            "View Animation",
            "ListActivity",
            "Gallery"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainList = (ListView)findViewById(R.id.mainList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, transitions);
        mainList.setAdapter(adapter);
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                if (position==6) {
                    intent = new Intent(view.getContext(),ActivityAnimations.class);
                } else if (position==5) {
                    intent = new Intent(view.getContext(),ListActivity.class);
                } else if (position==4) {
                    intent = new Intent(view.getContext(),ViewAnimationActivity.class);
                } else if (position==3) {
                    intent = new Intent(view.getContext(),CardFlipActivity.class);
                } else {
                    intent = new Intent(view.getContext(),SingleTransitionActivity.class);
                    intent.putExtra("type", position);
                }
                startActivity(intent);
                overridePendingTransition(R.animator.push_left_in,R.animator.push_left_out);
            }
        });

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
