package com.bertop.transitions.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bertop.transitions.R;

/**
 * Created by Alberto Polidura on 4/02/14.
 */
public class SecondTransition extends Fragment {

    public SecondTransition() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transition_scene_1, container, false);
        final Scene scene = Scene.getSceneForLayout(container,
                R.layout.fragment_transition_scene_3, getActivity());
        Button goButton = (Button)rootView.findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(scene);
            }
        });
        return rootView;
    }
}
