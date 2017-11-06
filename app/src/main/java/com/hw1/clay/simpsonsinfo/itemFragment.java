package com.hw1.clay.simpsonsinfo;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Clay on 9/30/2017.
 */

public class itemFragment extends ListFragment {

    private ListSelectionListener list_listener = null;
    private static final String TAG = "ItemsFragment";

    // Callback interface that allows this Fragment to notify the HomeActivity when
    // user clicks on a List Item
    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    //This method will be called when an item in the list is selected. Subclasses should override.
    // Subclasses can call getListView().getItemAtPosition(position) if they need to access the data
    // associated with the selected item.
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id){

        //indicates the selected item has been checked
        getListView().setItemChecked(pos, true);

        //Inform the HomeActivity that the item in position pos has been selected
        list_listener.onListSelection(pos);

    }//end of onListItemClick

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // Set the ListSelectionListener for communicating with the HomeActivity
            list_listener = (ListSelectionListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnArticleSelectedListener");
        }
    }

    //Called to have the fragment instantiate its user interface view. This is optional, and
    // non-graphical fragments can return null (which is the default implementation). This will be
    // called between onCreate(Bundle) and onActivityCreated(Bundle).
    //If you return a View from here, you will later be called in onDestroyView() when the view is being released.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ){
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Called when the fragment's activity has been created and this fragment's view hierarchy
    // instantiated. It can be used to do final initialization once these pieces are in place, such
    // as retrieving views or restoring state. It is also useful for fragments that use
    // setRetainInstance(boolean) to retain their instance, as this callback tells the fragment when
    // it is fully associated with the new activity instance. This is called after
    // onCreateView(LayoutInflater, ViewGroup, Bundle) and before onViewStateRestored(Bundle).
    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        // Set the list choice mode to allow only one selection at a time
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Set the list adapter for the ListView
        // Discussed in more detail in the user interface classes lesson
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.title_item, HomeActivity.itemArray));
    }

}//end of itemFragment
