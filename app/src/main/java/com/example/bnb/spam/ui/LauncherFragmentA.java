package com.example.bnb.spam.ui;

//import co.snagapp.android.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bnb.spam.R;

public class LauncherFragmentA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.launcher_fragment_a, container, false);

        return rootView;
    }
}