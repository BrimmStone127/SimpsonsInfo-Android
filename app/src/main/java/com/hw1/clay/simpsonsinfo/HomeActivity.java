package com.hw1.clay.simpsonsinfo;

import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.hw1.clay.simpsonsinfo.itemFragment.ListSelectionListener;

public class HomeActivity extends AppCompatActivity implements ListSelectionListener{

    public static String[] itemArray;
    public static String[] quoteArray;
    private infoFragment infoFrag;
    private FrameLayout frameLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the string arrays with the titles and quotes
        itemArray = getResources().getStringArray(R.array.Characters);
        quoteArray = getResources().getStringArray(R.array.Quote);

        setContentView(R.layout.activity_home);

        if (savedInstanceState == null){
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MainFragment fragment = new MainFragment();
            ft.add(R.id.displayFragment,fragment);
            ft.addToBackStack("");
            ft.commit();
        }

        //Get a reference to infoFragment
        infoFrag = (infoFragment) getFragmentManager().findFragmentById(R.id.info);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu;
        //This code adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // this function handles user's selection of a menu item
        // Declare a Fragment object
        //Fragment f;
        // declare a FragmentTransaction object
        FragmentTransaction ft;
        //InputMethodManager imm;
        Context context = getApplicationContext();
        CharSequence toasttext = "Message Here!";
        int duration = Toast.LENGTH_LONG;
        {
            switch (item.getItemId()){
                case R.id.action_help:
                    toasttext = "User selected help";
                    Toast.makeText(context, toasttext, duration).show();
                    HelpFragment helpfragment = new HelpFragment();
                    ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.displayFragment, helpfragment);
                    ft.commit();
                    break;
                case R.id.action_dev:
                    toasttext = "User selected help";
                    Toast.makeText(context, toasttext, duration).show();
                    DeveloperFragment devfragment = new DeveloperFragment();
                    ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.displayFragment, devfragment);
                    ft.commit();
                    break;
                case R.id.action_who:
                    toasttext = "User selected I am here.";
                    Toast.makeText(context, toasttext, duration).show();
                    WhoFragment whofragment = new WhoFragment();
                    ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.displayFragment, whofragment);
                    ft.commit();
                    break;
                case R.id.action_work:
                    toasttext = "User selected credits.";
                    Toast.makeText(context, toasttext, duration).show();
                    WorkFragment workfragment = new WorkFragment();
                    ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.displayFragment,workfragment);
                    ft.commit();
                    break;
                case R.id.action_back:
                    toasttext = "User cleared menu.";
                    Toast.makeText(context, toasttext, duration).show();
                    MainFragment mainFragment = new MainFragment();
                    ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.displayFragment,mainFragment);
                    ft.commit();
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
        return true;
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {
        if (infoFrag.getShownIndex() != index) {
            // Tell the QuoteFragment to show the quote string at position index
            infoFrag.showQuoteAtIndex(index);
        }
    }
}
