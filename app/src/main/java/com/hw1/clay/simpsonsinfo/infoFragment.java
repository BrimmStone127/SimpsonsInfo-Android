package com.hw1.clay.simpsonsinfo;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Clay on 9/30/2017.
 */

public class infoFragment extends Fragment {

    private TextView quoteView = null;
    private ImageView characterpic = null;
    private int current_index = -1;
    private int quoteArrayLen;

    private static final String TAG = "QuoteFragment";

    public int getShownIndex(){return current_index;}

    public void showQuoteAtIndex(int newIndex){
        if(newIndex < 0 || newIndex >= quoteArrayLen)
            return;
        current_index = newIndex;
        quoteView.setText(HomeActivity.quoteArray[current_index]);
        //Set up a TypedArray and then get resource ID of image
        TypedArray images = getResources().obtainTypedArray(R.array.characterpics);
        characterpic.setImageResource(images.getResourceId(current_index,-1));
        images.recycle();
    }

    //Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout defined in quote_fragment.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.quote_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        quoteView     = (TextView) getActivity().findViewById(R.id.quoteView);
        characterpic = (ImageView) getActivity().findViewById(R.id.characterpic);
        quoteArrayLen = HomeActivity.quoteArray.length;
    }
}
