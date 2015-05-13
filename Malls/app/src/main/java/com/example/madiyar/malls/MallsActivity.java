package com.example.madiyar.malls;

import android.content.Intent;
import android.os.Bundle;


import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MallsActivity extends ListActivity {

    Button settings, wishlist, search;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_malls, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //When Sync action button is clicked
        if (id == R.id.settings) {
            Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.wishlist) {
            Toast.makeText(getApplicationContext(), "wishlist", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
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