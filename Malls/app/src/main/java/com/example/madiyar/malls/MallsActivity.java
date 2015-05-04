package com.example.madiyar.malls;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.app.ListActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MallsActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[][] values = new String[][] { {"Aport", "The choice of Kaskelen's people"}, {"MEGA", "The most popular mall in KZ"},
                {"Dostyk Plaza", "The new one, and good one"}};
        MyArrayAdapter adapter = new MyArrayAdapter(this, values);
        setListAdapter(adapter);


        ListView list = getListView();
        list.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MallsActivity.this, "Item in position " + position + " clicked", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(MallsActivity.this, BoutiqueActivity.class);
        Bundle b = new Bundle();
        b.putInt("position", position);
        intent.putExtras(b);
        startActivity(intent);
    }
}