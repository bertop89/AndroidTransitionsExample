package com.bertop.transitions.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.bertop.transitions.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alberto Polidura on 6/02/14.
 */
public class ListActivity extends Activity {

    ListView mainList;
    String[] items = new String[]{"Long","Click", "Any", "Of", "These", "Items"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_controls);
        mainList = (ListView)findViewById(R.id.mainList);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> spinneradapter = ArrayAdapter.createFromResource(this,
                R.array.transitions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(spinneradapter);
        spinner.setSelection(0);

        final List<String> list = new ArrayList<String>(Array.getLength(items));
        Collections.addAll(list, items);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, list);
        mainList.setAdapter(adapter);
        mainList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
                if (spinner.getSelectedItemPosition()==0) {
                    view.animate().setDuration(1000).alpha(0).withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            list.remove(position);
                            adapter.notifyDataSetChanged();
                            view.setAlpha(1);
                        }
                    });
                } else {
                    view.animate().setDuration(300).translationX(1200).withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            list.remove(position);
                            adapter.notifyDataSetChanged();
                            view.setTranslationX(0);
                        }
                    });

                }
                return false;
            }
        });
    }
}
