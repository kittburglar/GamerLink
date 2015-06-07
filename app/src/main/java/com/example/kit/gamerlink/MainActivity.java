package com.example.kit.gamerlink;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView steamExpListView;
    ExpandableListView originExpListView;
    ExpandableListView otherExpListView;
    ExpandableListView ps4ExpListView;
    ExpandableListView xboxoneExpListView;
    ExpandableListView macSteamExpListView;
    ExpandableListView macOtherExpListView;
    List<ExpandableListView> listExpViews;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        steamExpListView = (ExpandableListView) findViewById(R.id.steam);

        // preparing list data

        prepareListData("STEAM");

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        steamExpListView.setAdapter(listAdapter);


        // Listview Group click listener
        steamExpListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        steamExpListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                setListViewHeightBasedOnItems(steamExpListView);


                TextView textHeader = (TextView) steamExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
                textHeader.setText("View All");
                textHeader.postInvalidate();

                originExpListView.collapseGroup(0);
                otherExpListView.collapseGroup(0);
                ps4ExpListView.collapseGroup(0);
                xboxoneExpListView.collapseGroup(0);
                macSteamExpListView.collapseGroup(0);
                macOtherExpListView.collapseGroup(0);

                return;
            }
        });

        // Listview Group collasped listener
        steamExpListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            /*
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();
            */

                TextView textHeader = (TextView) steamExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.LEFT);
                textHeader.setTextSize(18);
                //textHeader.setPadding(35, 10, 0, 10);
                textHeader.setText("All Games");


                setListViewHeightBasedOnItems(steamExpListView);

            /*
            TextView textHeader = (TextView) steamExpListView.findViewById(R.id.textView5);
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            textHeader.setText("View All");
            textHeader.postInvalidate();
            */


                return;
            }
        });

        // Listview on child click listener
        steamExpListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // get the listview
        originExpListView = (ExpandableListView) findViewById(R.id.origin);

        // preparing list data

        prepareListData("ORIGIN");

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        originExpListView.setAdapter(listAdapter);


        // Listview Group click listener
        originExpListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        originExpListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                setListViewHeightBasedOnItems(originExpListView);


                TextView textHeader = (TextView) originExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
                textHeader.setText("View All");
                textHeader.postInvalidate();

                steamExpListView.collapseGroup(0);
                otherExpListView.collapseGroup(0);
                ps4ExpListView.collapseGroup(0);
                xboxoneExpListView.collapseGroup(0);
                macSteamExpListView.collapseGroup(0);
                macOtherExpListView.collapseGroup(0);

                return;
            }
        });

        // Listview Group collasped listener
        originExpListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            /*
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();
            */

                TextView textHeader = (TextView) originExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.LEFT);
                textHeader.setTextSize(18);
                //textHeader.setPadding(35, 10, 0, 10);
                textHeader.setText("All Games");


                setListViewHeightBasedOnItems(originExpListView);

            /*
            TextView textHeader = (TextView)originExpListView.findViewById(R.id.textView5);
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            textHeader.setText("View All");
            textHeader.postInvalidate();
            */


                return;
            }
        });

        // Listview on child click listener
        originExpListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });



        // get the listview
        otherExpListView = (ExpandableListView) findViewById(R.id.other);

        // preparing list data

        prepareListData("OTHER");

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        otherExpListView.setAdapter(listAdapter);


        // Listview Group click listener
        otherExpListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        otherExpListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                setListViewHeightBasedOnItems(otherExpListView);


                TextView textHeader = (TextView)otherExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
                textHeader.setText("View All");
                textHeader.postInvalidate();

                steamExpListView.collapseGroup(0);
                originExpListView.collapseGroup(0);
                ps4ExpListView.collapseGroup(0);
                xboxoneExpListView.collapseGroup(0);
                macSteamExpListView.collapseGroup(0);
                macOtherExpListView.collapseGroup(0);

                return;
            }
        });

        // Listview Group collasped listener
        otherExpListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            /*
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();
            */

                TextView textHeader = (TextView)otherExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.LEFT);
                textHeader.setTextSize(18);
                //textHeader.setPadding(35, 10, 0, 10);
                textHeader.setText("All Games");


                setListViewHeightBasedOnItems(otherExpListView);

            /*
            TextView textHeader = (TextView)otherExpListView.findViewById(R.id.textView5);
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            textHeader.setText("View All");
            textHeader.postInvalidate();
            */


                return;
            }
        });

        // Listview on child click listener
        otherExpListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // get the listview
        ps4ExpListView = (ExpandableListView) findViewById(R.id.ps4);

        // preparing list data

        prepareListData("PS4");

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        ps4ExpListView.setAdapter(listAdapter);


        // Listview Group click listener
        ps4ExpListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        ps4ExpListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                setListViewHeightBasedOnItems(ps4ExpListView);


                TextView textHeader = (TextView)ps4ExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
                textHeader.setText("View All");
                textHeader.postInvalidate();

                steamExpListView.collapseGroup(0);
                originExpListView.collapseGroup(0);
                otherExpListView.collapseGroup(0);
                xboxoneExpListView.collapseGroup(0);
                macSteamExpListView.collapseGroup(0);
                macOtherExpListView.collapseGroup(0);

                return;
            }
        });

        // Listview Group collasped listener
        ps4ExpListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            /*
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();
            */

                TextView textHeader = (TextView)ps4ExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.LEFT);
                textHeader.setTextSize(18);
                //textHeader.setPadding(35, 10, 0, 10);
                textHeader.setText("All Games");


                setListViewHeightBasedOnItems(ps4ExpListView);

            /*
            TextView textHeader = (TextView)ps4ExpListView.findViewById(R.id.textView5);
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            textHeader.setText("View All");
            textHeader.postInvalidate();
            */


                return;
            }
        });

        // Listview on child click listener
        ps4ExpListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // get the listview
        xboxoneExpListView = (ExpandableListView) findViewById(R.id.xboxone);

        // preparing list data

        prepareListData("XBOX ONE");

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        xboxoneExpListView.setAdapter(listAdapter);


        // Listview Group click listener
        xboxoneExpListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        xboxoneExpListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                setListViewHeightBasedOnItems(xboxoneExpListView);


                TextView textHeader = (TextView)xboxoneExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
                textHeader.setText("View All");
                textHeader.postInvalidate();

                steamExpListView.collapseGroup(0);
                originExpListView.collapseGroup(0);
                otherExpListView.collapseGroup(0);
                ps4ExpListView.collapseGroup(0);
                macSteamExpListView.collapseGroup(0);
                macOtherExpListView.collapseGroup(0);

                return;
            }
        });

        // Listview Group collasped listener
        xboxoneExpListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            /*
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();
            */

                TextView textHeader = (TextView)xboxoneExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.LEFT);
                textHeader.setTextSize(18);
                //textHeader.setPadding(35, 10, 0, 10);
                textHeader.setText("All Games");


                setListViewHeightBasedOnItems(xboxoneExpListView);

            /*
            TextView textHeader = (TextView)xboxoneExpListView.findViewById(R.id.textView5);
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            textHeader.setText("View All");
            textHeader.postInvalidate();
            */


                return;
            }
        });

        // Listview on child click listener
        xboxoneExpListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // get the listview
        macSteamExpListView = (ExpandableListView) findViewById(R.id.macsteam);

        // preparing list data

        prepareListData("STEAM");

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        macSteamExpListView.setAdapter(listAdapter);


        // Listview Group click listener
        macSteamExpListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        macSteamExpListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                setListViewHeightBasedOnItems(macSteamExpListView);


                TextView textHeader = (TextView)macSteamExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
                textHeader.setText("View All");
                textHeader.postInvalidate();

                steamExpListView.collapseGroup(0);
                originExpListView.collapseGroup(0);
                otherExpListView.collapseGroup(0);
                ps4ExpListView.collapseGroup(0);
                xboxoneExpListView.collapseGroup(0);
                macOtherExpListView.collapseGroup(0);

                return;
            }
        });

        // Listview Group collasped listener
        macSteamExpListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            /*
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();
            */

                TextView textHeader = (TextView)macSteamExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.LEFT);
                textHeader.setTextSize(18);
                //textHeader.setPadding(35, 10, 0, 10);
                textHeader.setText("All Games");


                setListViewHeightBasedOnItems(macSteamExpListView);

            /*
            TextView textHeader = (TextView)macSteamExpListView.findViewById(R.id.textView5);
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            textHeader.setText("View All");
            textHeader.postInvalidate();
            */


                return;
            }
        });

        // Listview on child click listener
        macSteamExpListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // get the listview
        macOtherExpListView = (ExpandableListView) findViewById(R.id.macother);

        // preparing list data

        prepareListData("OTHER");

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        macOtherExpListView.setAdapter(listAdapter);


        // Listview Group click listener
        macOtherExpListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        macOtherExpListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {


                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                setListViewHeightBasedOnItems(macOtherExpListView);


                TextView textHeader = (TextView)macOtherExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
                textHeader.setText("View All");
                textHeader.postInvalidate();

                steamExpListView.collapseGroup(0);
                originExpListView.collapseGroup(0);
                otherExpListView.collapseGroup(0);
                ps4ExpListView.collapseGroup(0);
                xboxoneExpListView.collapseGroup(0);
                macSteamExpListView.collapseGroup(0);

                return;
            }
        });

        // Listview Group collasped listener
        macOtherExpListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            /*
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();
            */

                TextView textHeader = (TextView)macOtherExpListView.findViewById(R.id.textView5);
                textHeader.setGravity(Gravity.LEFT);
                textHeader.setTextSize(18);
                //textHeader.setPadding(35, 10, 0, 10);
                textHeader.setText("All Games");


                setListViewHeightBasedOnItems(macOtherExpListView);

            /*
            TextView textHeader = (TextView)macOtherExpListView.findViewById(R.id.textView5);
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setGravity(Gravity.CENTER_HORIZONTAL);
            textHeader.setText("View All");
            textHeader.postInvalidate();
            */


                return;
            }
        });

        // Listview on child click listener
        macOtherExpListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

    }
    /*
     * Preparing the list data
     */
    private void prepareListData(String header) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(header);
        //listDataHeader.add("Now Showing");
        //listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> steam = new ArrayList<String>();
        steam.add("Archage");
        steam.add("Battlefield 4");
        steam.add("Borderlands");
        steam.add("Borderlands 2");
        steam.add("Borderlands The Pre-Sequel");
        steam.add("Civilization I");
        steam.add("Civilization II");
        steam.add("Civilization III");
        steam.add("Civilization IV");
        steam.add("Civilization V");

        listDataChild.put(listDataHeader.get(0), steam); // Header, Child data, kxayasan
    }

    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }

    }
}
