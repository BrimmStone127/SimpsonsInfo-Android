package com.hw1.clay.simpsonsinfo;

/**
 * Created by Clay on 10/11/2017.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dmlics on 10/24/16.
 */

public class WhoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.who_fragment,
                container, false);

        return view;
    }
}